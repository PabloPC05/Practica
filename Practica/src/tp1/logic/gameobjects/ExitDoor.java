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

        @Override
        public boolean isInPosition(Position pos) {
            return this.pos.equals(pos);
        }

        @Override
        public String toString(){
            return Messages.EXIT_DOOR;
        }
}
