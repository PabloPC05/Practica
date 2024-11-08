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
		col = col + dir.getcol();
		row = row + dir.getrow();
	}

	// Getters
	// Funcion para obtener la futura direccion
	public Position nextPosition(Direction dir) {
		return new Position(col + dir.getcol(), row + dir.getrow());
	}

	public boolean insideColsLimits(int limitX) {
		return this.col >= 0 && this.col < limitX;
	}

	public boolean insideRowsLimits(int limitY) {
		return this.row >= 0 && this.row < limitY;
	}

	public boolean crashingIntoLimits(){
		return !insideColsLimits(Game.DIM_X);
	}

	public boolean insideGameRowsLimits(){
		return !insideRowsLimits(Game.DIM_Y);
	}

	public boolean isEqualTo(Position pos) {
		return this.col == pos.col && this.row == pos.row;
	}
}
