package tp1.logic;


import tp1.exceptions.GameLoadException;
import tp1.logic.Interfaces.GameConfiguration;
import tp1.logic.Interfaces.GameWorld;

public class FileGameConfiguration implements GameConfiguration {

    public static final GameConfiguration NONE = new FileGameConfiguration();

    public FileGameConfiguration() {
    }

    public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException{
    }

    @Override
    public GameObjectContainer getGameObjects() {
        // TODO: Implement this method
        return null;
    }
    @Override
    public int numLemmingsToWin() {
        // TODO: Implement this method
        return 0;
    }
    @Override
    public int numLemmingsDead() {
        // TODO: Implement this method
        return 0;
    }
    @Override
    public int getCycle() {
        // TODO: Implement this method
        return 0;
    }
    @Override
    public int numLemmingInBoard() {
        // TODO: Implement this method
        return 0;
    }
    @Override
    public int numLemmingsExit() {
        // TODO: Implement this method
        return 0;
    }
}
