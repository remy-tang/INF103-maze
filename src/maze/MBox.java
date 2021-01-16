package maze;

import dijkstra.VertexInterface;

/**
 * Classe abstraite à partir de laquelle héritent les classes DBox,
 * ABox, WBox, et EBox.
 * Ces dernières représentent les cases qui composent un labyrinthe.
 * <p>
 * On utilise le terme box pour désigner une case d'un labyrinthe 
 * MBox contient la position (nPos, pPos) de la box, son nom label, 
 * ainsi que son status (0 ou 1), qui indique si elle fait partie du plus court chemin 
 * calculé par l'algorithme de Dijkstra ou non. Par défaut, status vaut 0.
 * 
 * @author Remy
 */
public abstract class MBox implements VertexInterface{
	private final int nPos;
	private final int pPos;
	private final String label; 
	private int status = 0;
	
	/**
	 * Constructeur de classe qui crée une box de coordonnées (nPos, pPos),
	 * et de nom label.
	 * Les indices commencent à 0. Le nom de la box label indique si la box est 
	 * le départ (DBox), l'arrivée (ABox), un mur (WBox), ou une case vide (EBox).
	 * 
	 * @param nPos  l'indice de la ligne de la box
	 * @param pPos  l'indice de la colonne de la box
	 * @param label le nom de la box
	 */
	protected MBox(int nPos, int pPos, String label) {
		this.nPos = nPos;
		this.pPos = pPos;
		this.label = label;
	}
	
	/**
	 * Renvoie l'indice de la ligne de la box.
	 * 
	 * @return l'indice de la ligne de la box
	 */
	public final int getNPos() {
		return nPos;
	}

	/**
	 * Renvoie l'indice de la colonne de la box.
	 * 
	 * @return l'indice de la colonne de la box
	 */
	public final int getPPos() {
		return pPos;
	}
	
	/**
	 * Renvoie le nom de la box.
	 * 
	 * @return le nom de la box
	 */
	public final String getLabel() {
		return this.label;
	}
	
	/**
	 * Renvoie le status de la box : 0 par défaut, ou 1 si elle fait partie 
	 * du plus court chemin calculé par l'algorithme de Dijkstra.
	 * 
	 * @return le status de la box
	 */
	public final int getStatus() {
		return this.status;
	}
	
	/**
	 * Met à jour la box pour indiquer que la box fait partie 
	 * du plus court chemin calculé par l'algorithme de Dijkstra.
	 */
	public void updateStatus() {
		this.status = 1;
	}
}
