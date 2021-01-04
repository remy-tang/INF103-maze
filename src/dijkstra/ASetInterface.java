package dijkstra;

public interface ASetInterface {
	
	/* Indique si le sommet currentVertex est dans A */
	public boolean isInA(VertexInterface vertex); 	
	
	/* Ajoute un sommet du graphe (qui n'est pas encore ajouté) dans A */
	public void addVertex(VertexInterface vertex); 	
}