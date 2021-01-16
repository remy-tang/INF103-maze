package maze;

public class ABox extends MBox {
	
	/**
	 * Classe h�rit�e de MBox qui d�signe la case d'arriv�e du labyrinthe.
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public ABox(int nPos, int pPos) {
		super(nPos, pPos, "ABox");
	}

}
