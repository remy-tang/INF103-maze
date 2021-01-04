package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Previous implements PreviousInterface {

	private Hashtable<VertexInterface, VertexInterface> previousTable = new Hashtable<VertexInterface, VertexInterface>();
	
	public void updatePrevious(VertexInterface y, VertexInterface pivot) {
		previousTable.put(y,pivot);
	}

	public VertexInterface getValue(VertexInterface vertex) {
		return previousTable.get(vertex);
	}

	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		ArrayList<VertexInterface> vertexList = new ArrayList<VertexInterface>();
		VertexInterface currentVertex = vertex;
		
		while (currentVertex.getLabel() != "DBox") {
			vertexList.add(currentVertex);
			currentVertex = getValue(currentVertex);
		}
		vertexList.add(currentVertex);
		return vertexList;
	}

}
