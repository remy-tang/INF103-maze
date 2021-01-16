package maze;

/**
 * Classe héritée de MBox qui désigne une case vide dans un labyrinthe.
 * 
 * @author Remy
 */
public class EBox extends MBox {
	
	/**
	 * Constructeur de classe qui crée une box de coordonnées (nPos, pPos),
	 * et de nom "EBox".
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public EBox(int nPos, int pPos) {
		super(nPos, pPos, "EBox");
	}

}
