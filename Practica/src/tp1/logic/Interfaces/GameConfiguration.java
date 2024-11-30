package tp1.logic.Interfaces;

import tp1.logic.GameObjectContainer;

public interface GameConfiguration {

    // game status
    public int getCycle();
    public int numLemmingInBoard();
    public int numLemmingsDead();
    public int numLemmingsExit();
    public int numLemmingsToWin();

    public GameObjectContainer getGameObjects();

    public void setGameConfig(GameConfiguration gameConfig);
    public void setGameConfig(int cycle, int numLemmingInBoard, int numLemmingsDead, int numLemmingsExit, int numLemmingsToWin, GameObjectContainer gameObjects);

}