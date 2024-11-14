package tp1.control.commands;

import tp1.logic.Interfaces.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends Command{

	// Forman parte de atributos de estado
	 
    private static final String NAME = Messages.COMMAND_RESET_NAME;
    private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
    private static final String HELP = Messages.COMMAND_RESET_HELP;

	int level;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP); 
		level = - 1;
	}

	
    @Override
    public Command parse(String[] commandWords) {
		Command com = null;
        if (matchCommandName(commandWords[0])) {
			ResetCommand newCommand =  new ResetCommand();
            if (commandWords.length > 1) {
                try {
                    newCommand.level = Integer.parseInt(commandWords[1]);
                } catch (NumberFormatException e) {}
				com = newCommand;
            } else {
                com = new ResetCommand();
            }
        }
        return com;
    }

	@Override
	public void execute(GameModel game, GameView view){
		if(level == -1){
			game.reset(game.getLevel());
		}
		else if(game.existsLevel(level)){
			game.reset(level);
		}
		else {
			view.showError(Messages.INVALID_LEVEL_NUMBER);

		}
	}

}