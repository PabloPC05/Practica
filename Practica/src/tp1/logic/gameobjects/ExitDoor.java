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
