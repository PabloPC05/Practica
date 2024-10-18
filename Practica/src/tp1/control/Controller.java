package tp1.control;

import tp1.control.commands.Command;
import tp1.control.commands.CommandGenerator;
<<<<<<< HEAD
import tp1.logic.Direction;
=======
>>>>>>> 9d560ad3000b5e0fb3e69c9e24aa2c08415a1c9d
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.view.GameView;
import tp1.view.Messages;

/**
 *  Accepts user input and coordinates the game execution logic
 */
public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}


	/**
	 * Runs the game logic, coordinate Model(game) and View(view)
	 */
	public void run() {
		String[] words = null;

		view.showWelcome();

		view.showGame();
		while (!game.isFinished()) {
			words = view.getPrompt();
			Command command = CommandGenerator.parse(words);
			if (command != null)
				command.execute(game, view);
			else 
				view.showError(Messages.UNKNOWN_COMMAND.formatted(words[0]));

		}
		view.showEndMessage();
	}
<<<<<<< HEAD

	// Funcion para inicializar los lemmings
	public void initLemmings(Game game) {
		game.gameObjects.add(new Lemming(9, 1, Direction.RIGHT, Direction.NONE, game));
	}

	// Funcion para inicializar las paredes
	public void initWalls() {
		game.gameObjects.add(new Wall(9, 2, game));
		game.gameObjects.add(new Wall(9, 3, game));

		game.gameObjects.add(new Wall(8, 3, game));
		game.gameObjects.add(new Wall(7, 3, game));
		game.gameObjects.add(new Wall(6, 3, game));
		game.gameObjects.add(new Wall(5, 3, game));
		game.gameObjects.add(new Wall(4, 3, game));
		game.gameObjects.add(new Wall(3, 3, game));
		game.gameObjects.add(new Wall(2, 3, game));
		game.gameObjects.add(new Wall(1, 3, game));
		game.gameObjects.add(new Wall(0, 3, game));

	}

		// Funcion para inicializar la puerta de salida
		public void initExitDoor() {
			game.gameObjects.add(new ExitDoor(0, 4, game));
		}
=======
>>>>>>> 9d560ad3000b5e0fb3e69c9e24aa2c08415a1c9d
}
