package Game;


import Game.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

import javafx.scene.paint.Color;
import application.Main;

public abstract class Pieces {

	public enum Type{Pawn,Rook,Knight,Bishop,Queen,King,Blank};
	
	private String color;
	private Type type;
	private int PosTyle;
	private boolean eat;
	
	final static int BOARD_Tiles = 64;
	
	final int PossibleMovesKing[]= {-9,-8,-7,-1,+1,+7,+8,+9};
	
	static int Total_Moves =0;
	
	
	
	public static Pieces PieceSaved;	
	
	/**
	 * @param color
	 * @param type
	 * @param PosTyle
	 * @param eat
	 */
	public Pieces(String color, Type type, int PosTyle,boolean eat) {
		setColor(color);
		setType(type);
		setPosTyle(PosTyle);
		
	}
	
	
	/**
	 * @param Pieces
	 * @param piece
	 * @param Buttons
	 */
	/**
	 * @param Pieces
	 * @param piece
	 * @param Buttons
	 */
	public abstract void possibleMovements(Pieces[] Pieces, Pieces piece,Button[] Buttons);
	

	
	/**
	 * @param Pieces
	 * @param piece
	 * @return
	 */
	/**
	 * @param Pieces
	 * @param piece
	 * @return
	 */
	public abstract boolean possibleMovementsVsKingAll(Pieces[] Pieces, Pieces piece);
	
	/**
	 * @param Pieces
	 * @param CheckedPiece
	 * @param piece
	 * @param Buttons
	 * @return
	 */
	/**
	 * @param Pieces
	 * @param CheckedPiece
	 * @param piece
	 * @param Buttons
	 * @return
	 */
	public abstract boolean possibleMovementsVsKing(Pieces[] Pieces,Pieces CheckedPiece, Pieces piece,Button[] Buttons);
	
	/**
	 * @param Pieces
	 * @param Buttons
	 * @return
	 */
	/**
	 * @param Pieces
	 * @param Buttons
	 * @return
	 */
	public boolean CheckKing(Pieces[] Pieces, Button[] Buttons) {
		int cout=0;
		for(int i=0;i<BOARD_Tiles;i++) {

			if(Pieces[i].possibleMovementsVsKingAll(Pieces, Pieces[i])){
				Buttons[65].setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
				
				if(Pieces[i].getColor()=="WHITE") {
					for(int j=0;j<BOARD_Tiles;j++) {
						if(Pieces[j].getType()==Type.King && Pieces[j].getColor()=="BLACK") {
							
						}}
				}
				if(Pieces[i].getColor()=="BLACK") {
					for(int j=0;j<BOARD_Tiles;j++) {
						if(Pieces[j].getType()==Type.King && Pieces[j].getColor()=="WHITE") {
							
						}
					}
				}
				return true;
		}
		}
		
		return false;
		
	
	}
	
	
	
/**
 * @param Pieces
 * @param PieceKing
 * @param Buttons
 * @param PosChecked
 * @return
 */
/**
 * @param Pieces
 * @param PieceKing
 * @param Buttons
 * @param PosChecked
 * @return
 */
public boolean KingCheckedMated(Pieces[] Pieces, Pieces PieceKing,Button[] Buttons,int PosChecked) {
		
		int i=PieceKing.getPosTyle();
		String ActualColorKing=PieceKing.getColor();
		int counter=0;
		
		
			Pieces auxPiece;
			String auxColor;
			Type auxType;
			
			auxPiece=Pieces[i+PossibleMovesKing[PosChecked]];
			
			if((Pieces[i+PossibleMovesKing[PosChecked]].getColor()==ActualColorKing)) {
					return true;
			}
			
			auxColor=Pieces[i+PossibleMovesKing[PosChecked]].getColor();
			
			auxType=Pieces[i+PossibleMovesKing[PosChecked]].getType();
			
			
			
			
			
			for(int index=0;index<BOARD_Tiles;index++) {
			if(possibleMovementsVsKing(Pieces, Pieces[i+PossibleMovesKing[PosChecked]],Pieces[index],Buttons)){
				
				return true;
				}
			}
			
			Pieces[i+PossibleMovesKing[PosChecked]].setType(auxType);
			Pieces[i+PossibleMovesKing[PosChecked]].setColor(auxColor);
			
		
		return false;
	}
	
