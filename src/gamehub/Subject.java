package gamehub;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	   private static List<EnergyObserver> observers = new ArrayList<EnergyObserver>();
	   private int mana;
	   private int hp;

	   public int getMana() {
	      return mana;
	   }
	   
	   public int getHp() {
		      return hp;
		   }

	   public void setMana(int mana) {
	      this.mana = mana;
	      this.notifyAllObserversManaChange();
	   }
	   
	   public void setHp(int hp) {
		   this.notifyAllObserversHpChange();
	   }

	   public void attach(EnergyObserver observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObserversManaChange(){
	      for (EnergyObserver observer : observers) {
	         observer.updateHp();
	      }
	   } 	
	   public void notifyAllObserversHpChange(){
		      for (EnergyObserver observer : observers) {
		         observer.updateHp();
		      }
		   } 	
}
