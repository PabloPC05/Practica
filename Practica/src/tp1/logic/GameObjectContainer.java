package tp1.logic;

import java.util.ArrayList;
import tp1.logic.gameobjects.*;

public class GameObjectContainer {
	
	// Atributos
	private ArrayList<GameObject> gameObjects;

	//Constantes
	//private static final int MAXOBJECTS = 100;


	// Constructores
	// Constructor por defecto
	public GameObjectContainer() {
		this.gameObjects = new ArrayList<GameObject>();
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
		

	// Metodos para añadir objetos del juego
		// Funcion para añadir un objeto
		public void add(GameObject gameObject) {
			gameObjects.add(gameObject);
		}
		
		// Funcion para eliminar todos los lemmings muertos
		public int removeDeadLemmings() {
			int deadLemmings = 0;
			for (int i = 0; i < gameObjects.size(); i++) {
				if (!gameObjects.get(i).isVivo()) {
					deadLemmings++;
					gameObjects.remove(i);
				}
			}
			return deadLemmings;
		}
		
		// Funcion para eliminar los lemmings que esten en la salida
		public int removeExitLemmings() {
			int exitLemmings = 0;
			for (int i = 0; i < gameObjects.size(); i++) {
				if (gameObjects.get(i).getPos().equals(exitDoor.getPos())) {
					exitLemmings++;
					gameObjects.remove(i);
				}
			}
			return exitLemmings;
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
