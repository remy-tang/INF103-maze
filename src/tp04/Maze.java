package tp04;
import java.util.ArrayList;

public class Maze implements GraphInterface {
	
	private MBox[][] Boxes ;
	private final int xMax;				/* Indice maximum selon les x */
	private final int yMax;				/* Indice maximum selon les y */
	
	public Maze(int xMax, int yMax) {
		this.xMax = xMax ;
		this.yMax = yMax ;
	}
	
    public ArrayList<VertexInterface> getAllVertices() {
    	
    	ArrayList<VertexInterface> boxesList = new ArrayList<VertexInterface>() ;
    	
    	for (int i = 0; i < xMax+1; i++) {
    		for (int j = 0; j < yMax+1; j++) {
    			boxesList.add(Boxes[i][j]) ;
    		}
    	}
    	return boxesList ;
    }
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		MBox box = (MBox)vertex ;
		int x = box.getXPos();
		int y = box.getYPos();
		ArrayList<VertexInterface> neighbourList = new ArrayList<VertexInterface>() ; 
		
		return neighbourList ;	}

    public int getWeight(VertexInterface src,VertexInterface dst) {
    	return 1;
    }
}
