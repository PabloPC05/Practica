package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class AbstractRole {

    private final String name;
    private final String symbol;
    private final String icon; 
	private final String help;
	private final String details;

	public AbstractRole(String name, String details, String help, String icon, String symbol) {
		this.name = name;
        this.symbol = symbol;
        this.icon = icon;
		this.help = help;
		this.details = details;
	}

    public String getIcon(Lemming lemming){
        return icon;
    }

    public String getSymbol(){
        return symbol;
    }

    public String getHelp(){
        return help;
    }

    public String getDetails(){
        return details;
    }

    public boolean matchRoleName(String str){
        return str.equalsIgnoreCase(name) || str.equalsIgnoreCase(symbol);
    }

    public String helpText(){
        StringBuilder help = new StringBuilder();
		help.append(Messages.COMMAND_HELP_TEXT.formatted(getDetails(), getHelp()));
		return Messages.LINE_2TABS.formatted(help.toString());
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

    public boolean roleMatch(String input){
        return input.equalsIgnoreCase(name) || input.equalsIgnoreCase(symbol);
    }
}
