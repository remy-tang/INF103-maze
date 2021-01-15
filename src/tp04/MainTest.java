package tp04;
import maze.*;

public class MainTest {

	public static void main(String[] args) {
		
		/* Initialisation du labyrinthe de dimensions connues à l'avance */
		Maze maze = new Maze(11,9);
		try {maze.initFromTextFile("labyrinthe");}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Création du labyrinthe résolu */
		Maze solvedMaze = Maze.solvedMaze(maze);
		
		/* Affichage de la solution dans la console, 
		   avec des "*" pour indiquer le plus court chemin */
		String solvedMazeString = solvedMaze.solvedMazeString();
		System.out.print(solvedMazeString);

		/* Sauvegarde du labyrinthe résolu */
		try {solvedMaze.saveToTextFile("solvedLabyrinthe", solvedMazeString);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

