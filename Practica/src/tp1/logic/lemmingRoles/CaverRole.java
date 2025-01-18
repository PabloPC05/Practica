package tp1.logic.lemmingRoles;

import java.util.ArrayList;
import tp1.exceptions.ObjectParseException;
import tp1.logic.Direction;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class CaverRole extends AbstractRole implements LemmingRole{

    // Atributos
    private static final String NAME = Messages.CAVER_ROLE_NAME;
    private static final String SYMBOL = Messages.CAVER_ROLE_SYMBOL;
    private static final String ICON_RIGHT = Messages.CAVER_ROLE_ICON_RIGHT;
    private static final String ICON_LEFT = Messages.CAVER_ROLE_ICON_LEFT;
    private static final String ICON_DOWN = Messages.CAVER_ROLE_ICON_DOWN;
    private static final String ICON_RIGHT_DOWN = Messages.CAVER_ROLE_ICON_RIGHT_DOWN;
    private static final String ICON_LEFT_DOWN = Messages.CAVER_ROLE_ICON_LEFT_DOWN;
    private static final String HELP = Messages.CAVER_ROLE_HELP;
    private static final String DETAILS = Messages.CAVER_ROLE_DETAILS;

    private boolean hasCaved;
    private Direction direction;

    // Constructor por defecto
    public CaverRole(){
        super(NAME, DETAILS, HELP, ICON_DOWN, SYMBOL);
        hasCaved = false;
        this.direction = Direction.RIGHT;
    }

    // Metodos
    // Funcion start de DownCaver (no hace nada)
    @Override
    public void start(Lemming lemming){
    }

    // Funcion play de DownCaver
    @Override
    public void play (Lemming lemming){
        // Interactua con todo lo que haya en su camino
        lemming.interactWithEverything();
        // Si ha cavado, el lemming cae y se le pone la fuerza de caida a 0
        if(hasCaved){ 
            lemming.movesWithDirection(direction);
            lemming.featherFall();
            hasCaved = false;
        }
        else{
            // Si el lemming no ha cavado, se desactiva el rol y se mueve con normalidad manteniendo la direccion que tenia
            lemming.disableRole();
            lemming.featherFall();
            lemming.move();
        }
    }

    // Funcion que interactua con una pared
    @Override
    public boolean interactWith(Wall wall, Lemming lemming){
        boolean interaction = false;
        // Si el lemming choca con una pared, la destruye y cava
        if(lemming.crashingIntoWallWDir(wall, direction)){
            wall.dies();
            hasCaved = true;
            interaction = true;
        }
        // Devuelve si ha habido interaccion
        return interaction;
    }

    @Override
    public boolean interactWith(MetalWall metalWall, Lemming lemming){
        boolean interaction = false;
        // Si el lemming choca con una pared de metal, no cava y se desactiva el rol
        if(lemming.crashingIntoWallWDir(metalWall, direction)){
            hasCaved = false;
            interaction = true;
        }
        // Devuelve si ha habido interaccion
        return interaction;
    }

    // Funcion para comprobar si el rol es el correcto
    @Override
    public LemmingRole parse(String input){
        if (matchRoleName(input))return new CaverRole();
        return null;    
    }

    @Override
    public ArrayList<String> parseInfo(ArrayList<String> input) throws ObjectParseException{
        ArrayList<String> returnValue = new ArrayList<String>(1);
        String str = input.get(0);
        str = str.toLowerCase();
        switch(str){
            case "right":
                direction = Direction.RIGHT;
                returnValue.add("RIGHT");
                break;
            case "left": 
                direction = Direction.LEFT;
                returnValue.add("LEFT");
                break;

            case "down":
                direction = Direction.DOWN;
                returnValue.add("DOWN");
                break;

            case "right_down":
                direction = Direction.RIGHT_DOWN;
                returnValue.add("RIGHT_DOWN");
                break;

            case "left_down":
                direction = Direction.LEFT_DOWN;
                returnValue.add("LEFT_DOWN");
                break;

            default:
                direction = null;
                returnValue.add("");
                throw new ObjectParseException();
        }
        return returnValue;
    }

    @Override
    public LemmingRole clone(){
        CaverRole newRole = new CaverRole();
        newRole.direction = this.direction;
        return newRole;
    }
}
