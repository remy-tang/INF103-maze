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
		
		/* Affichage de la solution dans la console, 
		   avec des "*" pour indiquer le plus court chemin */
		System.out.print(Maze.solvedMazeString(maze));

	}
}

/* Sauvegarde labyrinthe (non utilisé) */

//Maze SolvedMaze = new Maze(9,9);
//try {maze.saveToTextFile("solvedLabyrinthe");}
//catch (Exception e) {
//	e.printStackTrace();