package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.Messages;

public class DownCaverRole implements LemmingRole{

    private static final String NAME = Messages.DOWN_CAVER_ROLE_NAME;
    private static final String SYMBOL = Messages.DOWN_CAVER_ROLE_SYMBOL;
    private static final String ICON = Messages.LEMMING_DOWN_CAVER;
    private static final String HELP = Messages.DOWN_CAVER_ROLE_HELP;
    private static final String DETAILS = Messages.DOWN_CAVER_ROLE_DETAILS;

    public DownCaverRole(){}


    public void start(Lemming lemming){

    }

    public void play (Lemming lemming){

    }

    public String getIcon(Lemming lemming){
        return ICON;
    }

    public LemmingRole parse(String input){
        if (matchRoleName(input)) return new DownCaverRole();
        return null;    
    }

    public boolean roleMatch(String input){
        return input.equals(NAME);
    }    

    public String helpText(){
        StringBuilder help = new StringBuilder();
		help.append(Messages.COMMAND_HELP_TEXT.formatted(DETAILS, HELP));
		return Messages.LINE_2TABS.formatted(help.toString());
    }

    public String getSymbol(){
        return SYMBOL;

    }

    public boolean matchRoleName(String str){
        return str.equalsIgnoreCase(NAME) || str.equalsIgnoreCase(SYMBOL);
    }





    public boolean interactWith(Wall wall, Lemming lemming){
        return false;

    }
    public boolean interactWith(Lemming receiver, Lemming lemming){
        return false;

    }
    public boolean interactWith(ExitDoor exit, Lemming lemming){
        return false;

    }
}
