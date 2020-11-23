package tp04;

public interface GraphInterface {
	ArrayList<Vertex> isLinkedTo(Vertex currentVertex) ; /* Donne l'ArrayList des sommets li�s � currentVertex */
	int arcWeight(Vertex x, Vertex y); /* Donne le poids de l'arc (x,y) */
}
