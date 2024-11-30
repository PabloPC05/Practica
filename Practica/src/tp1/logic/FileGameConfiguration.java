package tp1.logic;


import java.io.BufferedReader;
import java.io.FileReader;

import tp1.exceptions.GameLoadException;
import tp1.logic.Interfaces.GameConfiguration;
import tp1.logic.Interfaces.GameWorld;

public class FileGameConfiguration implements GameConfiguration {

    private int cycle;
    private int numLemmingInBoard;
    private int numLemmingsDead;
    private int numLemmingsExit;
    private int numLemmingsToWin;

    private GameObjectContainer gameObjects;

    public static final GameConfiguration NONE = new FileGameConfiguration();

    public FileGameConfiguration() {
    }

    public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException{

        // Leemos el archivo
        try (FileReader fr = new FileReader(fileName + ".txt")){ {
            // Creamos un buffer de lectura
            BufferedReader br = new BufferedReader(fr);
            // Leemos la configuración del juego
            String lineaAux;
            lineaAux=br.readLine();
            String[] linea = lineaAux.split(" ");
            // Actualizamos los valores
            cycle = Integer.parseInt(linea[0]);
            numLemmingInBoard = Integer.parseInt(linea[1]);
            numLemmingsDead = Integer.parseInt(linea[2]);
            numLemmingsExit = Integer.parseInt(linea[3]);
            numLemmingsToWin = Integer.parseInt(linea[4]);

            // Leemos los objetos del juego
            while((lineaAux=br.readLine())!=null){
                // NO SE COMO SEGUIR AQUI
                linea = lineaAux.split(" ");
                GameObject obj = new GameObject();
            }
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }


    }

    @Override
    public GameObjectContainer getGameObjects() {
        // TODO: Implement this method
        return null;
    }

    // Getters
    @Override
    public int getCycle() {
        return cycle;
    }
    @Override
    public int numLemmingInBoard() {
        return numLemmingInBoard;
    }
    @Override
    public int numLemmingsDead() {
        return numLemmingsDead;
    }
    @Override
    public int numLemmingsExit() {
        return numLemmingsExit;
    }
    @Override
    public int numLemmingsToWin() {
        return numLemmingsToWin;
    }
    
}
