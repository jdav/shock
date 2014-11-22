package com.malleamus.shock;

import java.io.IOException;

public class CommandLine implements UI {

	@Override
	public void communicate(Board board) {
		System.out.print("   ");

		for (File file : File.values()) {
			System.out.print(" " + file + " ");
		}

		System.out.println();

		for (Rank rank : Rank.values()) {
			System.out.print(rank + " ");
			for (File file : File.values()) {
				Square square = board.getSquare(rank, file);
				System.out.print(" ");
				communicate(square);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	@Override
	public void communicate(Piece piece) {
		communicate(piece.player);
		System.out.print(piece.getClass().getSimpleName().charAt(0));
	}

	@Override
	public void communicate(Action action) {
		if (action instanceof Move) {	
			communicate((Move) action);
		}
	}
	
	private void communicate(Move move) {
		System.out.println();
		System.out.print("Move ");
		communicate(move.getPiece());
		System.out.print(" from " + move.getOrigin());
		System.out.print(" to " + move.getDestination());
		if (move.captures()) {
			System.out.print(" capturing ");
			communicate(move.getCaptured());
		}
		System.out.println();
		System.out.println();
	}

	@Override
	public void communicate(Player player) {
		System.out.print(player.getName().charAt(0));
	}
	
	@Override
	public Action listen() {
		try {
			do {
				System.in.read();
			} while (System.in.available() > 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void communicate(Square square) {
		if (square.isOccupied()) {
			communicate(square.getOccupant());
		} else {
			System.out.print("--");
		}
	}
}
