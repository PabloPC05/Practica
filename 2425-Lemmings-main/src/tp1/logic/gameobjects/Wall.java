package tp1.logic.gameobjects;

import tp1.logic.Position;

public class Wall {
    
    // Atributos
    private Position pos;

    // Constructores
    // Constructor por defecto
    public Wall() {
        this.pos = new Position();
    }

    // Constructor con parametros de posicion
    public Wall(int c, int r) {
        this.pos = new Position(c, r);
    }

    // Constructor con parametros de posicion (objeto)
    public Wall(Position pos) {
        this.pos = pos;
    }

    // Setters
    // Funcion para establecer la posicion de la pared
    public void setPos(Position pos) {
        this.pos = pos;
    }

    // Funcion update
    public void update(){

    }

    // Getters
    // Funcion para obtener la posicion de la pared
    public Position getPos() {
        return pos;
    }

    // Funcion para obtener la columna de la pared
    public int getCol() {
        return pos.getCol();
    }

    // Funcion para obtener la fila de la pared
    public int getRow() {
        return pos.getRow();
    }

}
