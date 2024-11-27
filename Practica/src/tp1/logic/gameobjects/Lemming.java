package tp1.logic.gameobjects;
import tp1.logic.Direction;
import tp1.logic.Interfaces.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.*;


public class Lemming extends GameObject{

	//Atributos
	private Direction direction;
	private int fuerzaCaida; // Con 3 se muere
	private LemmingRole role;
	private boolean isInAir = false;
	
	// Constructores
	//Constructor por defecto
	public Lemming(int col, int row, GameWorld GameWorld) {
		super(new Position(col, row), true, GameWorld);
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		role = new WalkerRole();
		isInAir = false;
	}
	
	//Constructor con parametros
	public Lemming(int col, int row, GameWorld GameWorld, LemmingRole role) {
		super(new Position(col, row), true, GameWorld);
		direction = Direction.RIGHT;
		fuerzaCaida = 0;
		this.role = role;
		isInAir = false;
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
		
		// Funcion para actualizar el lemming
		public void update() {
			if(vivo){ 
				isInAir = gameWorld.isInAir(pos);
				role.play(this);
			}
		}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion

	// Funcion para que un Lemming caiga y muera si se cae de la pantalla
	public void falls(){
		fuerzaCaida++;
		pos.update(Direction.DOWN);
		if(gameWorld.leavingTheBoard(pos)) {
			dies();
			gameWorld.addDeadLemmings();
		}
	}

	// Funcion para cambiar la direccion del lemming
	public void inverseDirection(){
		if (direction == Direction.RIGHT) {
			direction = Direction.LEFT;
		} else {
			direction = Direction.RIGHT;
		}
	}

	// Funcion para saber si un lemming se sale de los limites
	public boolean crashingIntoLimits(){
		return pos.nextPosition(direction).crashingIntoLimits();
	}

	// Funcion para realizar lo que ocurriria si el lemming se mueve en el eje x
	public void walk(){
		//if(gameWorld.wallAtPosition(pos.nextPosition(direction)) || crashingIntoLimits()) inverseDirection();
		pos.update(direction);
	}

	// Funcion para saber si se choca con una pared hacia abajo
	public boolean crashingIntoWall(Wall wall){
		return wall.isInPosition(pos.nextPosition(Direction.DOWN));
	}

	// Funcion para saber si se choca con una pared de metal hacia abajo
	public boolean crashingIntoWall(MetalWall wall){
		return wall.isInPosition(pos.nextPosition(Direction.DOWN));
	}

	// Funcion para saber si se choca con una pared
	public boolean bounceIntoWall(Wall wall){
		return wall.isInPosition(pos.nextPosition(direction));
	}
	
	// Funcion para saber si se choca con una pared de metal
	public boolean bounceIntoWall(MetalWall wall){
		return wall.isInPosition(pos.nextPosition(direction));
	}

	// Funcion para saber si un lemming se saldra de la pantalla
	public boolean fallOutOfTheWorld(){
		return gameWorld.leavingTheBoard(pos.nextPosition(Direction.DOWN));
	}
	
	// Funcion para saber si un lemming ha caido demasiado (3 o mas)
	public boolean tooKinectEnergy() {
		return fuerzaCaida >= 3;
	}

	// Funcion que aumenta el numero de lemmings muertos
	public void addDeadLemmings(){
		gameWorld.addDeadLemmings();
	}

	// Funcion que devuelve si un Lemming esta en el aire
	public boolean isInAir(){
		return isInAir;
	}
	
	// Mueve el lemming si es andante
	public void move() {
		if(isInAir()) falls();
		else if (fallOutOfTheWorld()) {
			dies();
			addDeadLemmings();
		}
		else if(crashingIntoLimits()) inverseDirection();
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

		// Funcion para aumentar el numero de lemmings que han salido
		public void addExitLemmings(){
			gameWorld.addExitLemmings();
		}

		// Funcion para setear el role de un lemming (devuelve si se ha podido cambiar)
		@Override
		public boolean setRole(LemmingRole role, String roleName) {
			if (this.role.matchRoleName(roleName)) return false;
			this.role = role;
			return true;
		}
		
		// Funcion para resetear la fuerza de caida
        public void featherFall() {
        	fuerzaCaida = 0;
        }

		// Funcion para desactivar el role de un lemming (walkerRole)
		public void disableRole(){
			role = new WalkerRole();
			//role.play(this);
		}

		// Funcion para recibir interacciones de un item del juego
		@Override
        public boolean receiveInteraction(GameItem item) {
        	return item.interactWith(this);
        }

		// Funcion para interactuar con una pared
        @Override
        public boolean interactWith(Wall wall) {
        	return role.interactWith(wall, this);
        }

		// Funcion para interactuar con una pared de metal
		@Override
        public boolean interactWith(MetalWall metalWall) {
        	return role.interactWith(metalWall, this);
        }

		// Funcion para interactuar con cualquier cosa
		public boolean interactWithEverything() {
			return gameWorld.receiveInteractionsFrom(this);
		}

		// Funcion para interactuar con la puerta de salida
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