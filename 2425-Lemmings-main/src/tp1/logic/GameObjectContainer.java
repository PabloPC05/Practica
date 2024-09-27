package tp1.logic;

import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.Position;

public class GameObjectContainer {
	
	// Atributos
	private Wall[] walls;
	private int numWalls;
	private int maxWalls = 100;
	private Lemming[] lemmings;
	private int numLemmings;
	private int maxLemmings = 100;

	// Constructores
	// Constructor por defecto
	public GameObjectContainer() {
		this.walls = new Wall[maxWalls];
		this.numWalls = 0;
		this.lemmings = new Lemming[maxLemmings];
		this.numLemmings = 0;
	}

	// Setters
	// Funcion para añadir una pared, si no caben mas (no deberia pasar) lo imprime por pantalla y NO se añade
	public void addWall(Wall wall) {
		if (numWalls < maxWalls) {
			walls[numWalls] = wall;
			numWalls++;
		} else {
			System.out.println("No se pueden añadir mas paredes, se ha alcanzado el maximo");
		}
	}

	// Funcion para añadir un lemming, si no caben mas (no deberia pasar) lo imprime por pantalla y NO se añade
	public void addLemming(Lemming lemming) {
		if (numLemmings < maxLemmings) {
			lemmings[numLemmings] = lemming;
			numLemmings++;
		} else {
			System.out.println("No se pueden añadir mas lemmings, se ha alcanzado el maximo");
		}
	}

	// Getters
	// Funcion para obtener el array de paredes
	public Wall[] getWalls() {
		return walls;
	}

	// Funcion para obtener el numero de paredes
	public int getNumWalls() {
		return numWalls;
	}

	// Funcion para obtener la pared en la posicion i
	public Wall getWall(int i) {
		return walls[i];
	}

	// Funcion para ver si hay una pared en la posicion dada, y si la hay devuelve el indice de la pared, si no la hay devuelve -1
	public int wallAt(Position pos) {
		for (int i = 0; i < numWalls; i++) {
			if (walls[i].getPos().getCol() == pos.getCol() && walls[i].getPos().getRow() == pos.getRow()) {
				return i;
			}
		}
		return -1;
	}

	// Funcion para eliminar una pared en la posicion dada y devolver si se ha podido eliminar, usando wallAt
	public boolean removeWall(Position pos) {
		int i = wallAt(pos);
		if (i != -1) {
			for (int j = i; j < numWalls - 1; j++) {
				walls[j] = walls[j + 1];
			}
			numWalls--;
			return true;
		}
		return false;
	}

	// Funcion para obtener el array de lemmings
	public Lemming[] getLemmings() {
		return lemmings;
	}

	// Funcion para obtener el numero de lemmings
	public int getNumLemmings() {
		return numLemmings;
	}

	// Funcion para obtener el lemming en la posicion i
	public Lemming getLemming(int i) {
		return lemmings[i];
	}

	// Funcion para ver si hay un lemming en la posicion dada, y si lo hay devuelve el indice del lemming, si no lo hay devuelve -1
	public int lemmingAt(Position pos) {
		for (int i = 0; i < numLemmings; i++) {
			if (lemmings[i].getPos().getCol() == pos.getCol() && lemmings[i].getPos().getRow() == pos.getRow()) {
				return i;
			}
		}
		return -1;
	}

	// Funcion para eliminar un lemming en la posicion dada y devolver si se ha podido eliminar, usando lemmingAt
	public boolean removeLemming(Position pos) {
		int i = lemmingAt(pos);
		if (i != -1) {
			for (int j = i; j < numLemmings - 1; j++) {
				lemmings[j] = lemmings[j + 1];
			}
			numLemmings--;
			return true;
		}
		return false;
	}
	
}
