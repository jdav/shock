package com.malleamus.shock;

public enum Rank {
	R1, R2, R3, R4, R5, R6, R7, R8;
	
	public boolean hasNext() {
		return this != R8;
	}
	
	public Rank next() {
		return Rank.values()[(this == R8 ? null : ordinal() + 1)];
	}
	
	public boolean hasPrevious() {
		return this != R1;
	}
	
	public Rank previous() {
		return Rank.values()[(this == R1 ? null : ordinal() - 1)];
	}
}
