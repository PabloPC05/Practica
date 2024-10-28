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
        // Constructor con parametros de posicion
        public Wall(int x, int y, Game game) {
            super(new Position(y, x), false, game);
        }

    // Setters
        // Funcion update
        public void update() {
            // No hace nada
        }

        // Funcion para obtener la representacion de la pared
        @Override
        public String toString(){
            return Messages.WALL;
        }

        // Funcion para saber si una pared es solida
        @Override
        public boolean isSolid() {
            return true;
        }

        // Funcion para saber si es un objeto es la salida
        @Override
        public boolean isExit() {
            return false;
        }
        
        // Funcion para saber si es un objeto es un lemming
        @Override
        public boolean isLemming() {
            return false;
        }


}