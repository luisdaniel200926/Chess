package Game;

import java.util.ArrayList;

import Game.Pieces.Type;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Kings extends Pieces{

	

	
	/**
	 * @param color
	 * @param type
	 * @param PosTiles
	 * @param eat
	 */
	public Kings(String color, Type type, int PosTiles,boolean eat) {
		super(color, type, PosTiles, eat);
		
	}
	
	final int nextMove[]= {-9,-8,-7,-1,+1,+7,+8,+9};  

	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovements(Game.Pieces[], Game.Pieces, javafx.scene.control.Button[])
	 */
	@Override
	public void possibleMovements(Pieces[] Pieces, Pieces piece, Button[] Buttons) {
		
		int i=piece.getPosTyle();
		int cases=0;
		String ActualColor="";
		if(piece.getColor()=="WHITE") {
			ActualColor="WHITE";
		}else if(piece.getColor()=="BLACK") {
			ActualColor="BLACK";
		}
		
		
		for(int m=0;m<nextMove.length;m++) {
			if((i+nextMove[m])>=0 ) {
				if((i+nextMove[m])<BOARD_Tiles) {
			if(!(Pieces[i+nextMove[m]].getColor()==ActualColor) ) {
				
				if(BoundChecker(i, nextMove[m])) {
					if(KingCheckedMated(Pieces,Pieces[i],Buttons,m)) {
						
						break;
					}
				
				cases++;
				Buttons[i+nextMove[m]].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
				Buttons[i+nextMove[m]].setDisable(false);
				Pieces[i+nextMove[m]].setEat(true);
				
				SavePiece(Pieces[i]);
				}
						}
					}
				}
				
			}
		
	}
		

	
	
	/**
	 * @param i
	 * @param Direction
	 * @return
	 */
	public boolean BoundChecker(int i,int Direction) {
		
		switch(Direction) {
		case -9:	{
		int BoandaryLeft[]= {0,8,16,24,32,40,48,56};
		for(int j=0;j<BoandaryLeft.length;j++) {
			
			if(i==BoandaryLeft[j]) {
				return false;
			}

		}
		
		
		int BoandaryTop[]= {0,1,2,3,4,5,6,7};
		for(int j=0;j<BoandaryTop.length;j++) {
			
			if(i==BoandaryTop[j]) {
				return false;
			}
			
		}
		break;	
		}
		case -8:{
			int BoandaryTop[]= {0,1,2,3,4,5,6,7};
			for(int j=0;j<BoandaryTop.length;j++) {
				
				if(i==BoandaryTop[j]) {
					return false;
				}
				
			}
					
			
			break;
			}
		case -7:{
				int BoandaryRight[]= {7,15,23,31,39,47,55,63};
				for(int j=0;j<BoandaryRight.length;j++) {
					
					if(i==BoandaryRight[j]) {
						return false;
					}
					
				}
			
				int BoandaryTop[]= {0,1,2,3,4,5,6,7};
				for(int j=0;j<BoandaryTop.length;j++) {
					
					if(i==BoandaryTop[j]) {
						return false;
					}
					
				}
			
			break;
		}
		
		case -1:{
			
			int BoandaryLeft[]= {0,8,16,24,32,40,48,56};
			for(int j=0;j<BoandaryLeft.length;j++) {
				
				if(i==BoandaryLeft[j]) {
					return false;
				}

			}
			
		
		break;
			}
		case 1:{
			int BoandaryRight[]= {7,15,23,31,39,47,55,63};
			for(int j=0;j<BoandaryRight.length;j++) {
				
				if(i==BoandaryRight[j]) {
					return false;
				}
				
			}
			break;
		}
		case 7:{
			int BoandaryBottom[]= {56,57,58,59,60,61,62,63};
			for(int j=0;j<BoandaryBottom.length;j++) {
				
				if(i==BoandaryBottom[j]) {
					return false;
				}
				
			}
			int BoandaryLeft[]= {0,8,16,24,32,40,48,56};
			for(int j=0;j<BoandaryLeft.length;j++) {
				
				if(i==BoandaryLeft[j]) {
					return false;
				}

			}
			break;
		}
		case 8:{
			int BoandaryBottom[]= {56,57,58,59,60,61,62,63};
			for(int j=0;j<BoandaryBottom.length;j++) {
				
				if(i==BoandaryBottom[j]) {
					return false;
				}
				
			}
			break;
		}
		case 9:{
			int BoandaryBottom[]= {56,57,58,59,60,61,62,63};
			for(int j=0;j<BoandaryBottom.length;j++) {
				
				if(i==BoandaryBottom[j]) {
					return false;
				}
				
			}
			int BoandaryRight[]= {7,15,23,31,39,47,55,63};
			for(int j=0;j<BoandaryRight.length;j++) {
				
				if(i==BoandaryRight[j]) {
					return false;
				}
				
			}
			break;
		}
			
		}
		
		
	return true;
	}


	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovementsVsKingAll(Game.Pieces[], Game.Pieces)
	 */
	@Override
	public boolean possibleMovementsVsKingAll(Pieces[] Pieces, Pieces piece) {
		
		int i=piece.getPosTyle();
		int cases=0;
		String ActualColor="";
		if(piece.getColor()=="WHITE") {
			ActualColor="WHITE";
		}else if(piece.getColor()=="BLACK") {
			ActualColor="BLACK";
		}
		
		
		for(int m=0;m<nextMove.length;m++) {
			if((i+nextMove[m])>=0 ) {
				if((i+nextMove[m])<BOARD_Tiles) {
			if(Pieces[i+nextMove[m]].getType()==Type.King ) {
				
				if(BoundChecker(i, nextMove[m])) {
				
							return true;
							}
						}
					}
				}
				
			}
		
		return false;
	}


	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovementsVsKing(Game.Pieces[], Game.Pieces, Game.Pieces, javafx.scene.control.Button[])
	 */
	@Override
	public boolean possibleMovementsVsKing(Pieces[] Pieces, Pieces CheckedPiece, Pieces piece, Button[] Buttons) {
		int i=piece.getPosTyle();
		int k=CheckedPiece.getPosTyle();
		String ColorChecked=CheckedPiece.getColor();
		int cases=0;
		String ActualColor="";
		if(piece.getColor()=="WHITE") {
			ActualColor="WHITE";
		}else if(piece.getColor()=="BLACK") {
			ActualColor="BLACK";
		}
		
		
		for(int m=0;m<nextMove.length;m++) {
			if((i+nextMove[m])>=0 ) {
				if((i+nextMove[m])<BOARD_Tiles) {
			if(Pieces[i+nextMove[m]].getPosTyle()==k && !(Pieces[i+nextMove[m]].getColor()==ColorChecked)) {
				
				if(BoundChecker(i, nextMove[m])) {
				
							return true;
							}
						}
					}
				}
				
			}
		return false;
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
