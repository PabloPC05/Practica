package tp1.logic;

public class Position {

	// Atributos
	private int col;
	private int row;

	// Constructores
	// Constructor por defecto
	public Position() {
		col = 0;
		row = 0;
	}

	// Constructor con parametros
	public Position(int c, int r) {
		col = c;
		row = r;
	}

	// Setters
	// Funcion para actualizar la posicion
	public void update(Direction dir) {
		add(dir);
	}

	// Funcion para establecer la posicion
	private void add(Direction dir) {
		col = col + dir.getX();
		row = row + dir.getY();
	}

	// Getters
	// Funcion para obtener la futura direccion
	public Position PositionWDir(Direction dir) {
		return new Position(col + dir.getX(), row + dir.getY());
	}
}
