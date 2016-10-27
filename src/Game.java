public class Game {
	Player player1, player2;

	public static void main(String[] args) {
		int size = 7;
		new Game(size);
	}

	public Game(int size) {
		Table root = new Table(size);
		root.showTable();

		player1 = new Player(size);
		player2 = new Player(size);
		
		char c = '.';
		while (c == '.') {
			player1.play(root, 'r');
			//root.showTable();
			c = root.azmunHadaf();
			if(c != '.')
				break;
			
			player2.play(root, 'b');
			//root.showTable();
			c = root.azmunHadaf();
		}
		root.showTable();
		System.out.println("Winner is: " + c);
		

	}
}
