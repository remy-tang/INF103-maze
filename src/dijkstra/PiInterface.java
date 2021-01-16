package dijkstra;

/**
 * Interface de la fonction Pi utilis�e dans l'algorithme de Dijkstra.
 *
 * @author Remy
 */
public interface PiInterface {
	
	/**
	 * Assigne une valeur au sommet.
	 * 
	 * @param vertex  le sommet consid�r�
	 * @param value   la valeur assign�e
	 */
	public void setValue(VertexInterface vertex, int value);
	
	/**
	 * Renvoie longueur du chemin � partir de la racine du graphe.
	 * 
	 * @param  vertex  le sommet � atteindre
	 * @return		   la longueur du chemin jusqu'� vertex en partant de la racine
	 */
	public int getValue(VertexInterface vertex); 
	
}
