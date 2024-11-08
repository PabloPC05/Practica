package tp1.logic;

import java.util.ArrayList;
import tp1.logic.gameobjects.*;
import tp1.logic.lemmingRoles.LemmingRole;
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
			gameObjects.removeIf(n -> !n.isAlive());
		}

		public boolean wallAtPosition(Position pos){
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).isSolid() && gameObjects.get(i).isInPosition(pos)){
					return true;
				}
			}
			return false;
		}

		public boolean exitAt(Position pos){
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).isExit() && gameObjects.get(i).isInPosition(pos)){
					return true;
				}
			}
			return false;
		}

		public String positionToString(int col, int row){
			String str = Messages.EMPTY;
			Position pos = new Position(col, row);
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).isInPosition(pos)){
					str += gameObjects.get(i).toString();
				}
			}
			return str.toString();
		}

		public int numLemmings(){
			int returnValue = 0;
			for(GameObject obj : gameObjects){
				if(!(obj.isSolid() || obj.isExit())) returnValue++;
			}
			return returnValue;
		}

		public void remove(GameObject obj){
			gameObjects.remove(obj);
		}
		
		public int objectAt(Position pos) {
			int index = -1;
			for(int i = 0; i < gameObjects.size() && index == -1; i++) {
				if(gameObjects.get(i).isInPosition(pos)) index = i; 
			}
			return index;
		}
		
		public boolean setRole(LemmingRole role, int col, int row) {
			Position pos = new Position(col, row);
			for (int i = 0; i < gameObjects.size(); i++) {
				if (gameObjects.get(i).isInPosition(pos) && gameObjects.get(i).setRole(role)) {
					return true;
				}
			}
			return false;
		}

		public boolean receiveInteractionsFrom(GameItem obj){
			boolean interaction = false;
			for(int i = 0; i < gameObjects.size(); i++){
				if(gameObjects.get(i).receiveInteraction(obj)){
					interaction = true;
				}
			}
			return interaction;
		}
}
