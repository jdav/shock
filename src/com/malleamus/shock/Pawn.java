package com.malleamus.shock;

public class Pawn extends Piece {

	private boolean firstMove = true;

	public Pawn(Player color) {
		super(color);
	}

	@Override
	public Moves getPossibleMoves() {
		Moves possibleMoves = new Moves();

		// select parameters for finding possible moves
		Perspective perspective = super.player.getPerspective();
		Square position = getPosition();

		if (firstMove) {
			Direction direction = Direction.N.perspect(perspective);
			possibleMoves.addMoves(position, direction, 2);
			firstMove = false;
		} else {
			Direction direction = Direction.N.perspect(perspective);
			possibleMoves.addMoves(position, direction, 1);
		}

		Direction northEast = Direction.NE.perspect(perspective);
		if (position.hasAdjacent(northEast) && position.getAdjacent(northEast).isOccupied()) {
			Move neCapture = new Move();
			neCapture.setPiece(this);
			neCapture.setOrigin(position);
			neCapture.setDestination(position.getAdjacent(northEast));
			neCapture.setCaptured(position.getAdjacent(northEast).getOccupant());
			if (neCapture.isValid() && neCapture.captures()) {
				possibleMoves.add(neCapture);
			}
		}

		Direction northWest = Direction.NW.perspect(perspective);
		if (position.hasAdjacent(northWest) && position.getAdjacent(northWest).isOccupied()) {
			Move nwCapture = new Move();
			nwCapture.setPiece(this);
			nwCapture.setOrigin(position);
			nwCapture.setDestination(position.getAdjacent(northEast));
			nwCapture.setCaptured(position.getAdjacent(northEast).getOccupant());
			if (nwCapture.isValid() && nwCapture.captures()) {
				possibleMoves.add(nwCapture);
			}
		}

		return possibleMoves;
	}
}
