package tp1.logic.lemmingRoles;

import tp1.logic.gameobjects.Lemming;

public interface LemmingRole {
    public void start(Lemming lemming);
    public void play (Lemming lemming);
    public String getIcon(Lemming lemming);
    //Aqui estaba puesto static en lugar de abstract pero hemos tenido 
    //que cambiarlo para hacerlo similar a CommandGenerator, esta bien?
    abstract public LemmingRole parse(String input);
    abstract public boolean roleMatch(String input);
    abstract public String helpText();
    abstract public String getSymbol();

    abstract boolean matchRoleName(String name);
}
