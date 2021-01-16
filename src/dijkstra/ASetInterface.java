package dijkstra;

/**
 * Interface d'un ensemble pour une application de l'algorithme de Dijkstra.
 * 
 * @author Remy
 */
public interface ASetInterface {
	
	/**
	 * Indique si le sommet vertex est dans A.
	 *  
	 * @param  vertex  le sommet consid�r�
	 * @return         true ou false
	 */
	public boolean isInA(VertexInterface vertex); 	
	
	/**
	 * Ajoute un sommet du graphe (qui n'est pas encore ajout�) dans l'ensemble A.
	 * 
	 * @param vertex le sommet � ajouter
	 */
	public void addVertex(VertexInterface vertex); 	
}