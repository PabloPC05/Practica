package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.*;

public class AbstractRole {
    public boolean interactWith(Wall wall, Lemming lemming){
        return false; 
    }

    public boolean interactWith(Lemming receiver, Lemming lemming){
        return false; 
    }

    public boolean interactWith(ExitDoor exit, Lemming lemming){
        return false; 
    }
}
