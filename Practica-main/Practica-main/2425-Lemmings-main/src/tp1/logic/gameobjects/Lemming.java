package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.logic.Direction;


public class Lemming {

	//Atributos
	private Position pos;
	private Direction direction;
	private Direction previousDirection;
	private boolean vivo;
	private int fuerzaCaida; // Con 3 se muere
	private WalkerRole rol;
	private Game game;
	
	//Constructores
	//Constructor por defecto
	public Lemming() {
		this.pos = new Position();
		this.direction = Direction.RIGHT;
		this.previousDirection = Direction.NONE;
		this.vivo = true;
		this.fuerzaCaida = 0;
		this.rol = new WalkerRole();
		//this.game = game;
	}

	// Constructor con parametros de posicion y direccion
	public Lemming(int c, int r, Direction d, Game game) {
		this.pos = new Position(c, r);
		this.direction = d;
		this.vivo = true;
		this.fuerzaCaida = 0;
		this.rol = new WalkerRole();
		this.game = game;
		// Si no hay una pared abajo, se cambia la direccion a DOWN y se guarda la anterior
		if (game.gameObjects.wallAt(pos.PositionWDir(Direction.DOWN)) == -1) {
			previousDirection = direction;
			direction = Direction.DOWN;
		}
	}

	// Constructor con parametros de posicion (objeto) y direccion
	public Lemming(Position pos, Direction d, Game game) {
		this.pos = pos;
		this.direction = d;
		this.vivo = true;
		this.fuerzaCaida = 0;
		this.rol = new WalkerRole();
		this.game = game;
		// Si no hay una pared abajo, se cambia la direccion a DOWN y se guarda la anterior
		if (game.gameObjects.wallAt(pos.PositionWDir(Direction.DOWN)) == -1) {
			previousDirection = direction;
			direction = Direction.DOWN;
		}
	}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion
	public void update() {
		if (this.vivo) {
			rol.play(this);
		}
	}
	
	// Mueve el lemming
	public void move() {
		// Si la direccion es hacia abajo
		if (direction == Direction.DOWN) {
			// Si hay una pared abajo
			if (game.gameObjects.wallAt(pos.PositionWDir(direction)) != -1) {
				// Si la fuerza de caida es mayor o igual a 3, muere
				if (fuerzaCaida >= 3) {
					vivo = false;
				// Si no, se reinicia la fuerza de caida
				} else {
					fuerzaCaida = 0;
					direction = previousDirection;
				}
			}
			// Si no hay una pared abajo, aumenta la fuerza de caida y se actualiza la posicion con la direccion
			else {
				fuerzaCaida++;
				pos.update(direction);
			}
		}
		// Si esta yendo a la derecha o izquierda
		else if (direction == Direction.RIGHT || direction == Direction.LEFT) {
			// Si hay una pared en la siguiente posicion, se cambia la direccion a la simetrica y se guarda la anterior
			if (pos.PositionWDir(direction).getCol() < 0 || pos.PositionWDir(direction).getCol() >= Game.DIM_X || game.gameObjects.wallAt(pos.PositionWDir(direction)) != -1) {
				previousDirection = direction;
				if (direction == Direction.RIGHT) {
					direction = Direction.LEFT;
				} else {
					direction = Direction.RIGHT;
				}
			// Si no hay una pared a la izquierad o derecha, se actualiza la posicion con la direccion
			} else {
				// Se actualiza la posicion con la direccion
				pos.update(direction);
				// Si no hay una pared abajo, se cambia la direccion a DOWN y se guarda la anterior
				if (game.gameObjects.wallAt(pos.PositionWDir(Direction.DOWN)) == -1) {
					previousDirection = direction;
					direction = Direction.DOWN;
				}
			}
		}
	}

	// Getters
		//Funcion para obtener la posicion
		public Position getPos() {
			return new Position(this.pos.getCol(), this.pos.getRow());
		}

		//Funcion para obtener la direccion
		public Direction getDirection() {
			Direction newDirection = direction;
			return newDirection;
		}

		//Funcion para obtener si esta vivo
		public boolean isVivo() {
			return vivo;
		}

		// Funcion para obtener la fuerza de caida
		public int getFuerzaCaida() {
			return fuerzaCaida;
		}

		// Funcion para obtener el rol
		public WalkerRole getRol() {
			return new WalkerRole();
		}

		// Funcion para obtener la proxima posicion
		public Position nextPos() {
			return pos.PositionWDir(direction);
		}

		// Funcion para obtener el juego
		public Game getGame() {
			return new Game(this.game.getLevel());
		}

}