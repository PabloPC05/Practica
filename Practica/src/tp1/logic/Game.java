package tp1.logic;

import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
//import tp1.view.ConsoleColorsAnsiCodes;
//import java.security.MessageDigest;
import tp1.view.Messages;
//import tp1.logic.gameobjects.Wall;
//import tp1.logic.gameobjects.ExitDoor;
//import tp1.logic.gameobjects.Lemming;
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
		cycle = 0;
		lemmingsToWin = 3;
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
		cycle = 0;
		lemmingsToWin = 1;
		exit = false;
		deadLemmings = 0;
		exitLemmings = 0;
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
		// Funcion para saber si un objeto esta en el aire
		public boolean isInAir(Position pos) {
			return gameObjects.objectAt(pos.PositionWDir(Direction.DOWN)) == -1;
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
			return Messages.HELP;
		}
}