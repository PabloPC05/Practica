package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.WalkerRole;


public class Lemming extends GameObject {

	//Atributos
	private Direction direction;
	private Direction previousDirection;
	private int fuerzaCaida; // Con 3 se muere
	private LemmingRole rol;
	
	//Constructores
	//Constructor por defecto
	public Lemming() {
		super();
		direction = Direction.RIGHT;
		previousDirection = Direction.NONE;
		fuerzaCaida = 0;
		rol = new WalkerRole();
	}
	//Constructor por defecto
	public Lemming(int x, int y, Game game) {
		super(new Position(y, x), true, game);
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
	        if (!game.isFalling(pos)) {
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
	        else if(!game.isInsideLimits(pos.PositionWDir(Direction.DOWN))) {
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
			// Buscamos el objeto en la posicion a la que se va a mover
			int indiceAux = game.gameObjects.objectAt(pos.PositionWDir(direction));
			// Si se sale de los limites o el objeto es solido, se cambia la direccion
	        if (!game.isInsideLimits(pos.PositionWDir(direction)) || (indiceAux != -1 && game.gameObjects.get(indiceAux).isSolid())) {
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
	            if (game.isFalling(pos)) {
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

		// Funcion para obtener el icono del lemming
		@Override
		public String toString(){
			return rol.getIcon(this);
		}

		// Funcion para saber si un lemming es solido
		@Override
		public boolean isSolid() {
			return false;
		}

        // Funcion para saber si es un objeto es la salida
        @Override
        public boolean isExit() {
            return false;
        }

        // Funcion para saber si es un objeto es un lemming
        @Override
        public boolean isLemming() {
            return true;
        }

		private boolean dies() {
			if(fuerzaCaida >= 3){
				vivo = false;
				return true;
			}
			return false;
		}

		@Override
		public boolean interactWith(Wall wall){
	    	// Si la direccion es hacia abajo
	    	if (direction == Direction.DOWN) {
	        	// Si hay una pared abajo
	        	if (!game.isFalling(pos)) {
	            	// Si la fuerza de caida es mayor o igual a 3, muere
	            	if (!dies()){
	                	fuerzaCaida = 0;
	                	direction = previousDirection; // Asigna directamente la dirección anterior
	            	}
	        	}
			}
			else if(direction == Direction.RIGHT || direction == Direction.LEFT){

			}
		return false;
	}

}