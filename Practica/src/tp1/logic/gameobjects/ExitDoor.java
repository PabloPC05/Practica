package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;
import tp1.logic.Game;

public class ExitDoor extends GameObject {

    // Constructores
        // Constructor por defecto
        public ExitDoor() {
            super();
        }

        // Constructor con parametros de posicion (objeto)
        public ExitDoor(Position pos, boolean vivo, Game game) {
            super(pos, vivo, game);
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

        // Funcion para saber si es un objeto es la salida
        @Override
        public boolean isExitDoor() {
            return true;
        }

        // Funcion para saber si es un objeto es un lemming
        @Override
        public boolean isLemming() {
            return false;
        }
}
