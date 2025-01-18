package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class HorizontalCaver extends AbstractRole implements LemmingRole{

    // Atributos
    private static final String NAME = Messages.HORIZONTAL_CAVER_ROLE_NAME;
    private static final String SYMBOL = Messages.HORIZONTAL_CAVER_ROLE_SYMBOL;
    private static final String RIGHT_ICON = Messages.HORIZONTAL_CAVER_ROLE_ICON_RIGHT;
    private static final String LEFT_ICON = Messages.HORIZONTAL_CAVER_ROLE_ICON_LEFT;
    private static final String HELP = Messages.HORIZONTAL_CAVER_ROLE_HELP;
    private static final String DETAILS = Messages.HORIZONTAL_CAVER_ROLE_DETAILS;

    private boolean hasCaved;

    // Constructor
    public HorizontalCaver(){
        super(NAME, DETAILS, HELP, RIGHT_ICON, SYMBOL);
        hasCaved = false;
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
            lemming.walk();
            hasCaved = false;
        }
        else{
            // Si el lemming no ha cavado, se desactiva el rol y se mueve con normalidad manteniendo la direccion que 
            // Este caso aborda el caso de si el lemming choca con un limite, entonces no excava
            lemming.disableRole();
            lemming.move();
        }
    }

    // Funcion que interactua con una pared
    @Override
    public boolean interactWith(Wall wall, Lemming lemming){
        boolean interaction = false;
        // Si el lemming choca con una pared, la destruye y cava
        if(lemming.bounceIntoWall(wall)){
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
        if(lemming.bounceIntoWall(metalWall)){
            hasCaved = false;
            interaction = true;
        }
        // Devuelve si ha habido interaccion
        return interaction;
    }

    // Funcion para comprobar si el rol es el correcto
    @Override
    public LemmingRole parse(String input){
        if (matchRoleName(input)) return new DownCaverRole();
        return null;    
    }

    // Funcion para obtener el icono del lemming segun su direccion
    @Override
	public String getIcon(Lemming lemming) {
        if(lemming.getDirection() == Direction.RIGHT) {
            return RIGHT_ICON;
        } else {
            return LEFT_ICON;
        }
    }

    // Clone
    @Override
    public LemmingRole clone(){
        return new HorizontalCaver();
    }
}
