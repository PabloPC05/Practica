package tp1.logic.lemmingRoles;

import tp1.logic.*;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class WalkerRole {

	public void play(Lemming lemming) {
	    lemming.move();
	}

	public String getIcon(Lemming lemming) {
        if (lemming.getDirection().equals(Direction.DOWN)) {
            if (lemming.getPreviousDirection().equals(Direction.LEFT)) return Messages.LEMMING_LEFT;
            else return Messages.LEMMING_RIGHT;
        } 
        else if (lemming.getDirection().equals(Direction.LEFT)) return Messages.LEMMING_LEFT;
        else return Messages.LEMMING_RIGHT;
    }
}
