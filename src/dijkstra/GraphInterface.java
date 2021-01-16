package dijkstra;

import java.util.ArrayList ;

/**
 * Interface du graphe pour une application de l'algorithme de Dijkstra.
 * 
 * @author Remy
 */
public interface GraphInterface {
	
	/**
	 * Renvoie une ArrayList qui contient tous les sommets du graphe.
	 * 
	 * @return l'ArrayList de tous les sommets du graphe
	 */
	public ArrayList<VertexInterface> getAllVertices();
	
	/**
	 * Renvoie l'ArrayList des sommets qui succèdent à un sommet.
	 * 
	 * @param  vertex le sommet considéré
	 * @return        l'ArrayList des sommets qui succèdent à vertex
	 */
    public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);
    
    /**
     * Renvoie le poids de l'arc.
     * 
     * @param  src  le sommet de départ de l'arc
     * @param  dst  le sommet d'arrivée de l'arc
     * @return      le poids de l'arc
     */
    public int getWeight(VertexInterface src,VertexInterface dst);
}
