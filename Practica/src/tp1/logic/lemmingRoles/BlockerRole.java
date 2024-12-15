package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class BlockerRole extends AbstractRole implements LemmingRole {

    // Atributos
    private static final String NAME = Messages.BLOCKER_ROLE_NAME;
    private static final String SYMBOL = Messages.BLOCKER_ROLE_SYMBOL;
    private static final String ICON = Messages.LEMMING_BLOCKER;
    private static final String HELP = Messages.BLOCKER_ROLE_HELP;
    private static final String DETAILS = Messages.BLOCKER_ROLE_DETAILS;
    
    // Constructor
    public BlockerRole() {
        super(NAME, DETAILS, HELP, ICON, SYMBOL);
    }
    
    // Metodos
    // Funcion start de blocker (no hace nada)
    @Override
    public void start(Lemming lemming) {
        lemming.paralize();
    }

    // Funcion play de blocker
    @Override
    public void play(Lemming lemming) {
    }

    // Funcion para comprobar si el rol es el correcto
    @Override 
    public LemmingRole parse(String input) {
        if (roleMatch(input)) return new BlockerRole();
        return null;
    }

    @Override
    public boolean isSolid(){
        return true;
    }

}
