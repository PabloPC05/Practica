package tp1.logic.gameobjects;
import tp1.logic.Position;
import tp1.logic.Game;

public abstract class GameObject {
    
    // Atributos
    protected Position pos;
    protected boolean vivo;
    protected Game game;
    
    // Constructores
        // Constructor por defecto
        protected GameObject() {
            pos = new Position();
            vivo = true;
            game = new Game();
        }

        // Constructor con parametros
        protected GameObject(Position pos, boolean vivo, Game game) {
            this.pos = pos;
            this.vivo = vivo;
            this.game = game;
        }
    
    // Setters
        // Funcion para establecer la posicion del objeto
        public void setPos(Position pos) {
            this.pos = pos;
        }

        // Funcion para fijar el juego
        public void setGame(Game game) {
            this.game = game;
        }

        // Funcion update
        public abstract void update();

    // Getters
        // Funcion para saber si el objeto esta vivo
        public boolean isVivo() {
            return vivo;
        }

        //  Funcion para obtener el juego
        public Game getGame() {
            return new Game(game.getLevel());
        }

        // Funcion para saber si el objeto esta en una posicion
        public boolean isInPosition(Position pos) {
            return this.pos.equals(pos);
        }

        // Funcion para obtener la representacion del objeto
        public abstract String toString();     
        
        // Funcion para saber si un objeto es solido
        public abstract boolean isSolid();
}
