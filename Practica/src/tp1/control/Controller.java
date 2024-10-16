package tp1.control;

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
	 * 
	 */
	public void run() {
		view.showWelcome();
		view.showGame();
		//TODO fill your code: The main loop that displays the game, asks the user for input, and executes the action.
		while (!game.isFinished() && command()) {
			view.showGame();
		}
		view.showEndMessage();
	}

	private boolean command(){
		// Leemos el comando
		String[] action = view.getPrompt();
		boolean returnValue;
		switch(action[0].toLowerCase()){
			case "":
			case "n":
			case "none":
				game.update();
				returnValue = true;
				break;
			case "r":
			case "reset":
				game.reset();
				returnValue = true;
				break;
			case "h":
			case "help":
				view.showMessage(Messages.HELP);
				returnValue = true;
				break;
			case "e":
			case "exit":
				returnValue = false;
				break;
			default:
				view.showError(Messages.UNKNOWN_COMMAND);
				returnValue = true;
				break;
		}
		return returnValue;
	}

}
