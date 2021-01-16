package dijkstra;

/**
 * Interface de la fonction Pi utilisée dans l'algorithme de Dijkstra.
 *
 * @author Remy
 */
public interface PiInterface {
	
	/**
	 * Assigne une valeur au sommet.
	 * 
	 * @param vertex  le sommet considéré
	 * @param value   la valeur assignée
	 */
	public void setValue(VertexInterface vertex, int value);
	
	/**
	 * Renvoie longueur du chemin à partir de la racine du graphe.
	 * 
	 * @param  vertex  le sommet à atteindre
	 * @return		   la longueur du chemin jusqu'à vertex en partant de la racine
	 */
	public int getValue(VertexInterface vertex); 
	
}
