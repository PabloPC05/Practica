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

    private String roleName;
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
    		view.showError(Messages.UNKNOWN_ROLE.formatted(roleName));
    	}
    }   

    @Override
    public Command parse(String[] commandWords) {
        Command com = null;
        if (matchCommandName(commandWords[0])) {
            SetRoleCommand newCommand = new SetRoleCommand();
            newCommand.roleName = commandWords[1];
            newCommand.role = LemmingRoleFactory.parse(newCommand.roleName);
            try {
                newCommand.col = Integer.parseInt(commandWords[2]);
                newCommand.row = Integer.parseInt(commandWords[3]);
            } catch (NumberFormatException e) {}
            com = newCommand;
        }
        return com;
    }

    @Override
    public String getHelp() {
        StringBuilder help = new StringBuilder();
        help.append(super.getHelp());
        help.append(Messages.LINE_SEPARATOR);
        help.append(LemmingRoleFactory.lemmingRolesHelp());
        return help.toString();
    }
}

