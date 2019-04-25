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

public class Knights extends Pieces{
	
	private final int nextMove[]= {-17,-15,-6,-10,+17,+15,+6,+10};

	
	/**
	 * @param color
	 * @param type
	 * @param PosTiles
	 * @param eat
	 */
	public Knights(String color, Type type, int PosTiles,boolean eat) {
		super(color, type, PosTiles, eat);
		
	}

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
		
		for(int j=0;j<nextMove.length;j++) {
			if(i+nextMove[j]>=0 && i+nextMove[j]<BOARD_Tiles) {
				if(checkSector(i, nextMove[j])) {
				if(!(Pieces[i+nextMove[j]].getColor()==ActualColor)) {
					cases++;
					Pieces[i+nextMove[j]].setEat(true);
					Buttons[i+nextMove[j]].setDisable(false);
					Buttons[i+nextMove[j]].setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
					SavePiece(Pieces[i]);
				}	
				}
			}
			
			
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
	
	/**
	 * @param i
	 * @param caseEvaluated
	 * @return
	 */
	public boolean checkSector(int i,int caseEvaluated) {
		
		
		switch(caseEvaluated){
			
			case 10:{
				int Sector_10plus[]= {0,1,2,3,4,5,8, 9, 10, 11, 12, 13,  16, 17, 18, 19, 20, 21,  24, 25, 26, 27, 28, 29,  32, 33, 34, 35, 36, 37,  40, 41, 42, 43, 44, 45,  48, 49, 50, 51, 52, 53};
				for(int j=0;j<Sector_10plus.length;j++) {
					if(i==Sector_10plus[j]) {
						return true;
					}
				}
					break;
			}
			case -6:{
				int Sector_6minus[]= {8, 9, 10, 11, 12, 13,  16, 17, 18, 19, 20, 21,  24, 25, 26, 27, 28, 29,  32, 33, 34, 35, 36, 37,  40, 41, 42, 43, 44, 45,  48, 49, 50, 51, 52, 53,  56, 57, 58, 59, 60, 61, };
				for(int j=0;j<Sector_6minus.length;j++) {
					if(i==Sector_6minus[j]) {
						return true;
					}
				}
				break;
			}
			case -15:{
				int Sector_15minus[]= {16, 17, 18, 19, 20, 21, 22, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36, 37, 38, 40, 41, 42, 43, 44, 45, 46,  48, 49, 50, 51, 52, 53, 54,  56, 57, 58, 59, 60, 61, 62, };
				for(int j=0;j<Sector_15minus.length;j++) {
					if(i==Sector_15minus[j]) {
						return true;
					}
				}
				break;
			}
			case -17:{
				int Sector17_minus[]= { 17, 18, 19, 20, 21, 22, 23, 25, 26, 27, 28, 29, 30, 31,  33, 34, 35, 36, 37, 38, 39,  41, 42, 43, 44, 45, 46, 47,  49, 50, 51, 52, 53, 54, 55,  57, 58, 59, 60, 61, 62, 63};
				for(int j=0;j<Sector17_minus.length;j++) {
					if(i==Sector17_minus[j]) {
						return true;
					}
				}	
				
				break;
			}
			case -10:{
				int Sector_10minus[]= {10, 11, 12, 13, 14, 15, 18, 19, 20, 21, 22, 23, 26, 27, 28, 29, 30, 31, 34, 35, 36, 37, 38, 39, 42, 43, 44, 45, 46, 47, 50, 51, 52, 53, 54, 55, 58, 59, 60, 61, 62, 63};
				for(int j=0;j<Sector_10minus.length;j++) {
					if(i==Sector_10minus[j]) {
						return true;
					}
				}	
				break;
			}
			case 6:{
				int Sector_6plus[]= {2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 18, 19, 20, 21, 22, 23, 26, 27, 28, 29, 30, 31, 34, 35, 36, 37, 38, 39, 42, 43, 44, 45, 46, 47, 50, 51, 52, 53, 54, 55};
				for(int j=0;j<Sector_6plus.length;j++) {
					if(i==Sector_6plus[j]) {
						return true;
					}
				}	
				break;
			}
			case 15:{
				int Sector_15plus[]={1,2,3,4,5,6,7,9,10,11,12,13,14,15,17,18,19,20,21,22,23,25,26,27,28,29,30,31,33,34,35,36,37,38,39,41,42,43,44,45,46,47};
				for(int j=0;j<Sector_15plus.length;j++) {
					if(i==Sector_15plus[j]) {
						return true;
					}
				}	
				break;
			}
			case 17:{
				int Sector_17Plus[]= {0,1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14,  16, 17, 18, 19, 20, 21, 22, 24, 25, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36, 37, 38, 40, 41, 42, 43, 44, 45, 46};
				for(int j=0;j<Sector_17Plus.length;j++) {
					if(i==Sector_17Plus[j]) {
						return true;
					}
				}	
				
				break;
			}
		}
		
		
		return false;
	}

	

	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovementsVsKingAll(Game.Pieces[], Game.Pieces)
	 */
	@Override
	public boolean possibleMovementsVsKingAll(Pieces[] Pieces, Pieces piece) {
		
		int i=piece.getPosTyle();
		
		String ActualColor="";
		if(piece.getColor()=="WHITE") {
			ActualColor="WHITE";
		}else if(piece.getColor()=="BLACK") {
			ActualColor="BLACK";
		}
		
		for(int j=0;j<nextMove.length;j++) {
			if(i+nextMove[j]>=0 && i+nextMove[j]<BOARD_Tiles) {
				if(checkSector(i, nextMove[j])) {
				if(!(Pieces[i+nextMove[j]].getColor()==ActualColor)&&Pieces[i+nextMove[j]].getType()==Type.King) {
					
					return true;
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
		int cases=0;
		int k=CheckedPiece.getPosTyle();
	
		String ActualColor="";
		if(piece.getColor()=="WHITE") {
			ActualColor="WHITE";
		}else if(piece.getColor()=="BLACK") {
			ActualColor="BLACK";
		}
		
		for(int j=0;j<nextMove.length;j++) {
			if(i+nextMove[j]>=0 && i+nextMove[j]<BOARD_Tiles) {
				if(checkSector(i, nextMove[j])) {
				if(!(Pieces[i+nextMove[j]].getColor()==ActualColor) && (i+nextMove[j])==k) {
					
					return true;
				}	
				}
			}
			
			
		}
		
		
		
		return false;
	}


}