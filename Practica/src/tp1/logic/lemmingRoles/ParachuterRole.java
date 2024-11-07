package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class ParachuterRole implements LemmingRole {

    private static final String NAME = Messages.PARACHUTER_ROLE_NAME;
    private static final String SYMBOL = Messages.PARACHUTER_ROLE_SYMBOL;
    private static final String ICON = Messages.LEMMING_PARACHUTE;
    private static final String HELP = Messages.PARACHUTER_ROLE_HELP;
    
    public ParachuterRole() {
    	
    }
    
    @Override
    public void start(Lemming lemming) {
    }

    @Override
    public void play(Lemming lemming) {
        if(!lemming.crashingIntoWall()) {
        	lemming.falls();
            lemming.featherFall();
        }
        else lemming.disableRole();
    }

    @Override
    public String getIcon(Lemming lemming) {
        return ICON;
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
    public LemmingRole parse(String input) {
        if (matchRoleName(input)) return new ParachuterRole();
        return null;
    }

    @Override
    public boolean roleMatch(String input) {
        return input.equals(NAME);
    }

    @Override
    public String helpText() {
        return HELP;
    }
    
}
