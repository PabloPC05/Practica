package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.logic.Game;

public class Wall extends GameObject {

    // Constructores
        // Constructor por defecto
        public Wall() {
            super();
        }

        // Constructor con parametros de posicion
        public Wall(int c, int r, Game game) {
            super(new Position(c, r), game);
        }

    // Setters
        // Funcion update
        public void update() {
            // No hace nada
        }

}
