package com.malleamus.shock;

public interface UI {

	public void communicate(Board board);
	public void communicate(Square square);
	public void communicate(Action action);
	public void communicate(Piece piece);
	public void communicate(Player player);
	public Action listen();
}
