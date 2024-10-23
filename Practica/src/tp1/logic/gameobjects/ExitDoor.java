package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.Game;

public class ExitDoor extends GameObject {

    // Constructores
        // Constructor por defecto
        public ExitDoor() {
            super();
        }

        // Constructor con parametros de posicion (objeto)
        public ExitDoor(int c, int r, boolean vivo, Game game) {
            super(new Position(c, r), vivo, game);
        }

    // Setters
        // Funcion update
        public void update() {
            // No hace nada
        }
}
