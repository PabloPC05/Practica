package tp1.control.commands;

import java.util.ArrayList;
import tp1.exceptions.CommandExecuteException;
import tp1.exceptions.CommandParseException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.exceptions.RoleParseException;
import tp1.logic.Interfaces.GameModel;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.*;
import tp1.view.GameView;
import tp1.view.Messages;

public class SetRoleCommandExtended extends Command{

    private static final String NAME = Messages.COMMAND_SET_ROLE_EXTENDED_NAME;
	private static final String SHORTCUT = Messages.COMMAND_SET_ROLE_EXTENDED_SHORTCUT;
	private static final String DETAILS = Messages.COMMAND_SET_ROLE_EXTENDED_DETAILS;
	private static final String HELP = Messages.COMMAND_SET_ROLE_EXTENDED_HELP;

    private String roleName;
    private ArrayList <String> roleInfo;
    private LemmingRole role; 
    private int num;
    private boolean valid = true;

    // Constructor
    public SetRoleCommandExtended() {
        super(NAME, SHORTCUT, DETAILS, HELP);
        roleInfo = new ArrayList<String>();
    }  

    // Funcion para parsear el comando (esta compuesto por el propio comando, el nombre del rol, y la posicion ROW, COL)
    @Override
    public Command parse(String[] commandWords) throws CommandParseException {
        Command com = null;
        // Comprobamos que el comando sea correcto
        if (matchCommandName(commandWords[0])) {
            SetRoleCommandExtended newCommand = new SetRoleCommandExtended();
            // El comando es erróneao si no tiene 3 elementos, pues se necesitan 3, el comando en sí, el role y el numero de lemmings qué queremos poner
            newCommand.valid = commandWords.length >= 3;
            if(!newCommand.valid) throw new CommandParseException(Messages.COMMAND_SET_ROLE_INVALID_NUMBER_ARGS);
            // Comprobamos el rols
            newCommand.roleName = commandWords[1];
            try {
                    newCommand.role = LemmingRoleFactory.parse(newCommand.roleName);
                    newCommand.roleName = newCommand.role.getName();
                } catch (RoleParseException e) {
                    throw new CommandParseException(Messages.INVALID_COMMAND, e);
                }
            // leemos el numero de lemmings a los que queremos poner el rol escogido
            try {
                newCommand.num = Integer.parseInt(commandWords[2]);
            } catch (NumberFormatException e) {
                throw new CommandParseException();
            }
            // Mantenemos la logica de los roles que pueden tener atributos
            if(commandWords.length > 3){
                newCommand.roleInfo.ensureCapacity(commandWords.length-3); 
                for(int i = 3; i < commandWords.length-2; i++){
                    newCommand.roleInfo.add(commandWords[i]);
                }
                try {
                    newCommand.roleInfo = newCommand.role.parseInfo(newCommand.roleInfo);
                } catch (ObjectParseException e) {
                    String str = "";
                    for(int i = 0; i < commandWords.length; i++){ str += ' '; str += commandWords[i];}
                    throw new CommandParseException(e.getMessage().formatted(str));
                }
            }
            com = newCommand;
        }
        return com;
    }

    // Funcion para ejecutar el comando (cambia el rol de un lemming) y muestra un mensaje de error correspondiente si no se puede
    @Override
    public void execute(GameModel game, GameView view) throws CommandExecuteException {
        if(num <= 0){
            throw new CommandExecuteException(); 
        }

        if (!game.setRoleExtended(role, num, roleName)) {
            //view.showError(Messages.LINE.formatted(Messages.EXECUTE_PROBLEM));
            //view.showError();
        }
        else{
            game.update();
            view.showGame();
        }
    } 

    // Funcion para traducir la fila de la posicion de la letra a un numero
    private int traslateRow(String column) {
        char letter = column.charAt(0);
        return letter - 'A';
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

