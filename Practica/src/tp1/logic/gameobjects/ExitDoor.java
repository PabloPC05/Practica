package tp1.logic.gameobjects;

import tp1.logic.Interfaces.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor extends GameObject {

    // Constructores
        // Constructor con parametros de posicion (objeto)
        public ExitDoor(Position pos, boolean vivo, GameWorld gameWorld) {
            super(pos, vivo, gameWorld);
        }

        // Constructor con parametros de posicion (objeto)
        public ExitDoor(int col, int row, GameWorld gameWorld) {
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
            return Messages.EXIT_DOOR;
        }

        // Funcion para saber si una puerta es solida
        @Override
        public boolean isSolid() {
            return false;
        }

        // Funcion para interactuar con un objeto del juego
        @Override
        public boolean receiveInteraction(GameItem item) {
        	return item.interactWith(this);
        }
}
