package tp1.control.commands;

import tp1.exceptions.*;

public abstract class NoParamsCommand extends Command {

	// Constructor abstracto para los comandos sin parametros
	public NoParamsCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}
	
	 public Command parse(String[] commandWords) throws CommandParseException {
		 	if (commandWords.length < 1 || !matchCommandName(commandWords[0]))
		 		return null;
		         
		 	if (commandWords.length == 1 && matchCommandName(commandWords[0]))
		 		return this;
		     
		 	throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
		 	}

}
