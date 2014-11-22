package com.malleamus.shock;

public class Move extends Action {

	private Piece piece = null;
	private Square origin = null;
	private Square destination = null;
	private Piece captured = null;
	
	public void execute() {
		if (captures()) {
			captured.setCaptured();
		}
		
		origin.vacate();
		piece.setPosition(destination);
	}

	public Piece getPiece() {
		return piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Square getDestination() {
		return destination;
	}

	public void setDestination(Square destination) {
		this.destination = destination;
	}
	
	public boolean captures() {
		return captured != null;
	}

	public Piece getCaptured() {
		return captured;
	}

	public void setCaptured(Piece captured) {
		this.captured = captured;
	}

	public Square getOrigin() {
		return origin;
	}

	public void setOrigin(Square origin) {
		this.origin = origin;
	}
	
	public boolean isValid() {
		return (piece != null &&
			    origin != null &&
			    piece.getPosition().equals(origin) &&
			    origin.getOccupant().equals(piece) &&
			    destination != null &&
			    !origin.equals(destination) &&
			    (captured == null || 
			    (!piece.getPlayer().equals(captured.getPlayer()) &&
			     captured.getPosition().equals(destination) &&
			     destination.getOccupant().equals(captured))));
	}
}
