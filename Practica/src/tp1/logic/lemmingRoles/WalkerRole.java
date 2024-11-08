package tp1.logic.lemmingRoles;

import tp1.logic.*;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class WalkerRole extends AbstractRole implements LemmingRole {

    private static final String NAME = Messages.WALKER_ROLE_NAME;
    private static final String SYMBOL = Messages.WALKER_ROLE_SYMBOL;
    private static final String RIGHT_ICON = Messages.LEMMING_RIGHT;
    private static final String LEFT_ICON = Messages.LEMMING_LEFT;
    private static final String HELP = Messages.WALKER_ROLE_HELP;
    private static final String DETAILS = Messages.WALKER_ROLE_DETAILS;

    public WalkerRole() {
        super(NAME, DETAILS, HELP, RIGHT_ICON, SYMBOL);
    }

    @Override
	public void play(Lemming lemming) {
        //Si no interactua con nada, se mueve con normalidad
        if(!lemming.interactWithEverything()){ 
            lemming.move();
        }
	}

    @Override
	public String getIcon(Lemming lemming) {
        if(lemming.getDirection() == Direction.RIGHT) {
            return RIGHT_ICON;
        } else {
            return LEFT_ICON;
        }
    }

    @Override
    public void start(Lemming lemming) {

    }

    @Override
    public LemmingRole parse(String input) {
        if (roleMatch(input)) return new WalkerRole();
        return null;
    }

    @Override
    public boolean interactWith(Wall wall, Lemming lemming) {
        boolean interaction = false;
        //Si el lemming andante choca con una pared o con los limites laterales del eje de abscisas, rebota
        if(lemming.bounceIntoWall(wall)){
            lemming.inverseDirection();
            interaction = true;
        }
        //Si el lemming andante choca con una pared con la suficiente energia cinetica, se muere
        else if((lemming.crashingIntoWall(wall) && lemming.tooKinectEnergy())){
            lemming.dies();
            lemming.addDeadLemmings();
            interaction = true;
        }
        return interaction;
    }
}


