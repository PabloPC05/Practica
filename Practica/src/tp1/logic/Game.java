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
		initBoard();
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
		initBoard();
		cycle = 0;
		lemmingsToWin = 1;
		exit = false;
		deadLemmings = 0;
		exitLemmings = 0;
	}

	public void InitLevel1(){
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

	}
	/* 
	// Funcion para inicializar los objetos del juego
	private void initObjects() {
		initWalls();
		initExitDoor();
		initLemmings();
	}

	
	// Funcion para inicializar los lemmings
	public void initLemmings() {
		gameObjects.add(new Lemming(9, 1, Direction.RIGHT, Direction.NONE, this));
	}

	// Funcion para inicializar las paredes
	public void initWalls() {
		gameObjects.add(new Wall(9, 2, this));
		gameObjects.add(new Wall(9, 3, this));

		gameObjects.add(new Wall(8, 3, this));
		gameObjects.add(new Wall(7, 3, this));
		gameObjects.add(new Wall(6, 3, this));
		gameObjects.add(new Wall(5, 3, this));
		gameObjects.add(new Wall(4, 3, this));
		gameObjects.add(new Wall(3, 3, this));
		gameObjects.add(new Wall(2, 3, this));
		gameObjects.add(new Wall(1, 3, this));
		gameObjects.add(new Wall(0, 3, this));

	}

	// Funcion para inicializar la puerta de salida
	public void initExitDoor() {
		gameObjects.add(new ExitDoor(0, 4, this));
	}
	*/

	// Metodos de GameWorld********************************************************************************
		// Funcion para saber si una posicion es aire
		public boolean isInAir(Position pos) {
			return gameObjects.objectAt(pos) == -1;
		}

		// Funcion para saber si un objeto esta cayendo
		public boolean isFalling(Position pos) {
			// Comprobamos si hay un objeto en la posicion
			int indiceAux = gameObjects.objectAt(pos);
			// Si hay un objeto, comprobamos el objeto de debajo y vemos si es solido
			if (indiceAux != -1) {
			 	int indiceDebajo = gameObjects.objectAt(pos.PositionWDir(Direction.DOWN));
				// Si no hay objeto debajo o el objeto de debajo no para la caida, el objeto esta cayendo
				return indiceDebajo == -1 || !gameObjects.get(indiceAux).isSolid();
			}
			// Si no hay objeto en la posicion o hay un objeto que para la caida, no esta cayendo
			return false;
		}

		// Funcion para saber si un lemming ha llegado a la puerta de salida
		public boolean lemmingArrived() {
			//return gameObjects.getExitDoor().getPos().equals(pos);
			return false;
		}

		// Funcion para eliminar los lemmings muertos
		public void removeDeadLemmings() {
			deadLemmings += gameObjects.removeDeadLemmings();
		}

		// Funcion para eliminar los lemmings que han salido por la puerta
		public void removeExitLemmings() {
			exitLemmings += gameObjects.removeExitLemmings();
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

		public String positionToString(int col, int row) {	
			Position pos = new Position(col, row);
			int aux = 0;
			StringBuilder str = new StringBuilder();
			if((aux = gameObjects.objectAt(pos)) != -1) {
				str.append(gameObjects.get(aux).toString());
			}
			return str.toString();
		}

	// Metodos de GameModel********************************************************************************
		// Funcion para saber si se ha acabado el juego
		public boolean isFinished() {
			return playerWins() || playerLooses() || exit;
		}

		// Funcion para ejecutar un ciclo
		public void update() {
			gameObjects.update();
			cycle++;	
		}

		// Funcion para reiniciar el juego
		public void reset() {
			gameObjects = new GameObjectContainer();
			//initObjects();
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
			exit = true;
		}

		public String help() {
			//return Messages.HELP;
			return "";
		}

		// Funcion para obtener el tablero segun el nivel
		public void initBoard(){
			switch(level){
				case 1:
					InitLevel1();
					break;
				default:
					break;
			}
		}
}