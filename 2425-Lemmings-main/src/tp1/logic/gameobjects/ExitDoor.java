package tp1.logic.gameobjects;

import tp1.logic.Position;

public class ExitDoor {

	 // Atributos
    private Position pos;

    // Constructores
    // Constructor por defecto
    public ExitDoor() {
        this.pos = new Position();
    }

    // Constructor con parametros de posicion
    public ExitDoor(int c, int r) {
        this.pos = new Position(c, r);
    }

    // Setters
    // Funcion para establecer la posicion de la puerta
    public void setPos(Position pos) {
        this.pos = pos;
    }

    // Getters
    // Funcion para obtener la posicion de la puerta
    public Position getPos() {
        return pos;
    }

    // Funcion para obtener la columna de la puerta
    public int getCol() {
        return pos.getCol();
    }

    // Funcion para obtener la fila de la puerta
    public int getRow() {
        return pos.getRow();
    }
	
}
