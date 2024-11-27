package tp1.logic.gameobjects;

import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Interfaces.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class MetalWall extends GameObject {

    private static final String NAME = Messages.METAL_WALL_NAME;
	private static final String SHORTCUT = Messages.METAL_WALL_SHORTCUT;

    // Constructores
        // Constructor con parametros de posicion (objeto)
        public MetalWall(Position pos, boolean vivo, GameWorld gameWorld) {
            super(pos, vivo, gameWorld, NAME, SHORTCUT);
        }

        // Constructor con parametros de posicion (objeto)
        public MetalWall(int col, int row, GameWorld gameWorld) {
            super(new Position(col, row), true, gameWorld, NAME, SHORTCUT);
        }

        public MetalWall(){
            super(NAME, SHORTCUT);
        }

        // Setters
        // Funcion update
        public void update() {
            // No hace nada
        }

        // Funcion para obtener la representacion de la puerta de salida
        @Override
        public String toString(){
            return Messages.METALWALL;
        }

        // Funcion para saber si una puerta es solida
        @Override
        public boolean isSolid() {
            return true;
        }

        // Funcion para interactuar con un objeto del juego
        @Override
        public boolean receiveInteraction(GameItem item) {
        	return item.interactWith(this);
        }

        @Override 
        public GameObject parse(String line, GameWorld game) throws ObjectParseException, OffBoardException{
            return null;
        }
}
