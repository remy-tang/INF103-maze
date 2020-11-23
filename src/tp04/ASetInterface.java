package tp04;

public interface ASetInterface {
	void initialise(Vertex root) ; /* Initialise A avec la racine */
	void showVertices() ; /* Donne la liste des sommets du graphe dans A */
	void addVertex(Vertex newVertex) ; /* Ajoute un sommet du graphe (qui n'est pas encore ajouté) dans A */
}