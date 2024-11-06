package tp1.control.commands;

import tp1.logic.Interfaces.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommand extends Command{
    private static final String NAME = Messages.COMMAND_SET_ROLE_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SET_ROLE_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SET_ROLE_DETAILS;
	private static final String HELP = Messages.COMMAND_SET_ROLE_HELP;

    SetRoleCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }
    @Override
    public void execute(GameModel game, GameView view) {
        game.setRole(position, role);
    }
    @Override
    public Command parse(String[] commandWords) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String helpText() {
        // TODO Auto-generated method stub
        return null;
    }
}
