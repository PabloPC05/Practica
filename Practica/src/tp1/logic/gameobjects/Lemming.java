package tp1.logic.gameobjects;
import tp1.logic.Interfaces.GameWorld;
import tp1.logic.Direction;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.*;


public class Lemming extends GameObject{

	//Atributos
	private Direction direction;
	private int fuerzaCaida; // Con 3 se muere
	private LemmingRole role;
	
	// Constructores
	//Constructor por defecto
	public Lemming(int col, int row, GameWorld GameWorld) {
		super(new Position(col, row), true, GameWorld);
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		role = new WalkerRole();
	}
	
	public Lemming(int col, int row, GameWorld GameWorld, LemmingRole role) {
		super(new Position(col, row), true, GameWorld);
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		this.role = role;
	}


	//FUNCIONES ABSTRACTAS DE LA CLASE GameWorldOBJECT
		// Funcion para obtener el icono del lemming
		@Override
		public String toString(){ 
			return role.getIcon(this);
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
		public void update() {
			if(vivo) role.play(this);
		}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion

	public void falls(){
		fuerzaCaida++;
		pos.update(Direction.DOWN);
		if(gameWorld.leavingTheBoard(pos)) {
			dies();
			gameWorld.addDeadLemmings();
		}
	}

	public void inverseDirection(){
		if (direction == Direction.RIGHT) {
			direction = Direction.LEFT;
		} else {
			direction = Direction.RIGHT;
		}
	}

	public boolean crashingIntoLimits(){
		return pos.nextPosition(direction).crashingIntoLimits();
	}

	// Funcion para realizar lo que ocurriria si el lemming se mueve en el eje x
	public void walk(){
		//if(gameWorld.wallAtPosition(pos.nextPosition(direction)) || crashingIntoLimits()) inverseDirection();
		pos.update(direction);
	}

	public boolean crashingIntoWall(){
		return  gameWorld.wallAtPosition(pos.nextPosition(Direction.DOWN));
	}

	public boolean crashingIntoWall(Wall wall){
		return wall.isInPosition(pos.nextPosition(Direction.DOWN));
	}

	public boolean bounceIntoWall(Wall wall){
		return wall.isInPosition(pos.nextPosition(direction));
	}

	public boolean fallOutOfTheWorld(){
		return gameWorld.leavingTheBoard(pos.nextPosition(Direction.DOWN));
	}
	
	public boolean tooKinectEnergy() {
		return fuerzaCaida >= 3;
	}

	public void addDeadLemmings(){
		gameWorld.addDeadLemmings();
	}
	
	// Mueve el lemming si es andante
	public void move() {
		if(crashingIntoLimits()) inverseDirection();
		else if (fallOutOfTheWorld()) {
			dies();
			addDeadLemmings();
		}
		else if(gameWorld.isInAir(pos)) falls();
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

		public void addExitLemmings(){
			gameWorld.addExitLemmings();
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

		//Aquí tendríamos que escribir que ocurre cuando un lemming interactura con una pared
        @Override
        public boolean interactWith(Wall wall) {
        	return role.interactWith(wall, this);
        }

		public boolean interactWithEverything() {
			return gameWorld.receiveInteractionsFrom(this);
		}

		@Override
		public boolean interactWith(ExitDoor exit){
			boolean interaction = false; 
			//Si el lemming andante llega a la puerta de salida, se va y se añade una unidad al numero de lemming que han salido
			if(isInPosition(exit)){
				dies();
				addExitLemmings();
				interaction = true;
			}
			return interaction;
		}
}