package tp1.control.commands;

import tp1.logic.Interfaces.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class HelpCommand extends NoParamsCommand {

    private static final String NAME = Messages.COMMAND_HELP_NAME;
    private static final String SHORTCUT = Messages.COMMAND_HELP_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_HELP_DETAILS;
    private static final String HELP = Messages.COMMAND_HELP_HELP;

    public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public Command parse(String[] commandWords) {
		Command com = null;
		// Si es un comando sin parametros deberia devolver this
		// Si es un comando con parametros deberia devolver un nuevo objeto del tipo de comando correspondiente
		if(matchCommandName(commandWords[0])) com = new HelpCommand();
		return com;
	}
	
	@Override
	public void execute(GameModel game, GameView view) {
		view.showMessage(Messages.HELP_AVAILABLE_COMMANDS + Messages.LINE_SEPARATOR);
		view.showMessage(CommandGenerator.commandHelp());
	}

}
