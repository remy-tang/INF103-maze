package tp04;

public interface ASetInterface {
	void initialise(Vertex root) ; 		/* Initialise A avec la racine */
	bool isInA(Vertex currentVertex) ; 	/* Indique si le sommet currentVertex est dans A */
	void addVertex(Vertex newVertex) ; 	/* Ajoute un sommet du graphe (qui n'est pas encore ajouté) dans A */
}