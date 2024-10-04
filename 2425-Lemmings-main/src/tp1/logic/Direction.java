package tp1.logic;

/**
 * Represents the allowed directions in the game
 *
 */
public enum Direction {
	LEFT(-1,0), RIGHT(1,0), DOWN(0,1), UP(0,-1), NONE(0,0);
	
	private int x;
	private int y;
	
	// Constructores
	// Constructor por defecto
	private Direction() {
		this.x=0;
		this.y=0;
	}

	// Constructor con parametros
	private Direction(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	// Setters
		// Funcion para establecer una direccion
		public void setDirection(Direction dir) {
			this.x = dir.x;
			this.y = dir.y;
		}

		// Funcion para establecer la direccion simetrica
		public void setSymmetric() {
			this.x = -this.x;
			this.y = -this.y;
		}

	// Getters
		// Funcion para obtener la coordenada x
		public int getX() {
			return x;
		}

		// Funcion para obtener la coordenada y
		public int getY() {
			return y;
		}

		// Funcion para devolver la direccion
		public Direction getDir() {
			Direction newDirection = this;
			return newDirection;
		}
	
}
