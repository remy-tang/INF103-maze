package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	
	/* Met � jour le p�re dans A du sommet y */
	public void updatePrevious(VertexInterface y, VertexInterface pivot);
	
	/* Donne la valeur d'un sommet, null si non initialis� */
	public VertexInterface getValue(VertexInterface vertex); 
	
	/* Donne le plus cours chemin de la racine au sommet vertex */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); 
}
