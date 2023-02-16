package mru.game.application;

//import mru.game.controller.CardDeck;
import mru.game.controller.GameManager;
//import mru.game.view.AppMenu;
//import mru.game.controller.PuntoBancoGame;

public class AppDriver {

	public static void main(String[] args) throws Exception {

		// This is the starting point of the project!
		// hint - It usually calls method from GameManager class to start the app, so
		// only one or two lines will be written here

		new GameManager();
//		new PuntoBancoGame().winner();
//		AppMenu am = new AppMenu();
//		am.prtintPlayer();
//		CardDeck k = new CardDeck();
//		System.out.println(k.drawCard());
//		AppMenu am = new AppMenu();
//		am.showWinner("Player won", 100);
	}
	/**
	 * Most of the coding logic and code are inspired from
	 * @author Khosro Salmani
	 * Special thanks to our author.
	 * https://www.loom.com/share/8bfd9c43a9bf4ca5bb117fc41bb44c5d
	 * https://www.loom.com/share/16b29c94392e43df8a1bcc691a9a27ef
	 * https://www.loom.com/share/df2d09af32b9416c92400d4c9a94f83e
	 */

}
