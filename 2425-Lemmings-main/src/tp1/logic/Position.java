package tp1.logic;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	// Atributos
	private int col;
	private int row;

	// Constructores
	// Constructor por defecto
	public Position() {
		this.col = 0;
		this.row = 0;
	}

	// Constructor con parametros
	public Position(int c, int r) {
		this.col = c;
		this.row = r;
	}

	// Setters
	// Funcion para actualizar la posicion
	public void update(Direction dir) {
		this.col = this.col + dir.getX();
		this.row = this.row + dir.getY();
	}

	// Getters
	// Funcion para obtener la columna
	public int getCol() {
		return col;
	}

	// Funcion para obtener la fila
	public int getRow() {
		return row;
	}
}
