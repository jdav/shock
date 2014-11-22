package com.malleamus.shock;

public class Rook extends Piece {

	public Rook(Player color) {
		super(color);
	}

	@Override
	public Moves getPossibleMoves() {
		Moves candidateDestinations = new Moves();

		//find squares adjacent to piece's current position
		candidateDestinations.addMoves(this.getPosition(), Direction.N.perspect(super.player.getPerspective()), Square.UNLIMITED);
		candidateDestinations.addMoves(this.getPosition(), Direction.S.perspect(super.player.getPerspective()), Square.UNLIMITED);
		candidateDestinations.addMoves(this.getPosition(), Direction.E.perspect(super.player.getPerspective()), Square.UNLIMITED);
		candidateDestinations.addMoves(this.getPosition(), Direction.W.perspect(super.player.getPerspective()), Square.UNLIMITED);

		return candidateDestinations;
	}
}
