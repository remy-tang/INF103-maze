package tp04;

public interface ASetInterface {
	boolean isInA(VertexInterface currentVertex) ; 	/* Indique si le sommet currentVertex est dans A */
	void addVertex(VertexInterface newVertex) ; 	/* Ajoute un sommet du graphe (qui n'est pas encore ajouté) dans A */
}