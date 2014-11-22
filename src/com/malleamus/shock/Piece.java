package com.malleamus.shock;


public abstract class Piece {
	
	protected Player player = null;
	private Square position = null;
	
	public Piece(Player player) {
		this.player = player;
		player.addPiece(this);
	}
	
	public abstract Moves getPossibleMoves();
	
	public Player getPlayer() {
		return player;
	}

	public Square getPosition() {
		return position;
	}

	public void setPosition(Square position) {
		this.position = position;
		if (position.getOccupant() != this) {
			position.setOccupant(this);
		}
	}
	
	public void setCaptured() {
		position = null;
		getPlayer().setCaptured(this);
	}
	
	public boolean isCaptured() {
		return position == null;
	}
}
