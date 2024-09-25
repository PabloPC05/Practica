package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Game;
import tp1.logic.Position;

public class Lemming {

	//Atributos
	private Position pos;
	private Direction direction;
	private boolean vivo;
	private int fuerzaCaida;
	//private WalkerRole rol;
	//private Game game;
	
	//Constructor por defecto
	public Lemming() {
		this.pos = new Position();
		this.direction = Direction.RIGHT;
		this.vivo = true;
		this.fuerzaCaida = 0;
		//this.rol = new WalkerRole();
		//this.game = game;
	}

	//Constructor con parametros de posicion y direccion
	public Lemming(int c, int r, Direction d) {
		this.pos = new Position(c, r);
		this.direction = d;
		this.vivo = true;
		this.fuerzaCaida = 0;
		//this.rol = new WalkerRole();
		//this.game = game;
	}
	
	// Setters
	//Funcion para cambiar la posicion segun la direccion
	public void update() {
		if (this.vivo) {
			this.pos.update(this.direction);
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
	public boolean isDefunciont() {
		return vivo;
	}

	//Funcion para obtener la fuerza de caida
	public int getFuerzaCaida() {
		return fuerzaCaida;
	}

}
