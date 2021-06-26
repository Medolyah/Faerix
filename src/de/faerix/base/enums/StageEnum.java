package de.faerix.base.enums;

public enum StageEnum {
	Menu(0),
	Prologue(1),
	DawnStage(2),
	NightskyStage(3),
	Epilogue(13),
	Gameover(14);

	
	 private int numVal;

	 StageEnum(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
