package mru.game.application;

import mru.game.controller.PuntoBancoGame;

public class AppDriver {

	public static void main(String[] args) throws Exception {

		// This is the starting point of the project!
		// hint - It usually calls method from GameManager class to start the app, so
		// only one or two lines will be written here

//		new GameManager();
		new PuntoBancoGame().winner();
//		AppMenu am = new AppMenu();
//		am.prtintPlayer();

	}

}
