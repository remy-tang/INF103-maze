package dijkstra;

public interface ASetInterface {
	public boolean isInA(VertexInterface vertex); 	/* Indique si le sommet currentVertex est dans A */
	public void addVertex(VertexInterface vertex); 	/* Ajoute un sommet du graphe (qui n'est pas encore ajouté) dans A */
}