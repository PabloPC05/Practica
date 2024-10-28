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
		// Updateamos los lemmings vivos que no estan en la salida
		/*for (int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.get(i).isVivo()) {
				gameObjects.get(i).update();
			}
		}*/

		// La comprobacion de si esta vivo o no, se hace en el metodo update de la clase Lemming 
		// asi que no hace falta que se compruebe aqui
		gameObjects.forEach(n -> n.update());
	}

	// Getters
	// Metodo para obtener el objeto dado un indice
	public GameObject get(int index) {
		return gameObjects.get(index);
	}
		
	// Metodos para añadir objetos del juego
		// Funcion para añadir un objeto
		public void add(GameObject gameObject) {
			gameObjects.add(gameObject);
		}
		
		// Funcion para eliminar todos los lemmings muertos
		public int removeDeadLemmings() {
			int deadLemmings = 0;
			// Recorremos los objetos
			for(GameObject obj : gameObjects) {
				// Si es un lemming y no esta vivo lo eliminamos
				if(obj.isLemming() && !obj.isVivo()) {
					gameObjects.remove(obj);
					deadLemmings++;
				}
			}
			return deadLemmings;
		}
		
		// Funcion para eliminar los lemmings que esten en la salida
		public int removeExitLemmings() {
			int exitLemmings = 0;
			GameObject exit = gameObjects.get(exitDoorIndex());
			// Recorremos los objetos
			for(GameObject obj : gameObjects) {
				if(obj.isLemming() && obj.isInPosition(exit)) {
					gameObjects.remove(obj);
					exitLemmings++;
				}
			}
			return exitLemmings;
		}

	// Metodos de busqueda
		// Funcion para ver si hay un objeto en la posicion dada, y si la hay devuelve el indice del objeto, si no lo hay devuelve -1
		public int objectAt(Position pos) {
			for(GameObject obj : gameObjects) {
				if(obj.isInPosition(pos)) {
					return gameObjects.indexOf(obj);
				}
			}
			/*while(i < gameObjects.size() && !gameObjects.get(i).isInPosition(pos)) {
				i++;
			}
			if(i == gameObjects.size()) i = -1;*/
			return -1;
		}

		// Funcion para devolver el indice de la exitDoor
		public int exitDoorIndex() {
			for(GameObject obj : gameObjects) {
				if(obj.isExit()) {
					return gameObjects.indexOf(obj);
				}
			}
			return -1;
		}
}
