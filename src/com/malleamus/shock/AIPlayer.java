package com.malleamus.shock;

public class AIPlayer extends Player {

	public AIPlayer(String name, Perspective perspective) {
		super(name, perspective);
	}
	
	public Action chooseAction() {
		Piece selectedPiece = null;
		
		if (inCheck()) {
			selectedPiece = king;
		} else {
			selectedPiece = activePieces.get(random.nextInt(activePieces.size()));
		}
		
		Moves candidateDestinations = selectedPiece.getPossibleMoves();
		
		//Select random destination
		if (candidateDestinations.isEmpty()) {
			return null;
		} else {
			return candidateDestinations.get(random.nextInt(candidateDestinations.size()));
		}
	}
}
