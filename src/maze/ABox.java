package maze;

/**
 * Classe h�rit�e de MBox qui d�signe la case d'arriv�e du labyrinthe.
 * 
 * @author Remy
 */
public class ABox extends MBox {
	
	/**
	 * Constructeur de classe qui cr�e une box de coordonn�es (nPos, pPos),
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
