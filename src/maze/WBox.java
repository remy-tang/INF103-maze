package maze;

public class WBox extends MBox {
	
	/**
	 * Classe h�rit�e de MBox qui d�signe un mur dans un labyrinthe.
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public WBox(int nPos, int pPos) {
		super(nPos, pPos, "WBox");
	}

}
