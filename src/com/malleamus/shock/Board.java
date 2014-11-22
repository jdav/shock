package com.malleamus.shock;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Board {
	
	private Map<Rank, ArrayList<Square>> ranksSquares = new Hashtable<Rank, ArrayList<Square>>();
	private Map<File, ArrayList<Square>> filesSquares = new Hashtable<File, ArrayList<Square>>();
	
	public Board() {
		//Fill in the list of squares associated with each rank
		for (Rank rank : Rank.values()) {
			ranksSquares.put(rank, new ArrayList<Square>());
		}
		
		//Fill in the list of squares associated with each file
		for (File file : File.values()) {
			filesSquares.put(file, new ArrayList<Square>());
		}
		
		for (Rank rank : Rank.values()) {
			for (File file : File.values()) {
				Square square = new Square(rank, file);
				ranksSquares.get(rank).add(square);
				filesSquares.get(file).add(square);
			}
		}
		
		for (Rank rank : Rank.values()) {
			for (File file : File.values()) {
				Square square = getSquare(rank, file);
				
				if (rank.hasPrevious()) { //has S
					square.setAdjacent(Direction.S, getSquare(rank.previous(), file));
					
					if (file.hasNext()) { //has E
						square.setAdjacent(Direction.E, getSquare(rank, file.next()));
						square.setAdjacent(Direction.SE, getSquare(rank.previous(), file.next()));
					}
					
					if (file.hasPrevious()) { //has W
						square.setAdjacent(Direction.W, getSquare(rank, file.previous()));
						square.setAdjacent(Direction.SW, getSquare(rank.previous(), file.previous()));
					}
				}
				
				if (rank.hasNext()) { //has N
					square.setAdjacent(Direction.N, getSquare(rank.next(), file));
					
					if (file.hasNext()) { //has E
						square.setAdjacent(Direction.E, getSquare(rank, file.next()));
						square.setAdjacent(Direction.NE, getSquare(rank.next(), file.next()));
					}
					
					if (file.hasPrevious()) { //has W
						square.setAdjacent(Direction.W, getSquare(rank, file.previous()));
						square.setAdjacent(Direction.NW, getSquare(rank.next(), file.previous()));
					}
				}
					
				if (file.hasNext()) { //has E
					square.setAdjacent(Direction.E, getSquare(rank, file.next()));
				}
				
				if (file.hasPrevious()) { //has W
					square.setAdjacent(Direction.W, getSquare(rank, file.previous()));
				}
			}
		}
	}
	
	public void clear() {
		for (Rank rank : Rank.values()) {
			for (File file : File.values()) {
				getSquare(rank, file).vacate();
			}
		}
	}
	
	public void setup(Player white, Player black) {
		getSquare(Rank.R8, File.FA).setOccupant(new Rook(white));
		getSquare(Rank.R8, File.FC).setOccupant(new Bishop(white));
		getSquare(Rank.R8, File.FD).setOccupant(new Queen(white));
		getSquare(Rank.R8, File.FE).setOccupant(new King(white));
		getSquare(Rank.R8, File.FF).setOccupant(new Bishop(white));
		getSquare(Rank.R8, File.FH).setOccupant(new Rook(white));
		
		for (File f : File.values()) {
			getSquare(Rank.R7, f).setOccupant(new Pawn(white));
			getSquare(Rank.R2, f).setOccupant(new Pawn(black));
		}
		
		getSquare(Rank.R1, File.FA).setOccupant(new Rook(black));
		getSquare(Rank.R1, File.FC).setOccupant(new Bishop(black));  
		getSquare(Rank.R1, File.FD).setOccupant(new King(black));
		getSquare(Rank.R1, File.FE).setOccupant(new Queen(black));
		getSquare(Rank.R1, File.FF).setOccupant(new Bishop(black));
		getSquare(Rank.R1, File.FH).setOccupant(new Rook(black));
	}

	public Square getSquare(Rank soughtRank, File soughtFile) {
		ArrayList<Square> rank = ranksSquares.get(soughtRank);
		for (Object object : rank.toArray()) {
			Square square = (Square) object;
			if (square.getFile() == soughtFile) {
				return square;
			}
		}

		return null;
	}
	
	public ArrayList<Square> getSquares(Rank rank) {
		return ranksSquares.get(rank);
	}
	
	public ArrayList<Square> getSquares(File file) {
		return filesSquares.get(file);
	}
}
