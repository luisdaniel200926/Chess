package Game;

import Game.*;
import Game.Pieces.Type;
import application.Main;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.PopupWindow;


public class Pawns extends Pieces implements ILimited{
	
	
	final int firstMove=16;
	private boolean firstStep;
	
	final int nextMove= 8;
	final int nextMove02=9;
	final int nextMove03=7;
	
	/**
	 * @param color
	 * @param type
	 * @param PosTiles
	 * @param eat
	 * @param firstStep
	 */
	public Pawns(String color, Type type, int PosTiles,boolean eat,boolean firstStep) {
		super(color, type, PosTiles, eat);
		setFirstStep(firstStep);
	}


		
	


	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovements(Game.Pieces[], Game.Pieces, javafx.scene.control.Button[])
	 */
	@Override
	public void possibleMovements(Pieces[] Pieces, Pieces piece, Button[] Buttons) {
		
		
		int i=piece.getPosTyle();
		int cases=0;
		
		Pawns Pawncito = (Pawns) Pieces[i];

		
		if(Pawncito.isFirstStep()){
			
			if(piece.getColor()=="WHITE") {
				//Move Front
				if(i-firstMove>=0) {
				
					if(Pieces[i-firstMove].getColor()=="BLANK") {
						if(!(boarderLimitationTop(i))) {
						cases++;
						
						Buttons[i-firstMove].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
						Buttons[i-firstMove].setDisable(false);
						Pieces[i-firstMove].setEat(true);
						
						SavePiece(Pieces[i]);
						}
					}
				
				}
			}else if(piece.getColor()=="BLACK") {
				
				if(i+firstMove<BOARD_Tiles) {
					
					if(Pieces[i+firstMove].getColor()=="BLANK") {
						if(!(boarderLimitationBottom(i))) {
						cases++;
						
						Buttons[i+firstMove].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
						Buttons[i+firstMove].setDisable(false);
						Pieces[i+firstMove].setEat(true);
						
						SavePiece(Pieces[i]);
						}
					}
				
				}
			}
			
			Pawncito.setFirstStep(false);
			
		}
	
		
		if(piece.getColor()=="WHITE") {
			//Move Front
			if(i-nextMove>=0) {
			
				if(Pieces[i-nextMove].getColor()=="BLANK") {
					if(!(boarderLimitationTop(i))) {
						
					
					cases++;
					
					Buttons[i-nextMove].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
					Buttons[i-nextMove].setDisable(false);
					Pieces[i-nextMove].setEat(true);
					
					SavePiece(Pieces[i]);
					}
				}
			
			}
			//Eat Left
			if(i-nextMove02>=0) {
				if(Pieces[i-nextMove02].getColor()=="BLACK") {
					if(!(boarderLimitationLeft(i)||boarderLimitationTop(i))) {
					cases++;
					
					Buttons[i-nextMove02].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
					Buttons[i-nextMove02].setDisable(false);
					Pieces[i-nextMove02].setEat(true);
					
					SavePiece(Pieces[i]);
					}
				}
			}	
			
			//Eat Right
			if(i-nextMove03>=0) {
				if(Pieces[i-nextMove03].getColor()=="BLACK") {
					if(!(boarderLimitationRight(i)||boarderLimitationTop(i))) {
					cases++;
					
					Buttons[i-nextMove03].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
					Buttons[i-nextMove03].setDisable(false);
					Pieces[i-nextMove03].setEat(true);
					
					SavePiece(Pieces[i]);
					}
				}
			}
		
		}else if(piece.getColor()=="BLACK") {
			
			if(i+nextMove<BOARD_Tiles) {
				
				if(Pieces[i+nextMove].getColor()=="BLANK") {
					if(!(boarderLimitationBottom(i))) {
					cases++;
					
					Buttons[i+nextMove].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
					Buttons[i+nextMove].setDisable(false);
					Pieces[i+nextMove].setEat(true);
					
					SavePiece(Pieces[i]);
					}
				}
			
			}
			//Eat Right
			if(i+nextMove02<BOARD_Tiles) {
				if(Pieces[i+nextMove02].getColor()=="WHITE") {
					if(!(boarderLimitationRight(i)||boarderLimitationBottom(i))) {
					cases++;
					
					Buttons[i+nextMove02].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
					Buttons[i+nextMove02].setDisable(false);
					Pieces[i+nextMove02].setEat(true);
					
					SavePiece(Pieces[i]);
					}
				}
			}	
			
			//Eat Left
			if(i+nextMove03<BOARD_Tiles) {
				if(Pieces[i+nextMove03].getColor()=="WHITE") {
					if(!(boarderLimitationLeft(i)||boarderLimitationTop(i))) {
					cases++;
					
					Buttons[i+nextMove03].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
					Buttons[i+nextMove03].setDisable(false);
					Pieces[i+nextMove03].setEat(true);
					
					SavePiece(Pieces[i]);
					}
				}
			}
			
		}else {
			
		}

		if(cases>0) {
		for(int j=0;j<BOARD_Tiles;j++) {
			if(Pieces[j].isEat()) {
				Buttons[j].setDisable(false);
			}else {
				Buttons[j].setDisable(true);
			}
			
		}
	}
  
	
}

	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovementsVsKingAll(Game.Pieces[], Game.Pieces)
	 */
	@Override
	public boolean possibleMovementsVsKingAll(Pieces[] Pieces, Pieces piece) {
		
		int i=piece.getPosTyle();
		
		if(piece.getColor()=="WHITE") {
			
			//Eat Left
			if(i-nextMove02>=0) {
				if(Pieces[i-nextMove02].getColor()=="BLACK" && Pieces[i-nextMove02].getType()==Type.King) {
					if(!(boarderLimitationLeft(i)||boarderLimitationTop(i))) {
						return true;
					}
				}
			}	
			
			//Eat Right
			if(i-nextMove03>=0) {
				if(Pieces[i-nextMove03].getColor()=="BLACK" && Pieces[i-nextMove03].getType()==Type.King) {
					if(!(boarderLimitationRight(i)||boarderLimitationTop(i))) {
						return true;
					}
				}
			}
		
		}else if(piece.getColor()=="BLACK") {
			
			
			//Eat Right
			if(i+nextMove02<BOARD_Tiles) {
				if(Pieces[i+nextMove02].getColor()=="WHITE" && Pieces[i-+nextMove02].getType()==Type.King) {
					if(!(boarderLimitationRight(i)||boarderLimitationBottom(i))) {
						return true;
					}
				}
			}	
			
			//Eat Left
			if(i+nextMove03<BOARD_Tiles) {
				if(Pieces[i+nextMove03].getColor()=="WHITE" && Pieces[i+nextMove03].getType()==Type.King) {
					if(!(boarderLimitationLeft(i)||boarderLimitationTop(i))) {
					
					
					return true;
					}
				}
			}
			
		}else {
			
		}
		return false;
		
	}

	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovementsVsKing(Game.Pieces[], Game.Pieces, Game.Pieces, javafx.scene.control.Button[])
	 */
	@Override
	public boolean possibleMovementsVsKing(Pieces[] Pieces, Pieces CheckedPiece, Pieces piece, Button[] Buttons) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see Game.ILimited#boarderLimitationRight(int)
	 */
	@Override
	public boolean boarderLimitationRight( int isummatory) {
		
		int BoandaryRight[]= {7,15,23,31,39,47,55,63};
		for(int j=0;j<BoandaryRight.length;j++) {
			
			if(isummatory==BoandaryRight[j]) {
				return true;
			}
			
		}
		
		
		
		return false;
	}
	/* (non-Javadoc)
	 * @see Game.ILimited#boarderLimitationLeft(int)
	 */
	@Override
	public boolean boarderLimitationLeft( int isummatory) {
		
		int BoandaryLeft[]= {0,8,16,24,32,40,48,56};
		for(int j=0;j<BoandaryLeft.length;j++) {
			
			if(isummatory==BoandaryLeft[j]) {
				
				return true;
			}
			
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see Game.ILimited#boarderLimitationTop(int)
	 */
	@Override
	public boolean boarderLimitationTop( int isummatory) {
		
		int BoandaryLeft[]= {0,1,2,3,4,5,6,7};
		for(int j=0;j<BoandaryLeft.length;j++) {
			
			if(isummatory==BoandaryLeft[j]) {
				
				return true;
			}
			
		}
		
		return false;
	}
	/* (non-Javadoc)
	 * @see Game.ILimited#boarderLimitationBottom(int)
	 */
	@Override
	public boolean boarderLimitationBottom( int isummatory) {
	
	int BoandaryLeft[]= {56,57,58,59,60,61,62,63};
	for(int j=0;j<BoandaryLeft.length;j++) {
		
		if(isummatory==BoandaryLeft[j]) {
			
			return true;
		}
		
	}
	
	return false;
}






	/**
	 * @return the firstStep
	 */
	/**
	 * @return
	 */
	public boolean isFirstStep() {
		return firstStep;
	}



	/**
	 * @param firstStep the firstStep to set
	 */
	/**
	 * @param firstStep
	 */
	public void setFirstStep(boolean firstStep) {
		this.firstStep = firstStep;
	}


/* (non-Javadoc)
 * @see Game.Pieces#changePieces(Game.Pieces[], Game.Pieces, Game.Pieces, javafx.scene.image.ImageView[], javafx.scene.control.Button[])
 */
@Override
public void changePieces(Pieces[] Pieces, Pieces EaterPiece, Pieces EatablePiece, ImageView[] Images,Button[] Buttons) {
		
		
		Image White = new Image("Chees_Images/White.JPG");
		int Eateri=EaterPiece.getPosTyle();
		int Eatablei=EatablePiece.getPosTyle();
		Pieces KingPieceW=null;
		Pieces KingPieceB=null;
		
		if(Pieces[Eatablei].getType()==Type.King) {
			for(int j=0;j<BOARD_Tiles;j++) {
				Buttons[j].setDisable(true);
			}
			if(Pieces[Eatablei].getColor()=="BLACK") {
				Buttons[67].setDisable(false);
				Buttons[67].setVisible(true);
				return;
			}else if(Pieces[Eatablei].getColor()=="WHITE"){
				Buttons[66].setDisable(false);
				Buttons[66].setVisible(true);
				return;
			}
			
		}
		
		
		
		SetNullEat(Buttons, Pieces);
		
		Pieces auxPiece;
		auxPiece=Pieces[Eatablei];
		Pieces[Eatablei]=Pieces[Eateri];
		Pieces[Eateri]=auxPiece;
		
		int auxTyle;
		auxTyle=Pieces[Eatablei].getPosTyle();
		Pieces[Eatablei].setPosTyle(Pieces[Eateri].getPosTyle());
		Pieces[Eateri].setPosTyle(auxTyle);
		
		Image auxImage;
		auxImage=Images[Eatablei].getImage();
		Images[Eatablei].setImage(Images[Eateri].getImage());
		Images[Eateri].setImage(auxImage);
		
		if(!(EatablePiece.getColor()=="BLANK")) {
			Pieces[Eateri].setType(Type.Blank);
			Pieces[Eateri].setColor("BLANK");
			Images[Eateri].setImage(White);
		}
		
		
		//Promotion
		if(Pieces[Eatablei].getColor()=="WHITE") {
			if(boarderLimitationTop(Eatablei)) {
				
				Pieces Promote=Main.Promote(Pieces[Eatablei]);
				
				if(Promote.getType()==Type.Queen) {
					Pieces[Eatablei].setType(Type.Queen);
					
				}else if(Promote.getType()==Type.Bishop) {
					Pieces[Eatablei].setType(Type.Bishop);
					
				}else if(Promote.getType()==Type.Rook) {
					Pieces[Eatablei].setType(Type.Rook);
					
				}else if(Promote.getType()==Type.Knight) {
					
					
				}
				Main.setImages();
			}
		}else if(Pieces[Eatablei].getColor()=="BLACK") {
			if(boarderLimitationBottom(Eatablei)) {

				 Main.Promote(Pieces[Eatablei]);
				 Pieces Promote;
				Promote = Main.returnerWanted();
				
				if(Promote.getType()==Type.Queen) {
					Pieces[Eatablei].setType(Type.Queen);
					
				}else if(Promote.getType()==Type.Bishop) {
					Pieces[Eatablei].setType(Type.Bishop);
					
				}else if(Promote.getType()==Type.Rook) {
					Pieces[Eatablei].setType(Type.Rook);
					
				}else if(Promote.getType()==Type.Knight) {
					
					
				}
				Main.setImages();
			}
			
		}
		
		for(int i=0;i<BOARD_Tiles;i++) {
		
		if(Pieces[i].getType()==Type.King && Pieces[i].getColor()=="WHITE") {
		 KingPieceW=Pieces[i];
		 KingPieceW.setPosTyle(Pieces[i].getPosTyle());
		 KingPieceW.setColor(Pieces[i].getColor());
		}else if(Pieces[i].getType()==Type.King && Pieces[i].getColor()=="BLACK") {
			KingPieceB=Pieces[i];
			 KingPieceB.setPosTyle(Pieces[i].getPosTyle());
			 KingPieceB.setColor(Pieces[i].getColor());
		}
		}
		ChangeTurns(EaterPiece,Buttons,Pieces);
		
		if(CheckKing(Pieces, Buttons)==true) {
			
		}
		/*
		if(KingCheckedMated(Pieces, KingPieceW, Buttons)) {
			
			Buttons[67].setText("BLACK");
			Buttons[66].setText("Won");
		}else if(KingCheckedMated(Pieces, KingPieceB, Buttons)) {
			Buttons[67].setText("WHITE");
			Buttons[66].setText("Won");
		}
		*/
			
		
		}


	
	
	
}



