package tp1.control;

import tp1.control.commands.Command;
import tp1.control.commands.CommandGenerator;
import tp1.exceptions.CommandException;
import tp1.logic.Game;
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
		// Mientras el juego no haya terminado
		while (!game.isFinished()) {
			// Leemos el comando
			words = view.getPrompt();
			try {
				Command command = CommandGenerator.parse(words);
				// Si el comando no es nulo lo ejecutamos y mostramos el juego
				if (command != null){
					command.execute(game, view);
				}
				// Si no, mostramos un mensaje de error
				else view.showError(Messages.UNKNOWN_COMMAND.formatted(words[0]));
				}   catch (CommandException e) {
					StringBuilder str = new StringBuilder(e.getMessage());
					//str.deleteCharAt(str.length() - 1);
					//.deleteCharAt(str.length() - 1);
					view.showError(str.toString());
					Throwable cause = e.getCause();			
					if (cause != null){
						StringBuilder causeStr = new StringBuilder(cause.getMessage());
						//causeStr.deleteCharAt(causeStr.length() - 1);
						//causeStr.deleteCharAt(causeStr.length() - 1);
						view.showError(causeStr.toString());
					}    
 			}
		}
		// Mostramos el mensaje de fin de juego
		view.showEndMessage();
	}
}
