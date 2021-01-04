package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	public void updatePrevious(VertexInterface y, VertexInterface pivot); /* Met à jour le père dans A du sommet y */
	
	public VertexInterface getValue(VertexInterface vertex); /* Donne la valeur d'un sommet, null si non initialisé */
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); /* Donne le plus cours chemin de la racine au sommet vertex */
}
