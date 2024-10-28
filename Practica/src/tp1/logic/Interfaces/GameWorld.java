package tp1.logic.Interfaces;
import tp1.logic.*;
import tp1.logic.gameobjects.Lemming;

public interface GameWorld {
    
    abstract boolean isInAir(Position pos);
    abstract boolean isFalling(Position pos);
    abstract boolean lemmingArrived(Lemming lem);
    abstract void removeDeadLemmings();
    abstract void removeExitLemmings();
    abstract boolean isInsideLimits(Position pos);

}
