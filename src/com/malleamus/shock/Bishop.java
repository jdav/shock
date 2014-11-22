package com.malleamus.shock;

public class Bishop extends Piece {

	public Bishop(Player color) {
		super(color);
	}

	@Override
	public Moves getPossibleMoves() {
		Moves possibleMoves = new Moves();
		
		//select parameters for finding possible moves
		Perspective perspective = super.player.getPerspective();
		Square position = getPosition();
		int limit = Square.UNLIMITED;

		//find possible moves
		possibleMoves.addMoves(position, Direction.NE.perspect(perspective), limit);
		possibleMoves.addMoves(position, Direction.NW.perspect(perspective), limit);
		possibleMoves.addMoves(position, Direction.SE.perspect(perspective), limit);
		possibleMoves.addMoves(position, Direction.SW.perspect(perspective), limit);

		return possibleMoves;
	}
}
