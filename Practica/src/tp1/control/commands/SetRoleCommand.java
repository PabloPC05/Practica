package tp1.control.commands;

import tp1.logic.Interfaces.GameModel;
import tp1.logic.lemmingRoles.*;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{

    private static final String NAME = Messages.COMMAND_SET_ROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SET_ROLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SET_ROLE_DETAILS;
	private static final String HELP = Messages.COMMAND_SET_ROLE_HELP;

    private LemmingRole role; 
    private int col; 
    private int row;

    public SetRoleCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }

    @Override
    public void execute(GameModel game, GameView view) {
    	if(role != null) {
    		if(!game.setRole(role, col, row)) {
    			view.showError(Messages.COMMAND_SET_ROLE_INVALID_ARGUMENT);
    		}
    	}
    	else {
    		view.showError(Messages.COMMAND_SET_ROLE_ROLE_NOT_FOUND);
    	}
    }   

    @Override
    public Command parse(String[] commandWords) {
        Command com = null;
        if(matchCommandName(commandWords[0])) com = new SetRoleCommand();
        role = LemmingRoleFactory.parse(commandWords[1]);
        try{
	        col = Integer.parseInt(commandWords[2]);
	        row = Integer.parseInt(commandWords[3]);
        }catch(NumberFormatException e) {}
        return com;
    }
       

    @Override
	protected boolean matchCommandName(String name) {
		return getShortcut().equalsIgnoreCase(name) || getName().equalsIgnoreCase(name) || name.equals(Messages.EMPTY);
	}
}

