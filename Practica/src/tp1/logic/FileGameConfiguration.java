package tp1.logic;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import tp1.exceptions.GameLoadException;
import tp1.exceptions.ObjectParseException;
import tp1.exceptions.OffBoardException;
import tp1.logic.Interfaces.GameConfiguration;
import tp1.logic.Interfaces.GameWorld;
import tp1.logic.gameobjects.GameObjectFactory;
import tp1.view.Messages;

public class FileGameConfiguration implements GameConfiguration {

    //Atributos
    private int cycle;
    private int numLemmingInBoard;
    private int numLemmingsDead;
    private int numLemmingsExit;
    private int numLemmingsToWin;
    private GameObjectContainer gameObjects;

    //Constantes
    public static final GameConfiguration NONE = new FileGameConfiguration();

    //Constructores
    public FileGameConfiguration() {
    }

    public FileGameConfiguration(String fileName, GameWorld game) throws GameLoadException {
        // Leemos el archivo
        gameObjects = new GameObjectContainer();
        try (FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr)) {
            // Leemos la configuración del juego
            String lineaAux;
            lineaAux = br.readLine();
            String[] linea = lineaAux.split(" ");
            if (linea.length != 5) {
                // Lanza una excepcion con mensaje de error Incorrect game status
                throw new GameLoadException(Messages.FILE_FORMAT_ERROR.formatted(lineaAux));
            }
            // Actualizamos los valores de la configuración del juego
            cycle = Integer.parseInt(linea[0]);
            numLemmingInBoard = Integer.parseInt(linea[1]);
            numLemmingsDead = Integer.parseInt(linea[2]);
            numLemmingsExit = Integer.parseInt(linea[3]);
            numLemmingsToWin = Integer.parseInt(linea[4]);
            // Leemos los objetos del juego
            while ((lineaAux = br.readLine()) != null) {
                gameObjects.add(GameObjectFactory.parse(lineaAux, game));
            }
        } catch (IOException e) {
            // Lanza una excepcion con mensaje de error: File format error si el formato del archivo no es correcto
            throw new GameLoadException(Messages.FILE_FORMAT_ERROR.formatted(fileName), e);
        } catch (ObjectParseException e) {
            // Lanza una excepcion con mensaje de error: File not found si no encuentra el archivo
            throw new GameLoadException(Messages.FILE_NOT_FOUND.formatted(fileName), e);
        } catch (OffBoardException e) {
            // Lanza una excepcion con mensaje de error: Off board exception
            throw new GameLoadException(e);
        }
    }

    @Override
    public GameObjectContainer getGameObjects() {
        return gameObjects;
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



