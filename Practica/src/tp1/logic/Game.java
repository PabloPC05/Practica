package tp1.logic;
import tp1.logic.Interfaces.GameModel;
import tp1.logic.Interfaces.GameStatus;
import tp1.logic.Interfaces.GameWorld;
import tp1.logic.gameobjects.*;
import tp1.logic.lemmingRoles.*;


public class Game implements GameModel, GameStatus, GameWorld {

	private static final int LEMMINGS_TO_WIN = 2;
	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;
	public static final int MIN_LEVEL = 0;
	public static final int MAX_LEVEL = 3;


	public GameObjectContainer gameObjects;
	private int level;
	private int cycle;
	private int lemmingsToWin;
	private boolean exit;
	private int numLemmings;
	private int	deadLemmings;
	private int exitLemmings;
	

	// Constructores
	// Constructor por defecto
	public Game() {


		gameObjects = new GameObjectContainer();
		//initObjects();
		level = 0;
		initBoard(0);
		cycle = 0;
		lemmingsToWin = LEMMINGS_TO_WIN;
		exit = false;
		numLemmings = 0;
		deadLemmings = 0;
		exitLemmings = 0;
	}

	// Constructor con parametros de nivel
	public Game(int nivel) {
		gameObjects = new GameObjectContainer();
		//initObjects();
		level = nivel;
		initBoard(nivel);
		cycle = 0;
		lemmingsToWin = LEMMINGS_TO_WIN;
		exit = false;
		deadLemmings = 0;
		exitLemmings = 0;
	}

	// Funcion para inicializar los objetos del juego dependiendo del nivel
	public void InitLevel(int level) {

		switch (level) {
			// Nivel 1
			case 0:
				this.level = 0;
				// initWalls();
				gameObjects.add(new Wall(8, 1, this));
				gameObjects.add(new Wall(9, 1, this));


				gameObjects.add(new Wall(2, 4, this));
				gameObjects.add(new Wall(3, 4, this));
				gameObjects.add(new Wall(4, 4, this));

				gameObjects.add(new Wall(7, 5, this));

				gameObjects.add(new Wall(4, 6, this));
				gameObjects.add(new Wall(5, 6, this));
				gameObjects.add(new Wall(6, 6, this));
				gameObjects.add(new Wall(7, 6, this));

				gameObjects.add(new Wall(0, 9, this));
				gameObjects.add(new Wall(1, 9, this));

				gameObjects.add(new Wall(9, 9, this));
				gameObjects.add(new Wall(8, 9, this));
				gameObjects.add(new Wall(8, 8, this));

				//InitLemmings();
				gameObjects.add(new Lemming(0, 8, this));
				gameObjects.add(new Lemming(2, 3, this));
				gameObjects.add(new Lemming(9, 0, this));
				
				//InitExitDoor();
				gameObjects.add(new ExitDoor(4, 5, this));
				
				numLemmings = 3;
				break;

			// Nivel 2
			case 1:
				this.level = 1;
				// initWalls();
				gameObjects.add(new Wall(8, 1, this));
				gameObjects.add(new Wall(9, 1, this));


				gameObjects.add(new Wall(2, 4, this));
				gameObjects.add(new Wall(3, 4, this));
				gameObjects.add(new Wall(4, 4, this));

				gameObjects.add(new Wall(7, 5, this));

				gameObjects.add(new Wall(4, 6, this));
				gameObjects.add(new Wall(5, 6, this));
				gameObjects.add(new Wall(6, 6, this));
				gameObjects.add(new Wall(7, 6, this));

				gameObjects.add(new Wall(0, 9, this));
				gameObjects.add(new Wall(1, 9, this));

				gameObjects.add(new Wall(9, 9, this));
				gameObjects.add(new Wall(8, 9, this));
				gameObjects.add(new Wall(8, 8, this));

				//InitLemmings();
				gameObjects.add(new Lemming(0, 8, this));
				gameObjects.add(new Lemming(2, 3, this));
				gameObjects.add(new Lemming(9, 0, this));

				gameObjects.add(new ExitDoor(4, 5, this));

				gameObjects.add(new Lemming(3, 3, this));
				
				//InitExitDoor();
				
				numLemmings = 4;
				break;

			// Nivel 3
			case 2:
				this.level = 2; 
			//initLevel2();
				// initWalls();
				gameObjects.add(new Wall(8, 1, this));
				gameObjects.add(new Wall(9, 1, this));


				gameObjects.add(new Wall(2, 4, this));
				gameObjects.add(new Wall(3, 4, this));
				gameObjects.add(new Wall(4, 4, this));

				gameObjects.add(new Wall(7, 5, this));

				gameObjects.add(new Wall(4, 6, this));
				gameObjects.add(new Wall(5, 6, this));
				gameObjects.add(new Wall(6, 6, this));
				gameObjects.add(new Wall(7, 6, this));

				gameObjects.add(new Wall(0, 9, this));
				gameObjects.add(new Wall(1, 9, this));

				gameObjects.add(new Wall(9, 9, this));
				gameObjects.add(new Wall(8, 9, this));
				gameObjects.add(new Wall(8, 8, this));
				gameObjects.add(new Wall(3, 5, this));
				gameObjects.add(new MetalWall(3, 6, this));

				// InitLemmings();
				gameObjects.add(new Lemming(0, 8, this));
				gameObjects.add(new Lemming(2, 3, this));
				gameObjects.add(new Lemming(9, 0, this));

				gameObjects.add(new ExitDoor(4, 5, this));

				gameObjects.add(new Lemming(3, 3, this));
				gameObjects.add(new Lemming(6, 0, this));
				gameObjects.add(new Lemming(6, 0, this, new ParachuterRole()));
				
				// InitExitDoor();

				numLemmings = 6;
				break;

			case 3:
				this.level = 3;
				// initWalls();
				gameObjects.add(new Wall(8, 1, this));
				gameObjects.add(new Wall(9, 1, this));


				gameObjects.add(new Wall(2, 4, this));
				gameObjects.add(new Wall(3, 4, this));
				gameObjects.add(new Wall(4, 4, this));

				gameObjects.add(new Wall(7, 5, this));

				gameObjects.add(new Wall(4, 6, this));
				gameObjects.add(new Wall(5, 6, this));
				gameObjects.add(new Wall(6, 6, this));
				gameObjects.add(new Wall(7, 6, this));

				gameObjects.add(new Wall(0, 9, this));
				gameObjects.add(new Wall(1, 9, this));

				gameObjects.add(new Wall(9, 9, this));
				gameObjects.add(new Wall(8, 9, this));
				gameObjects.add(new Wall(8, 8, this));

				//InitLemmings();
				gameObjects.add(new Lemming(9, 0, this));
				numLemmings = 1;

				gameObjects.add(new ExitDoor(4, 5, this));
			default:
				break;
		}
	}

