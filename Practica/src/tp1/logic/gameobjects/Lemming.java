package tp1.logic.gameobjects;

import tp1.logic.Game;

import tp1.logic.Position;

import org.junit.runner.OrderWith;

import tp1.logic.Direction;
import tp1.logic.lemmingRoles.LemmingRole;
//import tp1.logic.lemmingRoles.LemmingRole;
import tp1.logic.lemmingRoles.WalkerRole;


public class Lemming extends GameObject {

	//Atributos
	private Direction direction;
	private int fuerzaCaida; // Con 3 se muere
	private LemmingRole role;
	
	// Constructores
	//Constructor por defecto
	public Lemming() {
		super();
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		role = new WalkerRole();
	}
	//Constructor por defecto
	public Lemming(int col, int row, Game game) {
		super(new Position(col, row), true, game);
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		role = new WalkerRole();
	}
	
	public Lemming(int col, int row, Game game, LemmingRole role) {
		super(new Position(col, row), true, game);
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		this.role = role;
	}

	
	// Constructor con parametros de posicion (objeto) y direccion
	public Lemming(Position pos, boolean vivo, Direction d, Direction pd, Game game) {
		super(pos, vivo, game);
		direction = d;
		fuerzaCaida = 0;
		role = new WalkerRole();
	}

	//FUNCIONES ABSTRACTAS DE LA CLASE GAMEOBJECT
		// Funcion para obtener el icono del lemming
		@Override
		public String toString(){ return role.getIcon(this);}

		// Funcion para saber si un lemming es solido
		@Override
		public boolean isSolid() { return false; }

        // Funcion para saber si es un objeto es la salida
        @Override
        public boolean isExit() { return false;}
		public void update() {
			removeExitLemmings();
			if (vivo) role.play(this);
		}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion

	public void falls(){
		fuerzaCaida++;
		pos.update(Direction.DOWN);
		if(game.leavingTheBoard(pos)) {
			dies();
			game.addDeadLemmings();
		}
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
		return  game.wallAtPosition(pos.nextPosition(Direction.DOWN));
	}

	public boolean isGonnaDie(){
		return (crashingIntoWall() && tooKinectEnergy()) || game.leavingTheBoard(pos.nextPosition(Direction.DOWN));
	}
	
	public boolean tooKinectEnergy() {
		return fuerzaCaida >= 3;
	}
	
	// Mueve el lemming
	public void move() {
		if(isGonnaDie()){
			dies();
			game.addDeadLemmings();
		}
		else if(game.isInAir(pos)) falls();
		else walk();
	}

	// Getters
		//Funcion para obtener la direccion
		public Direction getDirection() {
			Direction newDirection = direction;
			return newDirection;
		}

		// Funcion para obtener el role
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

		@Override
		public boolean setRole(LemmingRole role){
			if (this.role.equals(role)) return false;
			this.role = role;
			return true;
		}
		
        public void featherFall() {
        	fuerzaCaida = 0;
        }

		public void disableRole(){
			role = new WalkerRole();
		}

		@Override
        public boolean receiveInteraction(GameItem item) {
        	return item.interactWith(this);
        }
        @Override
        public boolean interactWith(Lemming lemming) {
        	return true;
        }

		//Aquí tendríamos que escribir que ocurre cuando un lemming interactura con una pared
        @Override
        public boolean interactWith(Wall wall) {
        	return false;
        }

        @Override
        public boolean interactWith(ExitDoor door) {
        	return false;
        }
}