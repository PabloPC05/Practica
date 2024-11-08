package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.view.Messages;
import tp1.logic.Interfaces.GameWorld;

public class Wall extends GameObject {

    // Constructores

        // Constructor con parametros de posicion
        public Wall(Position pos, boolean vivo, GameWorld gameWorld) {
            super(pos, vivo, gameWorld);
        }

        // Constructor con parametros de posicion
        public Wall(int col, int row, GameWorld gameWorld) {
            super(new Position(col, row), true, gameWorld);
        }

    // Setters
        // Funcion update
        public void update() {
            // No hace nada
        }

        // Funcion para obtener la representacion de la pared
        @Override
        public String toString(){
            return Messages.WALL;
        }

        // Funcion para saber si una pared es solida
        @Override
        public boolean isSolid() {
            return true;
        }

        
        @Override
        public boolean setRole(LemmingRole role) {
        	return false;
        }

        @Override
        public boolean receiveInteraction(GameItem item) {
        	return item.interactWith(this);
        }

}