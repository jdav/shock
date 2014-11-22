package com.malleamus.shock;

public enum File {
	FA, FB, FC, FD, FE, FF, FG, FH;
	
	public boolean hasNext() {
		return this != FH;
	}
	
	public File next() {
		return File.values()[(this == FH ? null : ordinal() + 1)];
	}

	public boolean hasPrevious() {
		return this != FA;
	}

	public File previous() {
		return File.values()[(this == FA ? null : ordinal() - 1)];
	}
}
