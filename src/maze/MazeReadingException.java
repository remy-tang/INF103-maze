package maze;

/**
* Est lev�e si le programme rencontre une erreur lors de la lecture du fichier texte
* sens� repr�senter un labyrinthe.
*
* @author Remy
*/
public class MazeReadingException extends Exception {
	private final String fileName;
	private final int exceptionAtLine;
	private final String exceptionMessage;
	
	public MazeReadingException(String fileName, int exceptionAtLine, String exceptionMessage) { 
		// do smth with fileName and exceptionAtLine
		super("Exception thrown: " + exceptionMessage);
		this.fileName = fileName;
		this.exceptionAtLine = exceptionAtLine;
		this.exceptionMessage = exceptionMessage;
	}
	
	public final String getFileName() {
		return fileName;
	}
	
	public final int getExceptionAtLine() {
		return exceptionAtLine;
	}
	
	public final String getExceptionMessage() {
		return exceptionMessage;
	}
}
