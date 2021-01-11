package tp04;

import maze.*;


public class MainTest {

	public static void main(String[] args) {
		
		/* Initialisation labyrinthe de dimensions connues � l'avance */
		Maze maze = new Maze(9,9);
		try {maze.initFromTextFile("labyrinthe");}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Affichage de la solution dans la console, 
		   avec des "*" pour indiquer le plus court chemin */
		System.out.print(maze.solvedMazeString(maze));

	}
}

/* Sauvegarde labyrinthe (non utilis�) */

//Maze SolvedMaze = new Maze(9,9);
//try {maze.saveToTextFile("solvedLabyrinthe");}
//catch (Exception e) {
//	e.printStackTrace();