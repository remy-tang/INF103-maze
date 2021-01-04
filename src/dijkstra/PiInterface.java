package dijkstra;

public interface PiInterface {
	
	/* Assigne la valeur value au sommet vertex */
	public void setValue(VertexInterface vertex, int value);
	
	/* Donne la valeur pi(vertex)  */
	public int getValue(VertexInterface vertex); 
	
}
