package tp1.logic.Interfaces;

public interface GameStatus {
    abstract int getCycle();
    abstract int getLevel();
    abstract int getNumLemmings();
    abstract int numLemmingsInBoard();
    abstract int numLemmingsDead();
    abstract int numLemmingsExit();
    abstract int numLemmingsToWin();
    abstract int numLemmingsLeftToWin();
    abstract String positionToString(int col, int row);

}
