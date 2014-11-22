package com.malleamus.shock;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Square {
	
	public static int UNLIMITED = 99;
	
	private Rank rank = null;
	private File file = null;
	private Piece occupant = null;
	private Map<Direction, Square> neighbors = new Hashtable<Direction, Square>();

	public Square(Rank rank, File file) {
		this.rank = rank;
		this.file = file;
	}
	
	public Piece getOccupant() {
		return occupant;
	}

	public void setOccupant(Piece occupant) {
		this.occupant = occupant;
		if (occupant.getPosition() != this) {
			occupant.setPosition(this);
		}
	}
	
	public void vacate() {
		occupant = null;
	}
	
	public boolean isOccupied() {
		return occupant != null;
	}

	public Rank getRank() {
		return rank;
	}

	public File getFile() {
		return file;
	}
		
	public ArrayList<Square> findNeighbors() {
		ArrayList<Square> nbors = new ArrayList<Square>();
		for (Direction direction : Direction.values()) {
			Square adjacent = getAdjacent(direction);
			if (adjacent != null) {
				nbors.add(adjacent);
			}
		}
		return nbors;
	}
	
	public void setAdjacent(Direction direction, Square adjacent) {
		neighbors.put(direction, adjacent);
	}
	
	public boolean hasAdjacent(Direction direction) {
		return neighbors.get(direction) != null;
	}

	public Square getAdjacent(Direction direction) {
		return neighbors.get(direction);
	}
	
	public String toString() {
		return rank.name() + "-" + file.name();
	}
}
