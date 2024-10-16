package tp1.logic;

//import tp1.view.ConsoleColorsAnsiCodes;
//import java.security.MessageDigest;
import tp1.view.Messages;
//import tp1.logic.gameobjects.Wall;
//import tp1.logic.gameobjects.ExitDoor;
//import tp1.logic.gameobjects.Lemming;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

	public GameObjectContainer gameObjects;
	private int level;
	private int cycle;
	private int lemmingsToWin;

	// Constructores
	// Constructor por defecto
	public Game() {
		gameObjects = new GameObjectContainer();
		initObjects();
		level = 0;
		cycle = 0;
		lemmingsToWin = 3;
	}

	// Constructor con parametros de nivel
	public Game(int nivel) {
		gameObjects = new GameObjectContainer();
		initObjects();
		level = nivel;
		cycle = 0;
		lemmingsToWin = 1;
	}

	// Funcion para inicializar los objetos del juego
	private void initObjects() {
		gameObjects.initWalls();
		gameObjects.initExitDoor();
		gameObjects.initLemmings(this);
	}

	// Funcion para ejecutar un ciclo
	public void update() {
		gameObjects.update();
		cycle++;	
	}

	// Funcion para reiniciar el juego
	public void reset() {
		gameObjects = new GameObjectContainer();
		initObjects();
		cycle = 0;
	}

	// Getters
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
		return gameObjects.getNumLemmings();
	}

	// Funcion para obtener el numero de lemmings muertos
	public int numLemmingsDead() {
		return gameObjects.getDeadLemmings();
	}

	// Funcion para obtener el numero de lemmings que han salido por la puerta
	public int numLemmingsExit() {
		return gameObjects.getExitLemmings();
	}

	// Funcion para obtener el numero de lemmings que tienen que salir por la puerta para ganar
	public int numLemmingsToWin() {
		return lemmingsToWin;
	}

	// Funcion para obtener el numero de lemmings que faltan por salir por la puerta para ganar
	public int numLemmingsLeftToWin() {
		return lemmingsToWin - gameObjects.getExitLemmings();
	}

	// Funcion para obtener que hay que mostrar en una posicion
	public String positionToString(int col, int row) {
		
		Position pos = new Position(col, row);
		int aux = 0;
		StringBuilder str = new StringBuilder();

		// Si esta la puerta en la posicion
		if (gameObjects.getExitDoor().getPos().equals(pos)) {
			if((aux = gameObjects.lemmingAt(pos)) != -1){
				str.append(gameObjects.getLemming(aux).getRol().getIcon(gameObjects.getLemming(aux)));
			}
			str.append(Messages.EXIT_DOOR);
		}
		// Si hay una pared en la posicion
		else if(gameObjects.wallAt(pos) != -1) {
			str.append(Messages.WALL);
		}
		// Si hay un lemming en la posicion
		else if ((aux = gameObjects.lemmingAt(pos)) != -1) {
			str.append(gameObjects.getLemming(aux).getRol().getIcon(gameObjects.getLemming(aux)));
		}
		// Si no hay nada en la posicion
		else {
			str.append(Messages.EMPTY);
		}
		return str.toString();
	}

	// Funcion para pasar de numero a caracter en ASCII
	public char numToChar(int num) {
		char aux = (char) (num + 41);
		return aux;
	}

	// Funcion para saber si el jugador ha ganado
	public boolean playerWins() {
		return gameObjects.getExitLemmings() >= lemmingsToWin;
	}

	// Funcion para saber si el jugador ha perdido
	public boolean playerLooses() {
		return gameObjects.getNumLemmings() + gameObjects.getExitLemmings() < lemmingsToWin;
	}

	// Funcion para saber si se ha acabado el juego
	public boolean isFinished() {
		return playerWins() || playerLooses();
	}

	public String help() {
		return Messages.HELP;
	}
}
