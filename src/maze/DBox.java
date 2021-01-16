package maze;

public class DBox extends MBox {
	
	/**
	 * Classe héritée de MBox qui désigne la case de départ du labyrinthe.
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public DBox(int nPos, int pPos) {
		super(nPos, pPos, "DBox");
	}
}
