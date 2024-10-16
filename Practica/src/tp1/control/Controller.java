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
		switch(action[0].toLowerCase()){
			case "":
			case "n":
			case "none":
				game.update();
				return true;
			case "r":
			case "reset":
				game.reset();
				return true;
			case "h":
			case "help":
				view.showMessage(Messages.HELP);
				return true;
			case "e":
			case "exit":
				return false;
			default:
				view.showError(Messages.UNKNOWN_COMMAND);
				return true;	
		}

	}

}
