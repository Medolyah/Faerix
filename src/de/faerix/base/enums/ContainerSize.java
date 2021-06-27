package de.faerix.base.enums;

public enum ContainerSize {
	
	width(1500),
	height(900);
	
	
	 private int numVal;

	ContainerSize(int numVal) {
       this.numVal = numVal;
   }
	
	   public int getNumVal() {
        return numVal;
    }

}
