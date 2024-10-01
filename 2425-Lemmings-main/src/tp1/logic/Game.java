package tp1.logic;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

	public GameObjectContainer gameObjects;
	private int level;
	private int turno;
	private int lemmingsToWin = 30;

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

	// Setters

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

	// Funcion para obtener la posicion como un string
	public String positionToString(int col, int row) {
		String aux = "";
		char charAux = numToChar(col);
		aux += charAux;
		aux += row;
		return aux;
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

}
