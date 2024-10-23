package tp1.logic;

import java.util.ArrayList;
import tp1.logic.gameobjects.*;

public class GameObjectContainer {
	
	// Atributos
	private ArrayList<GameObject> gameObjects;
	private int numLemmings;
	private int numWalls;
	private int numExitDoors;

	//Constantes
	private static final int MAXOBJECTS = 100;


	// Constructores
	// Constructor por defecto
	public GameObjectContainer() {
		this.gameObjects = new ArrayList<GameObject>();
		this.numLemmings = 0;
		this.numWalls = 0;
		this.numExitDoors = 0;
	}

	//Setters
	// Funcion para actualizar el estado de los lemmings
	public void update() {

		// Eliminamos los lemmings muertos
		removeDeadLemmings();
		// Comprobamos si hay lemmings en la salida, y si los hay los eliminamos
		removeExitLemmings();	

		// Updateamos los lemmings vivos que no estan en la salida
		for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i).isVivo()) {
				gameObjects.get(i).update();
			}
		}
	}

	// Getters
		// Funcion para obtener el numero de lemmings
		public int getNumLemmings() {
			return numLemmings;
		}

		// Funcion para obtener el numero de paredes
		public int getNumWalls() {
			return numWalls;
		}

		// Funcion para obtener el numero de puertas
		public int getNumDoors() {
			return numExitDoors;
		}

	// Metodos para añadir objetos del juego
		// Funcion para añadir un objeto
		public void add(GameObject gameObject) {
			gameObjects.add(gameObject);
		}
		
		// Funcion para eliminar todos los lemmings muertos
		public void removeDeadLemmings() {
			for (int i = 0; i < numLemmings; i++) {
				if (!gameObjects.get(i).isVivo()) {
					numLemmings--;
					deadLemmings++;
					gameObjects.remove(i);
				}
			}
		}
		
		// Funcion para eliminar los lemmings que esten en la salida
		public void removeExitLemmings() {
			for (int i = 0; i < numLemmings; i++) {
				if (gameObjects.get(i).getPos().equals(exitDoor.getPos())) {
					numLemmings--;
					exitLemmings++;
					gameObjects.remove(i);
				}
			}
		}

	// Metodos de busqueda
		// Funcion para ver si hay un objeto en la posicion dada, y si la hay devuelve el indice del objeto, si no lo hay devuelve -1
		public int objectAt(Position pos) {
			for (int i = 0; i < gameObjects.size(); i++) {
				if (gameObjects.get(i).getPos().equals(pos)) {
					return i;
				}
			}
			return -1;
		}
}
