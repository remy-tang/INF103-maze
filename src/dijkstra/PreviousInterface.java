package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	
	/* Met à jour le père dans A du sommet y */
	public void updatePrevious(VertexInterface y, VertexInterface pivot);
	
	/* Donne la valeur d'un sommet, null si non initialisé */
	public VertexInterface getValue(VertexInterface vertex); 
	
	/* Donne le plus cours chemin de la racine au sommet vertex */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); 
}
