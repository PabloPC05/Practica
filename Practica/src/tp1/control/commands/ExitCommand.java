package tp1.control.commands;

import tp1.logic.Game;
import tp1.view.GameView;
import tp1.view.Messages;

public class ExitCommand extends NoParamsCommand{

	// Forman parte de atributos de estado
	private static final String NAME = Messages.COMMAND_EXIT_NAME;
	private static final String SHORTCUT = Messages.COMMAND_EXIT_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_EXIT_DETAILS;
	private static final String HELP = Messages.COMMAND_EXIT_HELP;

	public ExitCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP); 
	}

	@Override
	public Command parse(String[] commandWords){
		Command com = null;
		// Si es un comando sin parametros deberia devolver this
		// Si es un comando con parametros deberia devolver un nuevo objeto del tipo de comando correspondiente
		if(matchCommandName(commandWords[0])) com = new ExitCommand();
		return com;
	}

	@Override
	public void execute(Game game, GameView view){
		game.exit();
	}

}
