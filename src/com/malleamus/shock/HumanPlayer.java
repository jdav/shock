package com.malleamus.shock;

public class HumanPlayer extends Player {
	
	private UI ui = null;

	public HumanPlayer(String name, Perspective perspective, UI ui) {
		super(name, perspective);
		this.ui = ui;
	}

	@Override
	public Action chooseAction() {
		return ui.listen();
	}

}
