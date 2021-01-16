package maze;

/**
 * Classe h�rit�e de MBox qui d�signe une case vide dans un labyrinthe.
 * 
 * @author Remy
 */
public class EBox extends MBox {
	
	/**
	 * Constructeur de classe qui cr�e une box de coordonn�es (nPos, pPos),
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
