package tp1.logic.gameobjects;

import tp1.logic.Position;

public class Wall {
    
    // Atributos
    private Position pos;

    // Constructores
        // Constructor por defecto
        public Wall() {
            pos = new Position();
        }

        // Constructor con parametros de posicion
        public Wall(int c, int r) {
            pos = new Position(c, r);
        }

    // Getters
        // Funcion para obtener la posicion de la pared
        public Position getPos() {
            return new Position(pos.getCol(), pos.getRow());
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
