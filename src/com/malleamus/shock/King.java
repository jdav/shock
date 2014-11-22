package com.malleamus.shock;

public class King extends Piece {

	public King(Player color) {
		super(color);
	}

	@Override
	public Moves getPossibleMoves() {
		Moves possibleMoves = new Moves();
		
		//select parameters for finding possible moves
		Perspective perspective = super.player.getPerspective();
		Square position = getPosition();

		//find possible moves
		possibleMoves.addMoves(position, Direction.NE.perspect(perspective), 1);
		possibleMoves.addMoves(position, Direction.NW.perspect(perspective), 1);
		possibleMoves.addMoves(position, Direction.SE.perspect(perspective), 1);
		possibleMoves.addMoves(position, Direction.SW.perspect(perspective), 1);
		
		return possibleMoves;
	}
	
	public String toString() {
		return super.player + " king";
	}
}
