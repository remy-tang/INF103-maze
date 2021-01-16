package dijkstra;
import java.util.ArrayList;

/**
 * Interface de la fonction père pour une application de l'algorithme de Dijkstra.
 * 
 * @author Remy
 */
public interface PreviousInterface {
	
	/**
	 * Met à jour le père d'un sommet du graphe.
	 * 
	 * @param y		 le sommet considéré
	 * @param pivot  le nouveau père de y
	 */
	public void updatePrevious(VertexInterface y, VertexInterface pivot);
	
	/**
	 * Renvoie le père d'un sommet, ou null s'il n'est pas initialisé.
	 * 
	 * @param  vertex le sommet considéré
	 * @return        le père de vertex, ou null s'il n'est pas défini
	 */
	public VertexInterface getPrevious(VertexInterface vertex); 
	
	/**
	 * Renvoie le plus court chemin de la racine à un sommet. 
	 * Le chemin renvoyé commence par le sommet d'arrivée et remonte jusqu'à la racine.
	 * 
	 * @param  vertex le sommet d'arrivée
	 * @return        le plus court chemin de la racine à un sommet
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); 
}
