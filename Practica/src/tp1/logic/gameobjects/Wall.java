package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;
import tp1.logic.Game;

public class Wall extends GameObject {

    // Constructores
        // Constructor por defecto
        public Wall() {
            super();
        }

        // Constructor con parametros de posicion
        public Wall(Position pos, boolean vivo, Game game) {
            super(pos, vivo, game);
        }

    // Setters
        // Funcion update
        public void update() {
            // No hace nada
        }

        @Override
        public boolean isInPosition(Position pos) {
            return this.pos.equals(pos);
        }

        @Override
        public String toString(){
            return Messages.WALL;
        }

}
