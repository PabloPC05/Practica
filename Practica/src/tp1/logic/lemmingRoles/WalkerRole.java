package tp1.logic.lemmingRoles;

import tp1.logic.*;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class WalkerRole implements LemmingRole {

    private static final String NAME = Messages.WALKER_ROLE_NAME;
    private static final String SYMBOL = Messages.WALKER_ROLE_SYMBOL;
    private static final String RIGHT_ICON = Messages.LEMMING_RIGHT;
    private static final String LEFT_ICON = Messages.LEMMING_LEFT;
    private static final String HELP = Messages.WALKER_ROLE_HELP;

    @Override
	public void play(Lemming lemming) {
	    lemming.move();
	}

    @Override
	public String getIcon(Lemming lemming) {
        if(lemming.getDirection() == Direction.RIGHT) {
            return RIGHT_ICON;
        } else {
            return LEFT_ICON;
        }
    }

    @Override
    public boolean matchRoleName(String str) {
        return NAME.equalsIgnoreCase(str) || SYMBOL.equalsIgnoreCase(str);
    }

    @Override
    public String getSymbol() {
        return SYMBOL;
    }

    @Override
    public void start(Lemming lemming) {

    }

    @Override
    public boolean roleMatch(String input) {
        return input.equalsIgnoreCase(NAME) || input.equalsIgnoreCase(SYMBOL);
    }

    @Override
    public LemmingRole parse(String input) {
        if (roleMatch(input)) return new WalkerRole();
        return null;
    }

    @Override
    public String helpText() {
        return HELP;
    }
}


