package dijkstra;
import java.util.ArrayList;

public interface PreviousInterface {
	
	/* Met � jour le p�re du sommet y dans l'ensemble A par pivot*/
	public void updatePrevious(VertexInterface y, VertexInterface pivot);
	
	/* Donne le p�re d'un sommet, ou null si non-initialis� */
	public VertexInterface getPrevious(VertexInterface vertex); 
	
	/* Donne le plus court chemin de la racine au sommet vertex en remontant
	   � partir de l'arriv�e jusqu'au d�part */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex); 
}
