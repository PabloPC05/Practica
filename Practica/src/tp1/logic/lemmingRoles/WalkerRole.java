package tp1.logic.lemmingRoles;

import tp1.logic.*;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class WalkerRole implements LemmingRole {

    @Override
	public void play(Lemming lemming) {
	    lemming.move();
	}

    @Override
	public String getIcon(Lemming lemming) {
        if(lemming.getDirection() == Direction.RIGHT) {
            return Messages.LEMMING_RIGHT;
        } else {
            return Messages.LEMMING_LEFT;
        }
    }

    @Override
    public void start(Lemming lemming) {}
}
