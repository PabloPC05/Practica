package tp1.logic;

import java.util.ArrayList;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;

public class GameObjectContainer {
	
	// Atributos
	private ArrayList<Wall> walls;
	private int numWalls;
	private ArrayList<Lemming> lemmings;
	private int numLemmings;
	private int deadLemmings;
	private int exitLemmings;
	private ExitDoor exitDoor;

	//Constantes
	private static final int MAXWALLS = 100;
	private static final int MAXLEMMINGS = 100;


	// Constructores
	// Constructor por defecto
	public GameObjectContainer() {
		walls = new ArrayList<Wall>();
		numWalls = 0;
		lemmings = new ArrayList<Lemming>();
		numLemmings = 0;
		deadLemmings = 0;
		exitLemmings = 0;
		exitDoor = new ExitDoor();
	}

	//Setters
	// Funcion para establecer una nueva posicion para la puerta de salida
	/*public void setExitDoor(Position pos) {
		exitDoor.setPos(pos);
	}*/

	// Funcion que establece la puerta de salida
	/*public void setExitDoor(ExitDoor exitDoor) {
		exitDoor = exitDoor;
	}*/

	// Funcion para actualizar el estado de los lemmings
	public void update() {

		// Eliminamos los lemmings muertos
		removeDeadLemmings();
		// Comprobamos si hay lemmings en la salida, y si los hay los eliminamos
		removeExitLemmings();	

		// Updateamos los lemmings vivos que no estan en la salida
		for (int i = 0; i < numLemmings; i++) {
			if(lemmings.get(i).isVivo()) {
				lemmings.get(i).update();
			}
		}
	}

	// Funcion para inicializar los lemmings
	public void initLemmings(Game game) {
		add(new Lemming(9, 1, Direction.RIGHT, Direction.NONE, game));
	}

	// Funcion para inicializar las paredes
	public void initWalls() {
		add(new Wall(9, 2));
		add(new Wall(8, 2));

		add(new Wall(2, 4));
		add(new Wall(3, 4));
		add(new Wall(4, 4));
		add(new Wall(7, 5));
		add(new Wall(4, 6));
		add(new Wall(5, 6));
		add(new Wall(6, 6));
		add(new Wall(7, 6));

		add(new Wall(0, 9));
		add(new Wall(1, 9));
		add(new Wall(7, 4));


		add(new Wall(9, 9));
		add(new Wall(8, 9));
		add(new Wall(8, 8));
		add(new Wall(1, 8));
	}

		// Funcion para inicializar la puerta de salida
		public void initExitDoor() {
			exitDoor.setPos(new Position(4, 5));
		}
		// Funcion para obtener el numero de lemmings
		public int getNumLemmings() {
			return numLemmings;
		}

	// Getters
		// Funcion para obtener el lemming en la posicion i
		public Lemming getLemming(int i) {
			return new Lemming(lemmings.get(i).getPos(), lemmings.get(i).getDirection(), lemmings.get(i).getPreviousDirection(), lemmings.get(i).getGame());
		}

		// Funcion para obtener el numero de lemmings muertos
		public int getDeadLemmings() {
			return deadLemmings;
		}

		// Funcion para obtener el numero de lemmings que han salido por la puerta
		public int getExitLemmings() {
			return exitLemmings;
		}
		
		// Funcion para obtener la posicion de la puerta de salida
		public ExitDoor getExitDoor() {
			return new ExitDoor(exitDoor.getPos());
		}

	// Metodos para añadir objetos del juego
		// Funcion para añadir un lemming al final de la lista, si no caben mas (no deberia pasar) lo imprime por pantalla y NO se añade
		public void add(Lemming lemming) {
			if (numLemmings < MAXLEMMINGS) {
				lemmings.add(lemming);
				numLemmings++;
			} 
			/*else {
				System.out.println("No se pueden añadir mas lemmings, se ha alcanzado el maximo");
			}*/
		}

		// Funcion para añadir una pared, si no caben mas (no deberia pasar) lo imprime por pantalla y NO se añade
		public void add(Wall wall) {
			if (numWalls < MAXWALLS) {
				walls.add(wall);
				numWalls++;
			} 
			/*else {
				System.out.println("No se pueden añadir mas paredes, se ha alcanzado el maximo");
			}*/
		}
		
		// Funcion para eliminar todos los lemmings muertos
		public void removeDeadLemmings() {
			for (int i = 0; i < numLemmings; i++) {
				if (!lemmings.get(i).isVivo()) {
					numLemmings--;
					deadLemmings++;
					lemmings.remove(i);
				}
			}
		}
		
		// Funcion para eliminar los lemmings que esten en la salida
		public void removeExitLemmings() {
			for (int i = 0; i < numLemmings; i++) {
				if (lemmings.get(i).getPos().equals(exitDoor.getPos())) {
					numLemmings--;
					exitLemmings++;
					lemmings.remove(i);
				}
			}
		}

	// Metodos de busqueda
		// Funcion para ver si hay una pared en la posicion dada, y si la hay devuelve el indice de la pared, si no la hay devuelve -1
		public int wallAt(Position pos) {
			int i = 0; 
			while(i < numWalls && !walls.get(i).getPos().equals(pos)) i++;
			if(i >= numWalls) i = -1;
			return i;
		}

		// Funcion para ver si hay un lemming en la posicion dada, y si lo hay devuelve el indice del lemming, si no lo hay devuelve -1
		public int lemmingAt(Position pos) {
			int i = 0; 
			while(i < numLemmings && !lemmings.get(i).getPos().equals(pos)) i++;
			if(i >= numLemmings) i = -1;
			return i;
		}

}