	/**
	 * @param Buttons
	 */
	/**
	 * @param Buttons
	 */
	public void turnOffButtons(Button[] Buttons) {
		
		for(int i=0;i<BOARD_Tiles;i++) {
			
			Buttons[i].setDisable(true);
			
			}
		
	}
	
	/**
	 * @param Buttons
	 * @param Pieces
	 */
	/**
	 * @param Buttons
	 * @param Pieces
	 */
	public void SetNullEat(Button[] Buttons,Pieces[] Pieces) {
		
		for(int i=0;i<BOARD_Tiles;i++) {
			
		Buttons[i].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		Pieces[i].setEat(false);
		
			}
		
		Buttons[65].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
	}
	
	/**
	 * @param PieceEater
	 */
	/**
	 * @param PieceEater
	 */
	public void SavePiece(Pieces PieceEater) {

		PieceSaved=PieceEater;
		
		
	}
	
	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public Pieces ReturSavedPiece() {
		
		return PieceSaved;
	}
	
	/**
	 * @param Piece
	 * @param Buttons
	 * @param Pieces
	 */
	/**
	 * @param Piece
	 * @param Buttons
	 * @param Pieces
	 */
	public void ChangeTurns(Pieces Piece, Button[] Buttons, Pieces[] Pieces) {
		
		AddUpMoves();
		
		
		
		if(Piece.getColor()=="WHITE") {
			for(int i=0;i<BOARD_Tiles;i++) {
				if(Pieces[i].getColor()=="BLANK") {
					Buttons[i].setDisable(true);
				}
				if(Pieces[i].getColor()=="WHITE") {
					Buttons[i].setDisable(true);
				}else if(Pieces[i].getColor()=="BLACK") {
					Buttons[i].setDisable(false);
				}
			}
		}else if(Piece.getColor()=="BLACK") {
			for(int i=0;i<BOARD_Tiles;i++) {
				if(Pieces[i].getColor()=="BLANK") {
					Buttons[i].setDisable(true);
				}
				if(Pieces[i].getColor()=="WHITE") {
					Buttons[i].setDisable(false);
				}else if(Pieces[i].getColor()=="BLACK") {
					Buttons[i].setDisable(true);
				}
			}
		}
		
		if(Total_Moves>=50) {
			Buttons[64].setDisable(false);
			Buttons[64].setVisible(true);
		}
		
	}
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	public void AddUpMoves() {
		Total_Moves++;
	}
	
	
	/**
	 * @return the type
	 */
	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public Type getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	/**
	 * @param type
	 */
	/**
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}


	/**
	 * @return the color
	 */
	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	/**
	 * @param color
	 */
	/**
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}


	
	/**
	 * @return the eat
	 */
	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public boolean isEat() {
		return eat;
	}

	/**
	 * @param eat the eat to set
	 */
	/**
	 * @param eat
	 */
	/**
	 * @param eat
	 */
	public void setEat(boolean eat) {
		this.eat = eat;
	}




	/**
	 * @return the posTyle
	 */
	/**
	 * @return
	 */
	/**
	 * @return
	 */
	public int getPosTyle() {
		return PosTyle;
	}




	/**
	 * @param posTyle the posTyle to set
	 */
	/**
	 * @param posTyle
	 */
	/**
	 * @param posTyle
	 */
	public void setPosTyle(int posTyle) {
		PosTyle = posTyle;
	}

/**
 * @param Pieces
 * @param EaterPiece
 * @param EatablePiece
 * @param Images
 * @param Buttons
 */
/**
 * @param Pieces
 * @param EaterPiece
 * @param EatablePiece
 * @param Images
 * @param Buttons
 */
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
		
			
		
		}




}


	

