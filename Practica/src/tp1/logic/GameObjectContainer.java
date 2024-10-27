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
			for(GameObject obj : gameObjects){
				if(obj.isLemming() && !obj.isVivo()){
					gameObjects.remove(gameObjects.indexOf(obj));
					deadLemmings++;
				}
			}
			return deadLemmings;
		}
		
		// Funcion para eliminar los lemmings que esten en la salida
		public int removeExitLemmings() {
			int exitLemmings = 0, indexExitDoor = exitDoorIndex();
			GameObject exit = gameObjects.get(indexExitDoor);
			// Recorremos los objetos
			for(GameObject obj : gameObjects){
				// Si es un lemming y esta en la misma posicion que la puerta de saida
				if(obj.isLemming() && obj.isInPosition(exit)){
					exitLemmings++;
					gameObjects.remove(gameObjects.indexOf(obj));
				}
			}
			return exitLemmings;
		}

	// Metodos de busqueda
		// Funcion para ver si hay un objeto en la posicion dada, y si la hay devuelve el indice del objeto, si no lo hay devuelve -1
		public int objectAt(Position pos) {
			int i = 0; 
			while(i < gameObjects.size() && !gameObjects.get(i).isInPosition(pos)) {
				i++;
			}
			if(i == gameObjects.size()) i = -1;
			return i;
		}

		// Funcion para devolver el indice de la exitDoor
		public int exitDoorIndex() {
			int index = -1;
			for (GameObject gameObject : gameObjects) {
				if(gameObject.isExitDoor()) {
					index = gameObjects.indexOf(gameObject);
					break;
				}
			}
			return index; 
		}
}
