package maze;

public class ABox extends MBox {
	
	/**
	 * La classe héritée de MBox qui désigne la case d'arrivée du labyrinthe.
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public ABox(int nPos, int pPos) {
		super(nPos, pPos, "ABox");
	}

}
