package tp1.logic;

//import tp1.logic.gameobjects.ExitDoor;
//import tp1.logic.gameobjects.Lemming;
//import tp1.logic.gameobjects.Wall;
//import tp1.view.ConsoleColorsAnsiCodes;
//import java.security.MessageDigest;
//import tp1.view.Messages;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.Interfaces.GameModel;
import tp1.logic.Interfaces.GameStatus;
import tp1.logic.Interfaces.GameWorld;

public class Game implements GameModel, GameStatus, GameWorld {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

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
		initBoard(1);
		cycle = 0;
		lemmingsToWin = 1;
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
		lemmingsToWin = 1;
		exit = false;
		deadLemmings = 0;
		exitLemmings = 0;
	}

	public void InitLevel(int level) {

		switch (level) {
			case 1:
				// initWalls();
		gameObjects.add(new Wall(1, 8, this));
		gameObjects.add(new Wall(1, 9, this));
		gameObjects.add(new Wall(4, 2, this));
		gameObjects.add(new Wall(4, 3, this));
		gameObjects.add(new Wall(4, 4, this));
		gameObjects.add(new Wall(4, 4, this));
		gameObjects.add(new Wall(5, 7, this));
		gameObjects.add(new Wall(6, 4, this));
		gameObjects.add(new Wall(6, 5, this));
		gameObjects.add(new Wall(6, 6, this));
		gameObjects.add(new Wall(6, 7, this));
		gameObjects.add(new Wall(8, 8, this));
		gameObjects.add(new Wall(9, 8, this));
		gameObjects.add(new Wall(9, 9, this));
		gameObjects.add(new Wall(9, 0, this));
		gameObjects.add(new Wall(9, 1, this));

		//InitExitDoor();
		gameObjects.add(new ExitDoor(5, 4, this));

		//InitLemmings();
		gameObjects.add(new Lemming(0, 9, this));
		gameObjects.add(new Lemming(3, 2, this));
		gameObjects.add(new Lemming(8, 0, this));
		numLemmings = 3;
				break;
		
			default:
				break;
		}
	}

	// Metodos de GameWorld********************************************************************************
		// Funcion para saber si en la posicion de debajo hay una pared
		public boolean isInAir(Position pos) {
			return !gameObjects.wallAt(pos.nextPosition(Direction.DOWN));
		}

		// Funcion para saber si un objeto esta dentro de los limites del tablero
		public boolean isInsideLimits(Position pos) {
			return pos.isInsideLimits(DIM_X, DIM_Y);
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
			updateNumLemmings();
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
			gameObjects.removeDeadObjects();
			// Actualizamos los objetos
			gameObjects.update();
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
			return exitLemmings >= lemmingsToWin;
		}
	
		// Funcion para saber si el jugador ha perdido
		public boolean playerLooses() {
			return numLemmings + exitLemmings < lemmingsToWin;
		}

		public void exit() {
			this.exit = true;
		}

		public String help() {
			//return Messages.HELP;
			return "";
		}

		public boolean isExit(Position pos){
			return gameObjects.exitAt(pos);
		}

		public boolean isWall(Position pos){
			return gameObjects.wallAt(pos);
		}

		// Funcion para obtener el tablero segun el nivel
		public void initBoard(int level){
			switch(level){
				case 1:
					InitLevel(1);
					break;
				default:
					break;
			}
		}

		public void addExitLemmings(){
			exitLemmings++;
		}

		public void updateNumLemmings(){
			numLemmings = gameObjects.numLemmings();
		}

		// Funcion para obtener que hay que mostrar en una posicion
		/*public String positionToString(int col, int row) {	
			Position pos = new Position(col, row);
			int aux = 0;
			StringBuilder str = new StringBuilder();

			// Si esta la puerta en la posicion
			if (gameObjects.getExitDoor().getPos().equals(pos)) {
				if((aux = gameObjects.objectAt(pos)) != -1){
					str.append(gameObjects.getLemming(aux).getRol().getIcon(gameObjects.getLemming(aux)));
				}
				str.append(Messages.EXIT_DOOR);
			}
			// Si hay una pared en la posicion
			//wall.isInPosition(pos)
			else if(gameObjects.objectAt(pos) != -1) {
				str.append(Messages.WALL);
			}
			// Si hay un lemming en la posicion
			else if ((aux = gameObjects.objectAt(pos)) != -1) {
				str.append(gameObjects.getLemming(aux).getRol().getIcon(gameObjects.getLemming(aux)));
			}
			// Si no hay nada en la posicion
			else {
				str.append(Messages.EMPTY);
			}
			return str.toString();
		}*/
}