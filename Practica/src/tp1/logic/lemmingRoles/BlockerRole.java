package tp1.logic.lemmingRoles;

import java.util.ArrayList;
import tp1.exceptions.ObjectParseException;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class BlockerRole extends AbstractRole implements LemmingRole {

    // Atributos
    private static final String NAME = Messages.BLOCKER_ROLE_NAME;
    private static final String SYMBOL = Messages.BLOCKER_ROLE_SYMBOL;
    private static final String ICON = Messages.LEMMING_BLOCKER;
    private static final String HELP = Messages.BLOCKER_ROLE_HELP;
    private static final String DETAILS = Messages.BLOCKER_ROLE_DETAILS;
    private static final int PARALYZED_TIME = 3;

    int timeParalized;

    
    // Constructor
    public BlockerRole() {
        super(NAME, DETAILS, HELP, ICON, SYMBOL);
        timeParalized = PARALYZED_TIME;
    }

    public BlockerRole(int tP) {
        super(NAME, DETAILS, HELP, ICON, SYMBOL);
        timeParalized = tP+1;
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
        if(decreaseParalization()) lemming.disableRole();
    }

    private boolean decreaseParalization(){
        timeParalized--;
        return timeParalized <= 0;
    }

    // Funcion para comprobar si el rol es el correcto
    @Override 
    public LemmingRole parse(String input) {
        if (roleMatch(input)) return new BlockerRole();
        return null;
    }

    @Override
    public ArrayList<String> parseInfo(ArrayList<String> input) throws ObjectParseException{
        ArrayList <String> returnValue = new ArrayList<>(input);
        if(input.size() == 1){
            try {
                timeParalized = Integer.parseInt(input.get(0));
                timeParalized++;
            } catch (NumberFormatException e) {
                throw new ObjectParseException();
            }
        }
        return returnValue;
    }
}
