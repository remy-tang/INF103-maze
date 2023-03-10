package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Classe qui repr?sente la fonction p?re utilis?e dans l'algorithme de Dijkstra.
 * 
 * @author Remy
 */
public class Previous implements PreviousInterface {

	private Hashtable<VertexInterface, VertexInterface> previousTable = new Hashtable<VertexInterface, VertexInterface>();
	
	public void updatePrevious(VertexInterface y, VertexInterface pivot) {
		previousTable.put(y, pivot);
	}

	public VertexInterface getPrevious(VertexInterface vertex) {
		return previousTable.get(vertex);
	}

	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		ArrayList<VertexInterface> vertexList = new ArrayList<VertexInterface>();
		VertexInterface currentVertex = vertex;
		
		while (currentVertex != null && currentVertex.getLabel() != "DBox") {
			vertexList.add(currentVertex);
			currentVertex = getPrevious(currentVertex);
		}
		
		if (currentVertex != null) {
			vertexList.add(currentVertex);
		} else {
			System.out.println("No solution found, please check the maze.");
		}
		
		return vertexList;
	}

}
