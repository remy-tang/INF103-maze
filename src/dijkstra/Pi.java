package dijkstra;
import java.util.Hashtable;

/**
 * Classe qui repr�sente la fonction Pi utilis�e dans l'algorithme de Dijkstra.
 * 
 * @author Remy
 */
public class Pi implements PiInterface {

	private Hashtable<VertexInterface, Integer> piTable = new Hashtable<VertexInterface, Integer>();
	
	public void setValue(VertexInterface vertex, int value) {
		piTable.put(vertex, value);
	}

	public int getValue(VertexInterface vertex) {
		return piTable.get(vertex);
	}

}
