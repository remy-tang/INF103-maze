package maze;

/**
 * Classe h�rit�e de MBox qui d�signe la case de d�part du labyrinthe.
 * 
 * @author Remy
 */
public class DBox extends MBox {
	
	/**
	 * Constructeur de classe qui cr�e une box de coordonn�es (nPos, pPos),
	 * et de nom "DBox".
	 * 
	 * @param nPos l'indice de la ligne
	 * @param pPos l'indice de la colonne
	 * @see   MBox
	 */
	public DBox(int nPos, int pPos) {
		super(nPos, pPos, "DBox");
	}
}
