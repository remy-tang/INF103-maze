package maze;

public class DBox extends MBox {
	
	/**
	 * Classe h�rit�e de MBox qui d�signe la case de d�part du labyrinthe.
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public DBox(int nPos, int pPos) {
		super(nPos, pPos, "DBox");
	}
}
