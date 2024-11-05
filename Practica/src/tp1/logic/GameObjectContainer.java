package tp1.logic;

import java.util.ArrayList;
import tp1.logic.gameobjects.*;
import tp1.view.Messages;

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

		public void removeDeadObjects(){
			for(GameObject obj : gameObjects){
				if(!obj.isVivo()){
					gameObjects.remove(obj);
				}
			}
		}

		public boolean wallAt(Position pos){
			for(GameObject obj : gameObjects) {
				if(obj.isSolid() && obj.isInPosition(pos)) {
					return true;
				}
			}
			return false;
		}

		public boolean exitAt(Position pos){
			for(GameObject obj : gameObjects){
				if(obj.isExit() && obj.isInPosition(pos)){
					return true;
				}
			}
			return false;
		}

		public String positionToString(int col, int row){
			String str = Messages.EMPTY;
			Position pos = new Position(row, col);
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).isInPosition(pos)){
					str += gameObjects.get(i).toString();
				}
			}
			/*for(GameObject obj : gameObjects){
				if(obj.isInPosition(new Position(row, col))){
					str.append(obj.toString());
				}
			}*/
			return str.toString();
		}

		public int numLemmings(){
			int returnValue = 0;
			for(GameObject obj : gameObjects){
				if(!(obj.isSolid() || obj.isExit())) returnValue++;
			}
			return returnValue;
		}


			// Metodos de busqueda
		// Funcion para ver si hay un objeto en la posicion dada, y si la hay devuelve el indice del objeto, si no lo hay devuelve -1
		/*public int objectAt(Position pos) {
			for(GameObject obj : gameObjects) {
				if(obj.isInPosition(pos)) {
					return gameObjects.indexOf(obj);
				}
			}
			/*while(i < gameObjects.size() && !gameObjects.get(i).isInPosition(pos)) {
				i++;
			}
			if(i == gameObjects.size()) i = -1;
			return -1;
		}*/


				// Funcion para eliminar todos los lemmings muertos
		/*public int removeDeadLemmings() {
			int deadLemmings = 0;
			// Recorremos los objetos
			for(int i = 0; i < gameObjects.size(); i++) {
				// Si es un lemming y no esta vivo lo eliminamos
				if(gameObjects.get(i).isLemming() && !gameObjects.get(i).isVivo()) {
					gameObjects.remove(i);
					deadLemmings++;
				}
			}
			return deadLemmings;
		}
		
		// Funcion para eliminar los lemmings que esten en la salida
		public int removeExitLemmings() {
			int exitLemmings = 0;
			// Recorremos los objetos
			for(int i = 0; i < gameObjects.size(); i++) {
				// Si es un lemming y esta en la salida lo eliminamos
				if(!(gameObjects.get(i).isSolid() || gameObjects.get(i).isExit())){

				}
				/*if (gameObjects.get(i).isLemming() && gameObjects.get(i).isInPosition(exit)) {
					gameObjects.remove(i);
					exitLemmings++;
				}
			}
			return exitLemmings;
		}*/



}
