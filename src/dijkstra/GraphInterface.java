package dijkstra;
import java.util.ArrayList ;


public interface GraphInterface {
	
	/* Donne l'ArrayList de tous les sommets du labyrinthe */
	public ArrayList<VertexInterface> getAllVertices();
	
	/* Donne l'ArrayList des sommets liés à currentVertex */
    public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);
    
    /* Donne le poids de l'arc (src,dst) */
    public int getWeight(VertexInterface src,VertexInterface dst);
}
