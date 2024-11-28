package tp1.logic.Interfaces;

import tp1.exceptions.GameLoadException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel {

    // Funciones autodescriptivas definidas en Game
	abstract public boolean isFinished();
    abstract public int getLevel();
    abstract public void update();
    abstract public void reset(int level);
    abstract public void exit();
    abstract public boolean setRole(LemmingRole role, Position pos, String roleName) throws OffBoardException;
	abstract public boolean existsLevel(int l);
    abstract public void increaseCycle();

    public void load(String fileName) throws GameLoadException;
}
