package tp04;
import maze.*;

public class MainTest {

	public static void main(String[] args) {
		
		/* Initialisation du labyrinthe de dimensions connues � l'avance */
		Maze maze = new Maze(11,9);
		try {maze.initFromTextFile("labyrinthe");}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Cr�ation du labyrinthe r�solu */
		Maze solvedMaze = Maze.solvedMaze(maze);
		
		/* Affichage de la solution dans la console, 
		   avec des "*" pour indiquer le plus court chemin */
		String solvedMazeString = solvedMaze.solvedMazeString();
		System.out.print(solvedMazeString);

		/* Sauvegarde du labyrinthe r�solu */
		try {solvedMaze.saveToTextFile("solvedLabyrinthe", solvedMazeString);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

