package dijkstra;

public interface ASetInterface {
	
	/* Indique si le sommet vertex est dans A (vrai : 1, faux : 0) */
	public boolean isInA(VertexInterface vertex); 	
	
	/* Ajoute un sommet du graphe (qui n'est pas encore ajouté) dans A */
	public void addVertex(VertexInterface vertex); 	
}