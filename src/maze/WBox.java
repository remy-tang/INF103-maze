package maze;

/**
 * Classe héritée de MBox qui désigne un mur dans un labyrinthe.
 * 
 * @author Remy
 */
public class WBox extends MBox {
	
	/**
	 * Constructeur de classe qui crée une box de coordonnées (nPos, pPos),
	 * et de nom "WBox".
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public WBox(int nPos, int pPos) {
		super(nPos, pPos, "WBox");
	}

}
