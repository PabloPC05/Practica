package tp1.logic.gameobjects;
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
}
