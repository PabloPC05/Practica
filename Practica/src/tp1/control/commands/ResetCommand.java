package tp1.control.commands;

import tp1.logic.Interfaces.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public class ResetCommand extends NoParamsCommand{

	// Forman parte de atributos de estado
	 
    private static final String NAME = Messages.COMMAND_RESET_NAME;
    private static final String SHORTCUT = Messages.COMMAND_RESET_SHORTCUT;
    private static final String DETAILS = Messages.COMMAND_RESET_DETAILS;
    private static final String HELP = Messages.COMMAND_RESET_HELP;


	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP); 
	}

	
	public Command parse(String[] commandWords){
		Command com = null;
		// Si es un comando sin parametros deberia devolver this
		// Si es un comando con parametros deberia devolver un nuevo objeto del tipo de comando correspondiente
		if(matchCommandName(commandWords[0])) com = new ResetCommand();
		return com;
	}

	@Override
	public void execute(GameModel game, GameView view){
		game.reset();
	}

}