	// Metodos de GameWorld********************************************************************************
		// Funcion para saber si en la posicion de debajo hay una pared
		public boolean isInAir(Position pos) {
			return !gameObjects.wallAtPosition(pos.nextPosition(Direction.DOWN));
		}


	// Metodos de GameStatus********************************************************************************
		// Funcion para obtener el ciclo
		public int getCycle() {
			return cycle;
		}
		// Funcion para obtener el nivel
		public int getLevel() {
			return level;
		}

		// Funcion para obtener el numero de lemmings en el tablero
		public int numLemmingsInBoard() {
			return numLemmings;
		}

		// Funcion para obtener el numero de lemmings muertos
		public int numLemmingsDead() {
			return deadLemmings;
		}

		// Funcion para obtener el numero de lemmings que han salido por la puerta
		public int numLemmingsExit() {
			return exitLemmings;
		}

		// Funcion para obtener el numero de lemmings que tienen que salir por la puerta para ganar
		public int numLemmingsToWin() {
			return lemmingsToWin;
		}

		// Funcion para obtener el numero de lemmings que faltan por salir por la puerta para ganar
		public int numLemmingsLeftToWin() {
			return lemmingsToWin - exitLemmings;
		}

		// Devuelve la representación en forma de string del objeto en la posición dada
		public String positionToString(int col, int row) {	
			return gameObjects.positionToString(col, row);
		}

	// Metodos de GameModel********************************************************************************
		// Funcion para saber si se ha acabado el juego
		public boolean isFinished() {
			return playerWins() || playerLooses() || exit;
		}

		// Funcion para ejecutar un ciclo
		public void update() {
			//Eliminamos los objetos muertos, ya sea porque los lemmings han muerto o han llegado a la puerta
			// O un rol de excavador ha eliminado una pared
			// Actualizamos los objetos
			gameObjects.update();
			increaseCycle();	
			gameObjects.removeDeadObjects();
		}
		

		public void increaseCycle(){
			cycle++;
		}

		// Funcion para reiniciar el juego
		public void reset(int level) {
			gameObjects = new GameObjectContainer();
			initBoard(level);
			cycle = 0;
		}
		// Funcion para saber si el jugador ha ganado
		public boolean playerWins() {
			return exitLemmings >= lemmingsToWin && numLemmings == 0;
		}
	
		// Funcion para saber si el jugador ha perdido
		public boolean playerLooses() {
			//return numLemmings + exitLemmings < lemmingsToWin;
			return numLemmings == 0;
		}

		// Funcion para salir del juego
		public void exit() {
			this.exit = true;
		}

		// Funcion para obtener el tablero segun el nivel
		public void initBoard(int level){
			deadLemmings = 0;
			exitLemmings = 0;
			switch(level){
				case 0:
					InitLevel(0);
					break;
				case 1:
					InitLevel(1);
					break;
				case 2:
					InitLevel(2);
					break;
				case 3:
					InitLevel(3);
					break;
				default:
					break;
			}
		}

		// Funcion que añade 1 a los lemmings que han salido por la puerta
		public void addExitLemmings(){
			exitLemmings++;
			decreaseNumLemmings();
		}

		// Funcion que decrementa el numero de lemmings
		public void decreaseNumLemmings(){
			numLemmings--;
		}

		// Funcion que añade 1 a los lemmings muertos
		public void addDeadLemmings(){
			deadLemmings++;
			decreaseNumLemmings();
		}

		// Funcion que devuelve si la posicion esta dentro de los limites del tablero
		public boolean leavingTheBoard(Position pos){
			return !pos.insideRowsLimits(DIM_Y);
		}

		// Funcion que devuelve si la posicion esta chocando con los limites del tablero
		public boolean crashingIntoLimits(Position pos){
			return !pos.insideColsLimits(DIM_X);
		}

		// Funcion que elimina un objeto del tablero
		public void removeGameObject(GameObject gameObject){
			gameObjects.remove(gameObject);
		}

		// Funcion que fija el rol de un lemming en una posicion, y devuelve si se ha podido fijar
		public boolean setRole(LemmingRole role, Position pos, String roleName){ 
			return gameObjects.setRole(role, pos, roleName);
		}

		// Funcion que devuelve si hay una interaccion entre objetos, reaccionando a la interaccion si la hay
		public boolean receiveInteractionsFrom(GameItem obj){
			return gameObjects.receiveInteractionsFrom(obj);
		}
		
		// Funcion que devuelve si un nivel existe
		public boolean existsLevel(int l) {
			return l >= MIN_LEVEL && l <= MAX_LEVEL;
		}
}