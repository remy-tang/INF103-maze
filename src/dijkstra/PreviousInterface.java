package dijkstra;

public interface PreviousInterface {
	void updatePrevious(VertexInterface y, VertexInterface pivot); /* Met à jour le père dans A du sommet y */
}
