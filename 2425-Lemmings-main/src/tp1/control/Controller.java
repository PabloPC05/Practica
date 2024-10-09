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
			//view.showGame();
			view.showGame();
		}
		view.showEndMessage();
	}

	private boolean command(){
		// Leemos el comando
		String[] action = view.getPrompt();

		// Sin comando, equivalente a none (ninguno), lo cual significa avanzar en el juego
		if (action[0].equals("") || action[0].equals("n")) {
			game.update();
			return true;
		}
		// Comando reset (reiniciar)
		else if (action[0].equals("r")){
			game.reset();
			return true;
		}
		// Comando help (ayuda)
		else if (action[0].equals("h")){
			view.showMessage(Messages.HELP);
		}
		// Comando exit (salir)
		else if (action[0].equals("e")){
			return false;
		}
		// Comando desconocido (cualquier otro)
		else{
			view.showError(Messages.UNKNOWN_COMMAND);
		}
		return true;
	}

}
