package tp04;
import maze.*;

/**
 * Classe Main.
 * 
 * @author Remy
 */
public class Main {

	/**
	 * R�sout un labyrinthe et sauvegarde la solution dans un fichier texte.
	 * Tous les fichiers sont dans le dossier data.
	 * Le labyrinthe intial doit �tre nomm� mazeFileName.txt.
	 * Le labyrinthe r�solu est sauvegard� dans solvedMazeFileName.txt.
	 * 
	 * @param args arguments de main (vide ici)
	 */
	public static void main(String[] args) {
		
		/* Param�tres */
		String mazeFileName = "labyrinthe";
		String solvedMazeFileName = "labyrintheResolu";
		
		/* Initialisation du labyrinthe */
		int pMax = Maze.firstLineLen(mazeFileName) - 1;
		int nMax = Maze.countLines(mazeFileName) - 1;
		Maze maze = new Maze(nMax, pMax);
		try {maze.initFromTextFile(mazeFileName);}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/* Cr�ation du labyrinthe r�solu */
		Maze solvedMaze = maze.solvedMaze();
		
		/* Affichage de la solution dans la console, 
		 * avec des "." pour indiquer le plus court chemin */
		String solvedMazeString = solvedMaze.solvedMazeToString();
		System.out.print(solvedMazeString);

		/* Sauvegarde du labyrinthe r�solu dans data/solvedLabyrinthe.txt */
		try {Maze.saveToTextFile(solvedMazeFileName, solvedMazeString);}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

