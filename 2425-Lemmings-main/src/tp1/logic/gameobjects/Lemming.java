package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.logic.lemmingRoles.WalkerRole;
import tp1.logic.Direction;


public class Lemming {

	//Atributos
	private Position pos;
	private Direction direction;
	private boolean vivo;
	private int fuerzaCaida; // Con 3 se muere
	private WalkerRole rol;
	private Game game;
	
	//Constructores
	//Constructor por defecto
	public Lemming() {
		this.pos = new Position();
		this.direction = Direction.RIGHT;
		this.vivo = true;
		this.fuerzaCaida = 0;
		this.rol = new WalkerRole();
		this.game = game;
	}

	//Constructor con parametros de posicion y direccion
	public Lemming(int c, int r, Direction d) {
		this.pos = new Position(c, r);
		this.direction = d;
		this.vivo = true;
		this.fuerzaCaida = 0;
		this.rol = new WalkerRole();
		this.game = game;
	}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion
	public void update() {
		if (this.vivo) {
			rol.advance(this);
		}
	}
	
	// Mueve el lemming
	public void move() {
		if (direction == Direction.DOWN) {
			if (game.gameObjects.wallAt(pos.PositionWDir(direction)) != -1) {
				if (fuerzaCaida >= 3) {
					vivo = false;
				} else {
					fuerzaCaida = 0;
				}
			} else {
				fuerzaCaida++;
				pos.update(direction);
			}
		}
		else if (direction == Direction.RIGHT || direction == Direction.LEFT) {
			if (game.gameObjects.wallAt(pos.PositionWDir(direction)) != -1) {
				direction.setSymmetric();
			} else {
				this.pos.update(direction);
				if (game.gameObjects.wallAt(pos.PositionWDir(Direction.DOWN)) == -1) {
					direction = Direction.DOWN;
				}
			}
		}
	}

	// Getters
	//Funcion para obtener la posicion
	public Position getPos() {
		return pos;
	}

	//Funcion para obtener la direccion
	public Direction getDirection() {
		return direction;
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
		return rol;
	}

	// Funcion para obtener la proxima posicion
	public Position nextPos() {
		return pos.PositionWDir(direction);
	}

}