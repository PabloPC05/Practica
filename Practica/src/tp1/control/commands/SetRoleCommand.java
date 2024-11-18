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

    // Constructor
    public SetRoleCommand() {
        super(NAME, SHORTCUT, DETAILS, HELP);
    }  

    // Funcion para parsear el comando (esta compuesto por el propio comando, el nombre del rol, y la posicion ROW, COL)
    @Override
    public Command parse(String[] commandWords) {
        Command com = null;
        // Comprobamos que el comando sea correcto
        if (matchCommandName(commandWords[0])) {
            SetRoleCommand newCommand = new SetRoleCommand();
            // Comprobamos el rol
            newCommand.roleName = commandWords[1];
            newCommand.role = LemmingRoleFactory.parse(newCommand.roleName);
            // Comprobamos la posicion
            try {
                newCommand.col = Integer.parseInt(commandWords[3]);
                newCommand.col--;
                newCommand.row = traslateRow(commandWords[2]);
            } catch (NumberFormatException e) {}
            com = newCommand;
        }
        return com;
    }

    // Funcion para ejecutar el comando (cambia el rol de un lemming) y muestra un mensaje de error correspondiente si no se puede
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

    // Funcion para traducir la fila de la posicion de la letra a un numero
    private int traslateRow(String column) {
        char letter = column.toLowerCase().charAt(0);
        return letter - 'a';
    }

    // Funcion para obtener la ayuda del comando (los roles de los lemmings)
    @Override
    public String getHelp() {
        StringBuilder help = new StringBuilder();
        help.append(super.getHelp());
        help.append(Messages.LINE_SEPARATOR);
        help.append(LemmingRoleFactory.lemmingRolesHelp());
        return help.toString();
    }
}

