package tp1.logic.Interfaces;
import tp1.logic.*;

public interface GameWorld {
    
    abstract boolean isInAir(Position pos);
    //abstract boolean falls(Position pos);
    //abstract boolean lemmingArrived(Lemming lem);
    //abstract void removengs();
    //abstract void removeExitLemmings();
    abstract boolean wallAtPosition(Position pos);
    abstract boolean isExit(Position pos);
    abstract void addExitLemmings();
}
