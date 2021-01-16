package tp04;
import maze.*;

public class Main {

	public static void main(String[] args) {
		
		/* Initialisation du labyrinthe */
		int pMax = Maze.firstLineLen("labyrinthe") - 1;
		int nMax = Maze.countLines("labyrinthe") - 1;
		Maze maze = new Maze(nMax, pMax);
		try {maze.initFromTextFile("labyrinthe");}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Création du labyrinthe résolu */
		Maze solvedMaze = maze.solvedMaze();
		
		/* Affichage de la solution dans la console, 
		 * avec des "." pour indiquer le plus court chemin */
		String solvedMazeString = solvedMaze.solvedMazeToString();
		System.out.print(solvedMazeString);

		/* Sauvegarde du labyrinthe résolu dans data/solvedLabyrinthe.txt */
		try {Maze.saveToTextFile("solvedLabyrinthe", solvedMazeString);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

