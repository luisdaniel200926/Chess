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

public class Bishops extends Pieces implements ILimited{

	/**
	 * @param color
	 * @param type
	 * @param PosTiles
	 * @param eat
	 */
	public Bishops(String color, Type type, int PosTiles,boolean eat) {
		super(color, type, PosTiles, eat);
		
	}
	

	final int nextMove[]= {-9,-7,7,9};
	
	
	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovements(Game.Pieces[], Game.Pieces, javafx.scene.control.Button[])
	 */
	@Override
	public void possibleMovements(Pieces[] Pieces, Pieces piece, Button[] Buttons) {
		
		
		int counter=0;
		int i=piece.getPosTyle();
		String ActualColor=Pieces[i].getColor();
		int isummatory;
		boolean OutOfBoundaries=false;
		
		for (int j = 0; j < nextMove.length; j++) {
			isummatory=i;
			while(Pieces[i].getPosTyle()>=0 && Pieces[i].getPosTyle()<64){
				if(nextMove[j]==9||nextMove[j]==-7) {
					if(boarderLimitationRight(isummatory)) {
						OutOfBoundaries=true;
					}
				}else if(nextMove[j]==-9||nextMove[j]==7) {
					if(boarderLimitationLeft( isummatory)) {
						OutOfBoundaries=true;
					}
				}
					
				if(OutOfBoundaries) {
					OutOfBoundaries=false;
					break;
				}

				isummatory+=nextMove[j];
				
				if(isummatory>=0 && isummatory<64) {
							
					if((Pieces[isummatory].getColor()=="BLANK")) {
						
						counter++;
						//PossibleMoves.add(Pieces[isummatory]);
						Buttons[isummatory].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
						Buttons[isummatory].setDisable(false);
						Pieces[isummatory].setEat(true);
						
						SavePiece(Pieces[i]);
					}else if (!(Pieces[isummatory].getColor()==ActualColor)){
						counter++;
						
						Buttons[isummatory].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
						Buttons[isummatory].setDisable(false);
						Pieces[isummatory].setEat(true);
						
						SavePiece(Pieces[i]);
					
					break;
					
				}else if ((Pieces[isummatory].getColor()==ActualColor)){
					
					break;
				}
					
			}else {
				break;
			}
			
		}
	}
		
		if(counter>0) {
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
		String ActualColor=Pieces[i].getColor();
		int isummatory;
		boolean OutOfBoundaries=false;
		
		for (int j = 0; j < nextMove.length; j++) {
			isummatory=i;
			while(Pieces[i].getPosTyle()>=0 && Pieces[i].getPosTyle()<64){
				if(nextMove[j]==9||nextMove[j]==-7) {
					if(boarderLimitationRight(isummatory)) {
						OutOfBoundaries=true;
					}
				}else if(nextMove[j]==-9||nextMove[j]==7) {
					if(boarderLimitationLeft( isummatory)) {
						OutOfBoundaries=true;
					}
				}
					
				if(OutOfBoundaries) {
					OutOfBoundaries=false;
					break;
				}

				isummatory+=nextMove[j];
				
				if(isummatory>=0 && isummatory<64) {
							
					if(Pieces[isummatory].getType()==Type.King && !(Pieces[isummatory].getColor()==ActualColor)) {
						return true;
						
					
					
					
				}else if ((Pieces[isummatory].getColor()==ActualColor)){
					
					break;
				}
					
			}else {
				break;
			}
			
		}
	}
		
		
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
	public boolean boarderLimitationTop(int i) {
		
		return false;
	}

	/* (non-Javadoc)
	 * @see Game.ILimited#boarderLimitationBottom(int)
	 */
	@Override
	public boolean boarderLimitationBottom(int i) {
		
		return false;
	}



	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovementsVsKing(Game.Pieces[], Game.Pieces, Game.Pieces, javafx.scene.control.Button[])
	 */
	@Override
	public boolean possibleMovementsVsKing(Pieces[] Pieces, Pieces CheckedPiece, Pieces piece, Button[] Buttons) {
		int i=piece.getPosTyle();
		String ActualColor=Pieces[i].getColor();
		int isummatory;
		int k=CheckedPiece.getPosTyle();
		boolean OutOfBoundaries=false;
		
		for (int j = 0; j < nextMove.length; j++) {
			isummatory=i;
			while(Pieces[i].getPosTyle()>=0 && Pieces[i].getPosTyle()<64){
				if(nextMove[j]==9||nextMove[j]==-7) {
					if(boarderLimitationRight(isummatory)) {
						OutOfBoundaries=true;
					}
				}else if(nextMove[j]==-9||nextMove[j]==7) {
					if(boarderLimitationLeft( isummatory)) {
						OutOfBoundaries=true;
					}
				}
					
				if(OutOfBoundaries) {
					OutOfBoundaries=false;
					break;
				}

				isummatory+=nextMove[j];
				
				if(isummatory>=0 && isummatory<64) {
							
					if(Pieces[isummatory].getPosTyle()==k && !(Pieces[isummatory].getColor()==ActualColor)) {
						return true;
						
					
					
					
				}else if ((Pieces[isummatory].getColor()==ActualColor)){
					
					break;
				}
					
			}else {
				break;
			}
			
		}
	}
		return false;
	}

}
