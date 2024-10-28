package tp1.logic.Interfaces;
import tp1.logic.*;

public interface GameWorld {
    
    abstract boolean isInAir(Position pos);
    abstract boolean isFalling(Position pos);
    abstract boolean lemmingArrived();
    abstract void removeDeadLemmings();
    abstract void removeExitLemmings();
    abstract boolean isInsideLimits(Position pos);

}
