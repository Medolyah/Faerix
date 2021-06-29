package de.faerix.base.enums;

public enum StageEnum {
	Menu(0),
	Prologue(1),
	DawnStage(2),
	NightskyStage(3),
	MoonStage(4),
	Sakura(5),
	Underwater(6),
	Desert(7),
	Ending(12),
	Epilogue(13),
	Gameover(14),
	Credits(15);

	
	 private int numVal;

	 StageEnum(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
