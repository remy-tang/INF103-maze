package maze;

/**
 * Classe héritée de MBox qui désigne la case d'arrivée du labyrinthe.
 * 
 * @author Remy
 */
public class ABox extends MBox {
	
	/**
	 * Constructeur de classe qui crée une box de coordonnées (nPos, pPos),
	 * et de nom "ABox".
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public ABox(int nPos, int pPos) {
		super(nPos, pPos, "ABox");
	}

}
