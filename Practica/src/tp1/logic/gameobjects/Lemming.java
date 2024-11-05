package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.Direction;
//import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.WalkerRole;


public class Lemming extends GameObject {

	//Atributos
	private Direction direction;
	private int fuerzaCaida; // Con 3 se muere
	private WalkerRole rol;
	
	//Constructores
	//Constructor por defecto
	public Lemming() {
		super();
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		rol = new WalkerRole();
	}
	//Constructor por defecto
	public Lemming(int x, int y, Game game) {
		super(new Position(x, y), true, game);
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		rol = new WalkerRole();
	}

	// Constructor con parametros de posicion (objeto) y direccion
	public Lemming(Position pos, boolean vivo, Direction d, Direction pd, Game game) {
		super(pos, vivo, game);
		direction = d;
		fuerzaCaida = 0;
		rol = new WalkerRole();
	}

	//FUNCIONES ABSTRACTAS DE LA CLASE GAMEOBJECT
		// Funcion para obtener el icono del lemming
		@Override
		public String toString(){ return rol.getIcon(this);}

		// Funcion para saber si un lemming es solido
		@Override
		public boolean isSolid() { return false; }

        // Funcion para saber si es un objeto es la salida
        @Override
        public boolean isExit() { return false;}
		public void update() {
			if (vivo) rol.play(this);
			removeExitLemmings();
		}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion


	public void isFalling(){
		fuerzaCaida++;
		pos.update(direction);
	}

	public boolean isInsideLimits(){
		return game.isInsideLimits(pos.nextPosition(direction));
	}

	public void inverseDirection(){
		if (direction == Direction.RIGHT) {
			direction = Direction.LEFT;
		} else {
			direction = Direction.RIGHT;
		}
	}

	// Funcion para realizar lo que ocurriria si el lemming se mueve en el eje x
	public void walk(){
		if(game.isWall(pos.nextPosition(direction))) inverseDirection();
		else pos.update(direction);
	}

	public boolean isGonnaDie(){
		return fuerzaCaida >= 3 || !game.isInsideLimits(pos.nextPosition(direction));
	}
	
	// Mueve el lemming
	public void move() {
		if(game.isInAir(pos)) isFalling();
		else if(isGonnaDie()) dies();
		else walk();
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

		// Funcion para saber si un lemming esta en una posicion de salida
		public boolean lemmingIsInExit(){
			return game.isExit(pos);
		}

		public void removeExitLemmings(){
			if(lemmingIsInExit()){
				game.addExitLemmings();
			}
		}


		/*if (direction == Direction.DOWN) {
	        // Si hay una pared abajo
	        if (!game.isFalling(pos)) {
	            // Si la fuerza de caida es mayor o igual a 3, muere
	            if (fuerzaCaida >= 3) {
	                vivo = false;
	            // Si no, se reinicia la fuerza de caida
	            } else {
	                fuerzaCaida = 0;
	            }
	        }
	        // Si la posicion es mayor o igual a la altura del juego, muere
	        else if(!game.isInsideLimits(pos.nextPosition(Direction.DOWN))) {
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
			int indiceAux = game.gameObjects.objectAt(pos.nextPosition(direction));
			// Si se sale de los limites o el objeto es solido, se cambia la direccion
	        if (!game.isInsideLimits(pos.nextPosition(direction)) || (indiceAux != -1 && game.gameObjects.get(indiceAux).isSolid())) {
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
	                direction = Direction.DOWN;
	            }
	        }
	    }*/
}