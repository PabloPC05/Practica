package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.view.Messages;
import tp1.logic.Interfaces.GameWorld;

public class MetalWall extends GameObject {

    // Constructores
        // Constructor con parametros de posicion (objeto)
        public MetalWall(Position pos, boolean vivo, GameWorld gameWorld) {
            super(pos, vivo, gameWorld);
        }

        // Constructor con parametros de posicion (objeto)
        public MetalWall(int col, int row, GameWorld gameWorld) {
            super(new Position(col, row), true, gameWorld);
        }

        // Setters
        // Funcion update
        public void update() {
            // No hace nada
        }

        // Funcion para obtener la representacion de la puerta de salida
        @Override
        public String toString(){
            return Messages.METALWALL;
        }

        // Funcion para saber si una puerta es solida
        @Override
        public boolean isSolid() {
            return true;
        }

        // Funcion para interactuar con un objeto del juego
        @Override
        public boolean receiveInteraction(GameItem item) {
        	return item.interactWith(this);
        }
}
