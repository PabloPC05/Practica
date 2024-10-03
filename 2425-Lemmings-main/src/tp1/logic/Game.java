package tp1.logic;

import java.security.MessageDigest;

import tp1.view.Messages;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

	public GameObjectContainer gameObjects;
	private int level;
	private int turno;
	private int lemmingsToWin = 3;

	// Constructores
	// Constructor por defecto
	public Game() {
		this.gameObjects = new GameObjectContainer();
		this.level = 0;
		this.turno = 0;
	}

	// Constructor con parametros de nivel
	public Game(int nivel) {
		this.gameObjects = new GameObjectContainer();
		this.level = nivel;
		this.turno = 0;
	}

	public void update() {
		gameObjects.update();
		turno++;
	}

	// Getters
	// Funcion para obtener el ciclo
	public int getTurno() {
		return turno;
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
			if (gameObjects.getLemming(aux).getDirection() == Direction.RIGHT) {
				return Messages.LEMMING_RIGHT;
			} else if (gameObjects.getLemming(aux).getDirection() == Direction.LEFT) {
				return Messages.LEMMING_LEFT;
			} else  {
				return Messages.LEMMING_RIGHT;
			}
		}
		// Si hay una pared en la posicion
		else if ((aux = gameObjects.wallAt(pos)) != -1) {
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
	public boolean isPlaying() {
		return !playerWins() && !playerLooses();
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}


	//Nuevas funciones que no estaban
	public int getCycle() {
		// TODO Auto-generated method stub
		return 0;
	}
}
