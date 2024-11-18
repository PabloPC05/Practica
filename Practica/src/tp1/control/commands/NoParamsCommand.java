package tp1.control.commands;

public abstract class NoParamsCommand extends Command {

	// Constructor abstracto para los comandos sin parametros
	public NoParamsCommand(String name, String shortcut, String details, String help) {
		super(name, shortcut, details, help);
	}

}
