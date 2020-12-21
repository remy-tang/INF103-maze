package tp04;
import java.util.ArrayList ;


public interface GraphInterface {
	public ArrayList<VertexInterface> getAllVertices(); // Donne l'ArrayList de tous les sommets du labyrinthe
    public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex); // Donne l'ArrayList des sommets liés à currentVertex
    public int getWeight(VertexInterface src,VertexInterface dst); // Donne le poids de l'arc (src,dst)
}
