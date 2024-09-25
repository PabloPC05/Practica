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

	// Funcion para obtener el array de lemmings
	public Lemming[] getLemmings() {
		return lemmings;
	}

	// Funcion para obtener el numero de lemmings
	public int getNumLemmings() {
		return numLemmings;
	}

	// Funcion para obtener la pared en la posicion i
	public Wall getWall(int i) {
		return walls[i];
	}

	// Funcion para ver si hay una pared en la posicion dada, y si la hay devuelve su posicion, si no la hay devuelve una posicion sin sentido (-1,-1)
	public Position wallAt(Position pos) {
		for (int i = 0; i < numWalls; i++) {
			if (walls[i].getPos().getCol() == pos.getCol() && walls[i].getPos().getRow() == pos.getRow()) {
				return walls[i].getPos();
			}
		}
		return new Position(-1, -1);
	}

	// Funcion para eliminar una pared en la posicion dada y devolver si se ha podido eliminar




}
