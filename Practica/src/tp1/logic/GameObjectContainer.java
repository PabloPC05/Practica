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
			/*int N = gameObjects.size();
			for(int i = 0; i < N; i++){
				if(!gameObjects.get(i).isVivo()){
					gameObjects.remove(i);
					i--;
					N--;	
				}
			}*/
			gameObjects.removeIf(n -> !n.isVivo());
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
			/*for(GameObject obj : gameObjects){
				if(obj.isExit() && obj.isInPosition(pos)){
					return true;
				}
			}*/
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

		public void remove(GameObject obj){
			gameObjects.remove(obj);
		}
}
