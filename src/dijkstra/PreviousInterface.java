package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	public void updatePrevious(VertexInterface y, VertexInterface pivot); /* Met � jour le p�re dans A du sommet y */
	
	public VertexInterface getValue(VertexInterface vertex); /* Donne la valeur d'un sommet, null si non initialis� */
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); /* Donne le plus cours chemin de la racine au sommet vertex */
}
