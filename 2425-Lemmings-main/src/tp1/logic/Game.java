package tp1.logic;

import java.security.MessageDigest;
import tp1.view.Messages;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;
import tp1.logic.gameobjects.Lemming;

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
		this.gameObjects = new GameObjectContainer();
		this.initObjects();
		this.level = 0;
		this.cycle = 0;
		this.lemmingsToWin = 3;
	}

	// Constructor con parametros de nivel
	public Game(int nivel) {
		this.gameObjects = new GameObjectContainer();
		this.initObjects();
		this.level = nivel;
		this.cycle = 0;
		this.lemmingsToWin = 3;
	}

	// Funcion para inicializar los objetos del juego
	private void initObjects() {
		gameObjects.add(new Wall(0, 6));
		gameObjects.add(new Wall(1, 6));
		gameObjects.add(new Wall(2, 6));
		gameObjects.add(new Wall(3, 6));
		gameObjects.add(new Wall(4, 6));
		gameObjects.add(new Wall(5, 6));
		gameObjects.add(new Wall(6, 6));
		gameObjects.add(new Wall(6, 5));

		gameObjects.add(new Lemming(0, 4, Direction.RIGHT, this));
		gameObjects.add(new Lemming(1, 4, Direction.RIGHT, this));
		gameObjects.add(new Lemming(2, 3, Direction.RIGHT, this));
		gameObjects.add(new Lemming(3, 3, Direction.RIGHT, this));

		gameObjects.setExitDoor(new ExitDoor(9, 5));

	}

	// Funcion para ejecutar un ciclo
	public void update() {
		gameObjects.update();
		cycle++;
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
		int aux;

		// Si hay un lemming en la posicion
		if ((aux = gameObjects.lemmingAt(pos)) != -1) {
			// Devolvemos el lemming segun su direccion
			return gameObjects.getLemming(aux).getRol().getIcon(gameObjects.getLemming(aux));
		}
		// Si hay una pared en la posicion
		else if(gameObjects.wallAt(pos) != -1) {
			return Messages.WALL;
		}
		// Si esta la puerta en la posicion
		else if (gameObjects.getExit().getPos().equals(pos)) {
			return Messages.EXIT_DOOR;
		}
		// Si no hay nada en la posicion
		else {
			return Messages.EMPTY;
		}
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

	// Funcion para saber si se sigue jugando
	/*public boolean isPlaying() {
		return !playerWins() && !playerLooses();
	}*/

	// Funcion para saber si se ha acabado el juego
	public boolean isFinished() {
		return playerWins() || playerLooses();
	}

	public String help() {
		return Messages.HELP;
	}
}
