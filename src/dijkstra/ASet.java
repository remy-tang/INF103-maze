package dijkstra;
import java.util.HashSet;


public class ASet implements ASetInterface {
	
	private HashSet<VertexInterface> A = new HashSet<VertexInterface>();

	public boolean isInA(VertexInterface vertex) {
		if (A.contains(vertex))
			return true;
		return false;
	}

	public void addVertex(VertexInterface vertex) {
		A.add(vertex);
	}

}
