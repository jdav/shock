package com.malleamus.shock;

import java.io.IOException;

import com.malleamus.shock.Board;

public class Game {
	
	public static void main(String[] args) throws IOException {
		UI ui = new CommandLine();
		Player white = new AIPlayer("white", Perspective.REVERSE);
		Player black = new AIPlayer("black", Perspective.NORMAL);
		white.setOpponent(black);
		black.setOpponent(white);
		Board board = new Board();
		
		while (true) {
			board.setup(white, black);
			Game game = new Game(board, white, black, ui);
			game.play();
			board.clear();
		}
	}
	
	private Player white = null;
	private Player black = null;
	private Board board = null;
	private UI ui = null;
	
	private Actions actions = new Actions();

	public Game(Board board, Player white, Player black, UI ui) {
		this.white = white;
		this.black = black;
		this.board = board;
		this.ui = ui;
	}
	
	public void play() throws IOException {	
		Player currentPlayer = white;

		while (!isOver()) {
			ui.communicate(board);
			Action action = currentPlayer.chooseAction();
			action.execute();
			ui.communicate(action);
			actions.add(action);
			currentPlayer = currentPlayer.getOpponent();
		}
	}
	
	public boolean isOver() {
		return white.inCheckMate() || black.inCheckMate();
	}
}
