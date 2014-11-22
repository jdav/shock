package com.malleamus.shock;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player {

	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	protected ArrayList<Piece> activePieces = new ArrayList<Piece>();
	private ArrayList<Piece> capturedPieces = new ArrayList<Piece>();
	protected King king = null;
	protected Random random = new Random();
	protected String name = null;
	private Player opponent = null;
	private Perspective perspective = null;

	public Player(String name, Perspective perspective) {
		super();
		setName(name);
		setPerspective(perspective);
	}
	
	public abstract Action chooseAction();

	public void addPiece(Piece piece) {
		pieces.add(piece);
		activePieces.add(piece);
		if (piece instanceof King) {
			king = (King) piece;
		}
	}

	public boolean inCheck() {
		return false;
	}

	public boolean inCheckMate() {
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player black) {
		this.opponent = black;
	}

	public Perspective getPerspective() {
		return perspective;
	}

	public void setPerspective(Perspective perspective) {
		this.perspective = perspective;
	}

	public String toString() {
		return name;
	}

	public void setCaptured(Piece piece) {
		activePieces.remove(piece);
		capturedPieces.add(piece);
	}

}