package com.malleamus.shock;

public class Queen extends Piece {

	public Queen(Player color) {
		super(color);
	}

	@Override
	public Moves getPossibleMoves() {
		Moves possibleMoves = new Moves();

		//find squares adjacent to piece's current position
		for (Direction direction : Direction.values()) {
			possibleMoves.addMoves(this.getPosition(), direction, Square.UNLIMITED);
		}
		
		return possibleMoves;
	}
	
	public String toString() {
		return super.player + " queen";
	}	
}
