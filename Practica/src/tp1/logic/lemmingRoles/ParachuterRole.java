package tp1.logic.lemmingRoles;

import tp1.logic.*;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class ParachuterRole implements LemmingRole {
    @Override
    public void start(Lemming lemming) {
    }

    @Override
    public void play(Lemming lemming) {
        lemming.isFalling();
    }

    @Override
    public String getIcon(Lemming lemming) {
        return Messages.LEMMING_PARACHUTE;
    }
    
}
