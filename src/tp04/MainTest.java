package tp04;

public class MainTest {

	public static void main(String[] args) {
		Maze maze = new Maze(9,9);
		try {maze.initFromTextFile("labyrinthe");}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
