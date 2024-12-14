package tp1.logic.lemmingRoles;

import java.util.ArrayList;
import tp1.exceptions.ObjectParseException;
import tp1.logic.Direction;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class DroneRole extends AbstractRole implements LemmingRole{

    // Atributos
    private static final String NAME = Messages.DRONE_ROLE_NAME;
    private static final String SYMBOL = Messages.DRONE_ROLE_SYMBOL;
    private static final String ICON = Messages.DRONE_ROLE_ICON;
    private static final String HELP = Messages.DRONE_ROLE_HELP;
    private static final String DETAILS = Messages.DRONE_ROLE_DETAILS;

    private ArrayList<Direction> directions;
    int index = 0;

    // Constructor por defecto
    public DroneRole(){
        super(NAME, DETAILS, HELP, ICON, SYMBOL);
        directions = new ArrayList <Direction>();
    }

    // Metodos
    // Funcion para que el walking lemming se mueva
    @Override
	public void play(Lemming lemming) {
        // Si aun siguen quedado direcciones y el lemming no ha chocado con nada, pues continuamos en el array y nos movemos
        if(index < directions.size()){
            // Si no ha interactuado con nada o aun quedan direcciones que poner
            if(!lemming.interactWithEverything() && !lemming.crashingIntoLimits(directions.get(index))) lemming.movesWithDirection(directions.get(index));
            index++;
        } 
        // Si ha interactuado, pero sigue vivo rebota
        else { 
            lemming.disableRole();
        }
	}

    // Funcion para startear el walking lemming (no hace nada)
    @Override
    public void start(Lemming lemming) {
        //No hace nada
    }

    // Funcion que comprueba si el rol es el correcto
    @Override
    public LemmingRole parse(String input) {
        if (roleMatch(input)) return new DroneRole();
        return null;
    }

    // Funcion para interactuar con una pared, si interactua con un pared no se mueve
    @Override
    public boolean interactWith(Wall wall, Lemming lemming) {
        boolean interaction = false;
        if(lemming.crashingIntoWallWDir(wall, directions.get(index))){ 
            interaction = true;
        }
        return interaction;
    }
    
    // Funcion para interactuar con una pared de metal, si interactua con una pared no se mueve
    @Override
    public boolean interactWith(MetalWall wall, Lemming lemming) {
        boolean interaction = false;
        if(lemming.crashingIntoWallWDir(wall, directions.get(index))){ 
            interaction = true;
        }
        return interaction;
    }

    @Override
    public ArrayList<String> parseInfo(ArrayList<String> input) throws ObjectParseException{
        ArrayList<String> returnValue = new ArrayList<String>(input);
        for(int i = 0; i < input.size(); i++){
            String str = input.get(i);
            Direction dir = null;
            try {
                dir = Lemming.getDirectionFrom(str);
            } catch (ObjectParseException e) {
                throw e;
            }
            directions.add(dir);
        }
        return returnValue;
    }
}
