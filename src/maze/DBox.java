package maze;

/**
 * Classe héritée de MBox qui désigne la case de départ du labyrinthe.
 * 
 * @author Remy
 */
public class DBox extends MBox {
	
	/**
	 * Constructeur de classe qui crée une box de coordonnées (nPos, pPos),
	 * et de nom "DBox".
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public DBox(int nPos, int pPos) {
		super(nPos, pPos, "DBox");
	}
}
