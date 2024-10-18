<<<<<<< HEAD
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
        public ExitDoor(int c, int r, Game game) {
            super(new Position(c, r), game);
        }

    // Setters
        // Funcion update
        public void update() {
            // No hace nada
        }
}
=======
package tp1.logic.gameobjects;

import tp1.logic.Position;

public class ExitDoor {

	 // Atributos
    private Position pos;

    // Constructores
        // Constructor por defecto
        public ExitDoor() {
            pos = new Position();
        }

        // Constructor con parametros de posicion (objeto)
        public ExitDoor(Position pos) {
            this.pos = pos;
        }

    // Setters
    // Funcion para establecer la posicion de la puerta
    public void setPos(Position pos) {
        this.pos = pos;
    }

    // Getters
    // Funcion para obtener la posicion de la puerta
    public Position getPos() {
        return new Position(pos.getCol(), pos.getRow());
    }

}
>>>>>>> 9d560ad3000b5e0fb3e69c9e24aa2c08415a1c9d
