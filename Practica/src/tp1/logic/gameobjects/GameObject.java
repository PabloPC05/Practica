package tp1.logic.gameobjects;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Direction;
import tp1.logic.Interfaces.GameWorld;
import tp1.logic.Position;
import tp1.logic.lemmingRoles.LemmingRole;


public abstract class GameObject implements GameItem {
    
    // Atributos
    protected Position pos;
    protected boolean vivo;
    protected GameWorld gameWorld;
    
    // Constructores
        // Constructor por defecto

        // Constructor con parametros
        public GameObject() {
            pos = new Position();
            vivo = true;
        }
        
        protected GameObject(Position pos, boolean vivo, GameWorld game) {
            this.pos = pos;
            this.vivo = vivo;
            this.gameWorld = game;
        }
    
    // Setters
        // Funcion para establecer la posicion del objeto
        public void setPos(Position pos) {
            this.pos = pos;
        }

        // Funcion update
        public abstract void update();
        // Funcion para obtener la representacion del objeto
        public abstract String toString(); 
        // Funcion para saber si un objeto es solido
        public abstract boolean isSolid();
        //Funcion para establecer un rol a un objeto de juego
        public boolean setRole(LemmingRole rol, String str) {
            return false;
        }

    // Getters
        // Funcion para saber si el objeto esta vivo
        public boolean isAlive() {
            return vivo;
        }

        // Funcion para saber si la posicion de un objeto coincide con otra posicion
        public boolean isInPosition(Position pos) {
            return this.pos.isEqualTo(pos);
        }

        // Funcion para saber si la posicion de un objeto coincide con la de otro
        public boolean isInPosition(GameObject other) {
            return other.pos.isEqualTo(this.pos);
        }

        // Funcion que mata a un objeto
        public void dies(){
            vivo = false;
        }

        // Funciones para interactuar con los objetos del juego (por defecto no hace nada)
        public boolean interactWith(Lemming lemming){
            return false;
        }
        public boolean interactWith(Wall wall){
            return false;
        }
        public boolean interactWith(ExitDoor door){
            return false;
        }
        public boolean interactWith(MetalWall metalWall){
            return false;
        }

        // Funcion para obtener a partir de un string la posicion de un objeto
        protected Position getPositionFrom(String line) throws OffBoardException {
            String[] parts = line.replaceAll("[()]", "").split(",");
            int col = Integer.parseInt(parts[0].trim());
            int row = Integer.parseInt(parts[1].trim());
            Position pos = new Position(row, col);
            if (!pos.insideLimits()) {
                throw new OffBoardException("Position out of limits");
            }
            return pos;
        }

        // Funcion para obtener la direccion de un objeto a partir de un string
        protected Direction getDirectionFrom(String line) throws ObjectParseException {
            if (line.equalsIgnoreCase("RIGHT")) {
                return Direction.RIGHT;
            } else if(line.equalsIgnoreCase("LEFT")) {
                return Direction.LEFT;
            }
            else {
                throw new ObjectParseException();
            }
        }

        public abstract GameObject parse(String[] line, GameWorld game) throws ObjectParseException, OffBoardException;

        // Funcion para clonar un objeto
        public abstract GameObject clone();

}
