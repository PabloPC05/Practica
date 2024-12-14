package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;
import tp1.logic.Direction;

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
    
    // Constructor con parametros
    public CaverRole(Direction direction){
        super(NAME, DETAILS, HELP, ICON_DOWN, SYMBOL);
        hasCaved = false;
        this.direction = direction;
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
            lemming.falls();
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
        String[] role = input.split("\\s");
        if (matchRoleName(role[0])){ 
            switch(role[1]){
                case "RIGHT":
                    direction = Direction.RIGHT;
                case "LEFT": 
                    direction = Direction.LEFT;
                case "DOWN":
                    direction = Direction.DOWN;
                case "RIGHT_DOWN":
                    direction = Direction.RIGHT_DOWN;
                case "LEFT_DOWN":
                    direction = Direction.LEFT_DOWN;
                default:
                    direction = Direction.RIGHT;
            }
            return new CaverRole(direction);
        }
        return null;    
    }
}
