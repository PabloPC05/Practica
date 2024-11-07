package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class ParachuterRole implements LemmingRole {

    private static final String NAME = Messages.PARACHUTER_ROLE_NAME;
    private static final String SYMBOL = Messages.PARACHUTER_ROLE_SYMBOL;
    private static final String ICON = Messages.LEMMING_PARACHUTE;
    private static final String HELP = Messages.PARACHUTER_ROLE_HELP;
    private static final String DETAILS = Messages.PARACHUTER_ROLE_DETAILS;
    
    public ParachuterRole() {}
    
    
    @Override
    public void start(Lemming lemming) {
        //Supongo que habria que comprobar antes de que se establezca el rol que no haya una pared debajo, 
        // i.e que esté en el aire el lemming
    }

    @Override
    public void play(Lemming lemming) {
        if(lemming.crashingIntoWall()) lemming.disableRole();
        else{
            lemming.falls();
            lemming.featherFall();
        }
    }

    @Override
    public String getIcon(Lemming lemming) {
        return ICON;
    }

    @Override
    public boolean matchRoleName(String str) {
        return str.equalsIgnoreCase(NAME) || str.equalsIgnoreCase(SYMBOL);
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
        StringBuilder help = new StringBuilder();
		help.append(Messages.COMMAND_HELP_TEXT.formatted(DETAILS, HELP));
		return Messages.LINE_2TABS.formatted(help.toString());
    }






    public boolean interactWith(Wall wall, Lemming lem){
        lem.disableRole();
        return true;
    }

    public boolean interactWith(Lemming receiver, Lemming lem){
        return true;
    }

    public boolean interactWith(ExitDoor exit, Lemming lemming){
        return false;
    }
    
}
