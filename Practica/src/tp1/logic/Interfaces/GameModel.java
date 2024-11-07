package tp1.logic.Interfaces;

import tp1.logic.lemmingRoles.LemmingRole;

public interface GameModel {
    public boolean isFinished();
	public void update();
	public void reset(int level);
	public void exit();
	public boolean setRole(LemmingRole role, int col, int row);
}
