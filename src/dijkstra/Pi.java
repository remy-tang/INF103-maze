package dijkstra;
import java.util.Hashtable;

public class Pi implements PiInterface {

	private Hashtable<VertexInterface, Integer> piTable = new Hashtable<VertexInterface, Integer>();
	
	public void setValue(VertexInterface vertex, int value) {
		piTable.put(vertex, value);
	}

	public int getValue(VertexInterface vertex) {
		return piTable.get(vertex);
	}

}
