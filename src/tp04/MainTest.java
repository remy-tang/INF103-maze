package tp04;

import maze.Maze;

public class MainTest {

	public static void main(String[] args) {
		Maze maze = new Maze(9,9);
		try {maze.saveToTextFile("labyrinthe");}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
