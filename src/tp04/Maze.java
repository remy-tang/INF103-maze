package tp04;
import java.util.ArrayList;

public class Maze implements GraphInterface {
	
	private MBox Boxes[][];
	int xMax;				/* Indice maximum selon les x*/
	int yMax;				/* Indice maximum selon les y*/
	
	public void addBox(MBox box) {

		int x = box.getXPos();
		int y = box.getYPos();
		
		this.Boxes[x][y] = box;
	}
	
	public ArrayList<MBox> isLinkedTo(Vertex box) {
		
		int x = box.getXPos();
		int y = box.getYPos();
		ArrayList<MBox> neighbourList = new ArrayList<MBox>() ; 
		
		neighbourList.add(Boxes[x][y+1]); //traiter les box limites autrement
		neighbourList.add(Boxes[x+1][y]);
		neighbourList.add(Boxes[x][y-1]);
		neighbourList.add(Boxes[x-1][y]);
		
		return neighbourList ;	}
}
