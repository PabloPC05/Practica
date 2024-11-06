package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.Direction;
import tp1.logic.lemmingRoles.LemmingRole;
//import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.WalkerRole;


public class Lemming extends GameObject {

	//Atributos
	private Direction direction;
	private int fuerzaCaida; // Con 3 se muere
	private LemmingRole rol;
	
	//Constructores
	//Constructor por defecto
	public Lemming() {
		super();
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		rol = new WalkerRole();
	}
	//Constructor por defecto
	public Lemming(int col, int row, Game game) {
		super(new Position(col, row), true, game);
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
			removeExitLemmings();
			if (vivo) rol.play(this);
		}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion


	public void isFalling(){
		fuerzaCaida++;
		pos.update(Direction.DOWN);
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
		if(game.wallAtPosition(pos.nextPosition(direction)) || game.crashingIntoLimits(pos.nextPosition(direction))) inverseDirection();
		pos.update(direction);
	}

	public boolean crashingIntoWall(){
		return fuerzaCaida >= 3 && game.wallAtPosition(pos.nextPosition(Direction.DOWN));
	}

	public boolean isGonnaDie(){
		return crashingIntoWall() || game.leavingTheBoard(pos.nextPosition(Direction.DOWN));
	}
	
	// Mueve el lemming
	public void move() {
		if(isGonnaDie()){
			dies();
			game.addDeadLemmings();
		}
		else if(game.isInAir(pos)) isFalling();
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
				dies();
			}
		}

		public void setRole(LemmingRole role){
			rol = role;
		}

		public void disableRole(){
			
		}
}