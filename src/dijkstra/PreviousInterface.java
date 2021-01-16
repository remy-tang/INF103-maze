package dijkstra;
import java.util.ArrayList;

/**
 * Interface de la fonction p�re pour une application de l'algorithme de Dijkstra.
 * 
 * @author Remy
 */
public interface PreviousInterface {
	
	/**
	 * Met � jour le p�re d'un sommet du graphe.
	 * 
	 * @param y		 le sommet consid�r�
	 * @param pivot  le nouveau p�re de y
	 */
	public void updatePrevious(VertexInterface y, VertexInterface pivot);
	
	/**
	 * Renvoie le p�re d'un sommet, ou null s'il n'est pas initialis�.
	 * 
	 * @param  vertex le sommet consid�r�
	 * @return        le p�re de vertex, ou null s'il n'est pas d�fini
	 */
	public VertexInterface getPrevious(VertexInterface vertex); 
	
	/**
	 * Renvoie le plus court chemin de la racine � un sommet. 
	 * Le chemin renvoy� commence par le sommet d'arriv�e et remonte jusqu'� la racine.
	 * 
	 * @param  vertex le sommet d'arriv�e
	 * @return        le plus court chemin de la racine � un sommet
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); 
}
