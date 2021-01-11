package dijkstra;
import java.util.ArrayList;
import maze.*;


public class Dijkstra {
	
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		
		ASetInterface A = new ASet();
		PiInterface Pi = new Pi();
		PreviousInterface previous = new Previous();
		ArrayList<VertexInterface> vertexList = g.getAllVertices();
		int n = vertexList.size();
		VertexInterface pivot = r;
		VertexInterface nextPivot = r;
		Pi.setValue(r, 0);
		
		for (VertexInterface vertex : vertexList) {
			if (vertex != r)
				Pi.setValue(vertex, Integer.MAX_VALUE);
		}
		
		for (int j=1; j<n; j++) {
			ArrayList<VertexInterface> pivotSuccessors = g.getSuccessors(pivot);
			
			for (VertexInterface y : pivotSuccessors) {
				if (!A.isInA(y)) {
					if (Pi.getValue(y) + g.getWeight(pivot, y) < Pi.getValue(y)) {
						Pi.setValue(y, Pi.getValue(pivot) + g.getWeight(pivot, y));
						previous.updatePrevious(y, pivot);
					}
				}
			}
			
			int minPi = Integer.MAX_VALUE;
			
			for (VertexInterface vertex : vertexList) {
				if (!A.isInA(vertex) && ((MBox)vertex).getLabel() == "EBox") {
					if (Pi.getValue(vertex) < minPi) {
						minPi = Pi.getValue(vertex);
						nextPivot = vertex;
					}
				}
			}
			
			pivot = nextPivot;
			A.addVertex(pivot);
		}
		
		return previous;
	}
}
