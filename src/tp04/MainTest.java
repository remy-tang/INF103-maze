package tp04;

import maze.*;


public class MainTest {

	public static void main(String[] args) {
		
		/* Sauvegarde labyrinthe */
		
//		Maze SolvedMaze = new Maze(9,9);
//		try {maze.saveToTextFile("solvedLabyrinthe");}
//		catch (Exception e) {
//			e.printStackTrace();
		
		/* Initialisation labyrinthe */
		Maze maze = new Maze(9,9);
		try {maze.initFromTextFile("labyrinthe");}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.print(maze.solvedMazeString(maze));

	}
	}
