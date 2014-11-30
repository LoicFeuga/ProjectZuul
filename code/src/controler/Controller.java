package controler;

import model.item.Item;

/**
 *
 * @author loic
 * sdfqsdf
 */

public class Controller {
	private Game game;

	public Controller(){
		game = new Game(this);
		game.play();
	}


	public Item getItem(int i){
		return (Item) game.getListItem().get(i);
	}

	public Game getGame(){
		return game;
	}

	public static void main(String[] args) {
		Controller c1 = new Controller();
	}

}
