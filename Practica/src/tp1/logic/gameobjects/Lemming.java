package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.WalkerRole;


public class Lemming extends GameObject {

	//Atributos
	private Direction direction;
	private Direction previousDirection;
	private int fuerzaCaida; // Con 3 se muere
	private WalkerRole rol;
	
	//Constructores
	//Constructor por defecto
	public Lemming() {
		super();
		direction = Direction.RIGHT;
		previousDirection = Direction.NONE;
		fuerzaCaida = 0;
		rol = new WalkerRole();
	}

	// Constructor con parametros de posicion (objeto) y direccion
	public Lemming(Position pos, boolean vivo, Direction d, Direction pd, Game game) {
		super(pos, vivo, game);
		direction = d;
		previousDirection = pd;
		fuerzaCaida = 0;
		rol = new WalkerRole();
	}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion
	public void update() {
		if (vivo) {
			rol.play(this);
		}
	}
	
	// Mueve el lemming
	public void move() {
	    // Si la direccion es hacia abajo
	    if (direction == Direction.DOWN) {
	        // Si hay una pared abajo
	        if (game.gameObjects.wallAt(pos.PositionWDir(direction)) != -1) {
	            // Si la fuerza de caida es mayor o igual a 3, muere
	            if (fuerzaCaida >= 3) {
	                vivo = false;
	            // Si no, se reinicia la fuerza de caida
	            } else {
	                fuerzaCaida = 0;
	                direction = previousDirection; // Asigna directamente la dirección anterior
	            }
	        }
	        // Si la posicion es mayor o igual a la altura del juego, muere
	        else if(pos.PositionWDir(direction).getRow() >= Game.DIM_Y) {
	            vivo = false;
	        }
	        // Si no hay una pared abajo, aumenta la fuerza de caida y se actualiza la posicion con la direccion
	        else {
	            fuerzaCaida++;
	            pos.update(direction);
	        }
	    }
	    // Si esta yendo a la derecha o izquierda
	    else if (direction == Direction.RIGHT || direction == Direction.LEFT) {
	        // Si hay una pared en la siguiente posicion, se cambia la direccion a la simetrica y se guarda la anterior
	        if (pos.PositionWDir(direction).getCol() < 0 || pos.PositionWDir(direction).getCol() >= Game.DIM_X || game.gameObjects.wallAt(pos.PositionWDir(direction)) != -1) {
	            previousDirection = direction; // Asigna directamente la dirección actual
	            if (direction == Direction.RIGHT) {
	                direction = Direction.LEFT;
	            } else {
	                direction = Direction.RIGHT;
	            }
	        // Si no hay una pared a la izquierda o derecha, se actualiza la posicion con la direccion
	        } else {
	            // Se actualiza la posicion con la direccion
	            pos.update(direction);
	            // Si no hay una pared abajo, se cambia la direccion a DOWN y se guarda la anterior
	            if (game.gameObjects.wallAt(pos.PositionWDir(Direction.DOWN)) == -1) {
	                previousDirection = direction; // Asigna directamente la dirección actual
	                direction = Direction.DOWN;
	            }
	        }
	    }
	}

	// Getters
		//Funcion para obtener la direccion
		public Direction getDirection() {
			Direction newDirection = direction;
			return newDirection;
		}

		// Funcion para obtener el rol
		public WalkerRole getRol() {
			return new WalkerRole();
		}

		// Funcion para obtener la direccion previa al movimiento
		public Direction getPreviousDirection() {
			Direction newDirection = previousDirection;
			return newDirection;
		}
}