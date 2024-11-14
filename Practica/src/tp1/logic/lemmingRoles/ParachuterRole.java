package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class ParachuterRole extends AbstractRole implements LemmingRole {

    private static final String NAME = Messages.PARACHUTER_ROLE_NAME;
    private static final String SYMBOL = Messages.PARACHUTER_ROLE_SYMBOL;
    private static final String ICON = Messages.LEMMING_PARACHUTE;
    private static final String HELP = Messages.PARACHUTER_ROLE_HELP;
    private static final String DETAILS = Messages.PARACHUTER_ROLE_DETAILS;
    
    public ParachuterRole() {
        super(NAME, DETAILS, HELP, ICON, SYMBOL);
    }
    
    
    @Override
    public void start(Lemming lemming) {
        // Supongo que habria que comprobar antes de que se establezca el rol que no haya una pared debajo, 
        // i.e que esté en el aire el lemming
    	// lemming.featherFall();
    }

    // Funcion play de parachuter
    @Override
    public void play(Lemming lemming) {
    	// Si no interactua con nada, cae
        if(!lemming.interactWithEverything()){ 
            lemming.falls();
        }
        // Cuando interactua, en particular con una pared o una pared de metal
        // se pone la fuerza de caida a 0
        else {
        	lemming.featherFall();
        }
    }

    @Override 
    public LemmingRole parse(String input) {
        if (roleMatch(input)) return new ParachuterRole();
        return null;
    }


    @Override
    public boolean interactWith(Wall wall, Lemming lemming) {
        boolean interaction = false; 
        if(lemming.crashingIntoWall(wall)) {
            lemming.disableRole();
            interaction = true;
        }
        return interaction;
    }
    
    @Override
    public boolean interactWith(MetalWall wall, Lemming lemming) {
        boolean interaction = false; 
        if(lemming.crashingIntoWall(wall)) {
            lemming.disableRole();
            interaction = true;
        }
        return interaction;
    }
}
