package maze;

/**
 * Classe h�rit�e de MBox qui d�signe un mur dans un labyrinthe.
 * 
 * @author Remy
 */
public class WBox extends MBox {
	
	/**
	 * Constructeur de classe qui cr�e une box de coordonn�es (nPos, pPos),
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
