package tp1.logic.lemmingRoles;

import tp1.logic.*;
import tp1.logic.gameobjects.Lemming;

public class WalkerRole {

	 public void advance(Lemming lem) {
		 lem.move();
	 }

	 @Override
	 public String toString() {
		 return null;
	 }
	
}
