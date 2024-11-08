package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class DownCaverRole extends AbstractRole implements LemmingRole{

    private static final String NAME = Messages.DOWN_CAVER_ROLE_NAME;
    private static final String SYMBOL = Messages.DOWN_CAVER_ROLE_SYMBOL;
    private static final String ICON = Messages.LEMMING_DOWN_CAVER;
    private static final String HELP = Messages.DOWN_CAVER_ROLE_HELP;
    private static final String DETAILS = Messages.DOWN_CAVER_ROLE_DETAILS;

    private boolean hasCaved;

    public DownCaverRole(){
        super(NAME, DETAILS, HELP, ICON, SYMBOL);
        hasCaved = false;
    }


    public void start(Lemming lemming){
    }

    public void play (Lemming lemming){
        lemming.interactWithEverything();
        if(hasCaved){ 
            lemming.falls();
            lemming.featherFall();
            hasCaved = false;
        }
        else{
            // Si el lemming no ha cavado, se desactiva el rol y se mueve con normalidad manteniendo la direccion que tenia
            lemming.disableRole();
            lemming.move();
        }
    }

    @Override
    public boolean interactWith(Wall wall, Lemming lemming){
        boolean interaction = false;
        if(lemming.crashingIntoWall(wall)){
            wall.dies();
            hasCaved = true;
            interaction = true;
        }
        return interaction;
    }

    @Override
    public boolean interactWith(MetalWall metalWall, Lemming lemming){
        boolean interaction = false;
        if(lemming.crashingIntoWall(metalWall)){
            hasCaved = true;
            interaction = true;
        }
        return interaction;
    }

    public LemmingRole parse(String input){
        if (matchRoleName(input)) return new DownCaverRole();
        return null;    
    }
}
