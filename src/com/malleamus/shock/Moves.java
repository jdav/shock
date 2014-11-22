package com.malleamus.shock;
import java.util.ArrayList;

public class Moves extends ArrayList<Move> {

	private static final long serialVersionUID = 4468497118656395253L;
	
	public Moves() {
		super();
	}
	
	public void addMoves(Square start, Direction direction, int limit) {
		/*
		The set of squares moving in the indicated direction starting from (but excluding) the current position 
		and stopping at either the end of the board or the first occupied square encountered, excluding that 
		square if it is occupied by a piece of the same color as the piece occupying the current position, but 
		including that square if it is occupied	by a piece of the opposite color as the piece occupying the 
		current position.
		*/
		Square square = start; 
		int count = 0;
		do {
			square = square.getAdjacent(direction);
			
			Move move = new Move();
			move.setOrigin(start);
			move.setPiece(start.getOccupant());
			move.setDestination(square);
			
			if (square.isOccupied()) {
				move.setCaptured(square.getOccupant());
			}
			
			if (move.isValid()) {
				add(move);
			}
		} while (square.hasAdjacent(direction) && !square.isOccupied() && ++count<limit);
	}
	
	public void addMoves(Square start, Direction direction) {
		addMoves(start, direction, 8);
	}
}
