package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;
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

        // Constructor con parametros de posicion (objeto)
        public ExitDoor(int col, int row, Game game) {
            super(new Position(col, row), true, game);
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
        public boolean isExit() {
            return true;
        }
        
        @Override
        public boolean setRole(LemmingRole role) {
        	return false;
        }
}
