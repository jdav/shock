package com.malleamus.shock;

public enum Direction { N, NE, E, SE, S, SW, W, NW;
	
	public Direction perspect(Perspective perspective) {
		if (perspective.equals(Perspective.REVERSE)) {
			switch (this) {
				case N: 	return S;
				case S:		return N;
				case E:		return W;
				case W:		return E;
				case NE:	return SW;
				case NW:	return SE;
				case SE:	return NW;
				case SW:	return NE;
				default: 	return this; //Impossible
			}
		} else {
			return this;
		}
	}
}