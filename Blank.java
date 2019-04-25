package Game;

import java.util.ArrayList;

import Game.Pieces.Type;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Blank extends Pieces{

	/**
	 * @param color
	 * @param type
	 * @param PosTiles
	 * @param eat
	 */
	public Blank(String color, Type type, int PosTiles,boolean eat) {
		super(color, type, PosTiles, eat);
		
	}

	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovements(Game.Pieces[], Game.Pieces, javafx.scene.control.Button[])
	 */
	@Override
	public void possibleMovements(Pieces[] Pieces, Pieces piece, Button[] Buttons) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see Game.Pieces#changePieces(Game.Pieces[], Game.Pieces, Game.Pieces, javafx.scene.image.ImageView[], javafx.scene.control.Button[])
	 */
	@Override
	public void changePieces(Pieces[] Pieces, Pieces EaterPiece, Pieces EatablePiece, ImageView[] Images,
			Button[] Buttons) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param Pieces
	 * @param piece
	 * @param Buttons
	 * @return
	 */
	public boolean possibleMovementsVsKing(Pieces[] Pieces, Pieces piece, Button[] Buttons) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovementsVsKingAll(Game.Pieces[], Game.Pieces)
	 */
	@Override
	public boolean possibleMovementsVsKingAll(Pieces[] Pieces, Pieces piece) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Game.Pieces#possibleMovementsVsKing(Game.Pieces[], Game.Pieces, Game.Pieces, javafx.scene.control.Button[])
	 */
	@Override
	public boolean possibleMovementsVsKing(Pieces[] Pieces, Pieces CheckedPiece, Pieces piece, Button[] Buttons) {
		// TODO Auto-generated method stub
		return false;
	}




}
