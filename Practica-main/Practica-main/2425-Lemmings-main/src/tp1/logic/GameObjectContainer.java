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
		this.walls = new ArrayList<Wall>();
		this.numWalls = 0;
		this.lemmings = new ArrayList<Lemming>();
		this.numLemmings = 0;
		this.deadLemmings = 0;
		this.exitLemmings = 0;
		this.exitDoor = new ExitDoor();
	}

	//Setters
	// Funcion para establecer una nueva posicion para la puerta de salida
	/*public void setExitDoor(Position pos) {
		exitDoor.setPos(pos);
	}*/

	// Funcion que establece la puerta de salida
	/*public void setExitDoor(ExitDoor exitDoor) {
		this.exitDoor = exitDoor;
	}*/

	// Funcion para actualizar el estado de los lemmings
	public void update() {
		// Updateamos los lemmings vivos que no estan en la salida
		for (int i = 0; i < numLemmings; i++) {
			if(lemmings.get(i).isVivo() && !lemmings.get(i).getPos().equals(exitDoor.getPos())) {
				lemmings.get(i).update();
			}
		}
		// Eliminamos los lemmings muertos
		removeDeadLemmings();
		// Comprobamos si hay lemmings en la salida, y si los hay los eliminamos
		removeExitLemmings();
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

	// Getters
		// Funcion para obtener el numero de paredes
		/*public int getNumWalls() {
			return numWalls;
		}*/

		// Funcion para obtener la pared en la posicion i
		/*public Wall getWall(int i) {
			return new Wall(walls.get(i).getPos());
		}*/

		// Funcion para obtener el numero de lemmings
		public int getNumLemmings() {
			return numLemmings;
		}

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
			} else {
				//System.out.println("No se pueden añadir mas lemmings, se ha alcanzado el maximo");
			}
		}

		// Funcion para añadir una pared, si no caben mas (no deberia pasar) lo imprime por pantalla y NO se añade
		public void add(Wall wall) {
			if (numWalls < MAXWALLS) {
				walls.add(wall);
				numWalls++;
			} else {
				//System.out.println("No se pueden añadir mas paredes, se ha alcanzado el maximo");
			}
		}
		
	// Metodos para eliminar objetos del juego
		// Funcion para eliminar una pared en la posicion dada y devolver si se ha podido eliminar, usando wallAt
		/*public boolean removeWall(Position pos) {
			int i = wallAt(pos);
			if (i != -1) {
				numWalls--;
				walls.remove(i);
				return true;
			}
			return false;
		}*/

		// Funcion para eliminar un lemming en la posicion dada y devolver si se ha podido eliminar, usando lemmingAt
		/*public boolean removeLemming(Position pos) {
			int i = lemmingAt(pos);
			if (i != -1) {
				deadLemmings++;
				lemmings.remove(i);
				return true;
			}
			return false;
		}*/

		// Funcion para eliminar un lemming pasando un obejto lemming y devolver si se ha podido eliminar, usando lemmingAt
		/*public boolean removeLemming(Lemming lemming) {
			int i = lemmingAt(lemming);
			if (i != -1) {
				numLemmings--;
				deadLemmings++;
				lemmings.remove(i);
				return true;
			}
			return false;
		}*/

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
			while(i < numWalls && !walls.get(i).getPos().equals(pos)) {
				i++;
			}
			if(i >= numWalls) i = -1;
			return i;
		}

		// Funcion para ver si hay un lemming en la posicion dada, y si lo hay devuelve el indice del lemming, si no lo hay devuelve -1
		public int lemmingAt(Position pos) {
			int i = 0; 
			while(i < numLemmings && !lemmings.get(i).getPos().equals(pos)){
				i++;
			}
			if(i >= numLemmings) return i = -1;
			return i;
		}

		// Funcion para ver si hay un lemming que coincida con un lemming dado, y si lo hay devuelve el indice del lemming, si no lo hay devuelve -1
		/*public int lemmingAt(Lemming lemming) {
			int i = 0; 
			while(i < numLemmings && !lemmings.get(i).equals(lemming)){
				i++;
			}
			if(i >= numLemmings) return i = -1;
			return i;
		}*/
}
