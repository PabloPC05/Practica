package tp1.control.commands;

import tp1.logic.Interfaces.GameModel;
import tp1.view.GameView;
import tp1.view.Messages;

public abstract class Command {

	// Forman parte de atributos de estado
	private final String name;
	private final String shorcut;
	private final String details;
	private final String help;
	
	public Command(String name, String shorcut, String details, String help) {
		this.name = name;
		this.shorcut = shorcut;
		this.details = details;
		this.help = help;
	}

	protected String getName() { return name; }
	protected String getShortcut() { return shorcut; }
	protected String getDetails() { return details; }
	protected String getHelp() { return help; }

	// Metodos abstractos
	public abstract void execute(GameModel game, GameView view);	  
	public abstract Command parse(String[] commandWords);
	// Usa los metodos de la clase String para saber que comando se ha introducido
	protected boolean matchCommandName(String name) {
		return getShortcut().equalsIgnoreCase(name) || getName().equalsIgnoreCase(name);
	}

	public String helpText(){
		return Messages.LINE_TAB.formatted(Messages.COMMAND_HELP_TEXT.formatted(getDetails(), getHelp()));
	}
}
