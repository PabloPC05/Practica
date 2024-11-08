package tp1.logic.Interfaces;
import tp1.logic.gameobjects.GameItem;
import tp1.logic.*;

public interface GameWorld {

    abstract boolean isInAir(Position pos);
    abstract boolean wallAtPosition(Position pos);
    abstract boolean isExit(Position pos);
    abstract void addExitLemmings();
    abstract boolean leavingTheBoard(Position pos);
    abstract void addDeadLemmings();
    abstract int getLevel();
    abstract boolean receiveInteractionsFrom(GameItem obj);

}
