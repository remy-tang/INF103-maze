package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	
	/* Met à jour le père du sommet y dans l'ensemble A par pivot*/
	public void updatePrevious(VertexInterface y, VertexInterface pivot);
	
	/* Donne le père d'un sommet, ou null si non-initialisé */
	public VertexInterface getPrevious(VertexInterface vertex); 
	
	/* Donne le plus court chemin de la racine au sommet vertex en remontant
	   à partir de l'arrivée jusqu'au départ */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); 
}
