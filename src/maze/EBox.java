package maze;

public class EBox extends MBox {
	
	/**
	 * Classe h�rit�e de MBox qui d�signe une case vide dans un labyrinthe.
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public EBox(int nPos, int pPos) {
		super(nPos, pPos, "EBox");
	}

}
