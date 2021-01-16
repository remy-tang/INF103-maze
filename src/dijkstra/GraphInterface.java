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
	 * Renvoie l'ArrayList des sommets qui succ�dent � un sommet.
	 * 
	 * @param  vertex le sommet consid�r�
	 * @return        l'ArrayList des sommets qui succ�dent � vertex
	 */
    public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);
    
    /**
     * Renvoie le poids de l'arc.
     * 
     * @param  src  le sommet de d�part de l'arc
     * @param  dst  le sommet d'arriv�e de l'arc
     * @return      le poids de l'arc
     */
    public int getWeight(VertexInterface src,VertexInterface dst);
}
