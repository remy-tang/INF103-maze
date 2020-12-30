package tp04;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;



public class Maze implements GraphInterface {
	
	private MBox[][] Boxes;
	private final int xMax;				/* Indice maximum selon les x */
	private final int yMax;				/* Indice maximum selon les y */
	
	public Maze(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
    public ArrayList<VertexInterface> getAllVertices() {
    	
    	ArrayList<VertexInterface> boxesList = new ArrayList<VertexInterface>() ;
    	
    	for (int i = 0; i < xMax+1; i++) {
    		for (int j = 0; j < yMax+1; j++) {
    			boxesList.add(Boxes[i][j]);
    		}
    	}
    	return boxesList;
    }
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		
		MBox box = (MBox)vertex ;
		int x = box.getXPos();
		int y = box.getYPos();
		ArrayList<VertexInterface> neighbourList = new ArrayList<VertexInterface>() ; 
		
		if (x != 0)
			neighbourList.add(Boxes[x-1][y]);
		if (x != xMax)
			neighbourList.add(Boxes[x+1][y]);
		if (y != 0)
			neighbourList.add(Boxes[x][y-1]);
		if (y != yMax)
			neighbourList.add(Boxes[x][y+1]);
			
		return neighbourList;	}

    public int getWeight(VertexInterface src,VertexInterface dst) {
    	return 1;
    }
    
    public final void initFromTextFile(String fileName) {
    	
    	try {
    		FileReader fr = new FileReader(fileName + ".txt");
    		BufferedReader br = new BufferedReader(fr);
    		Scanner sc = new Scanner(br);
    		
    		int i = 0;
    		while (sc.hasNextLine()) {
    			String currentLine = sc.nextLine();
    			int lineLen = currentLine.length();
    			
    			for (int j=0; j<lineLen; j++) {
    				String currentLetter = Character.toString(currentLine.charAt(j));
    				if (currentLetter.equals("E"))
    					Boxes[i][j] = EBox(i,j);
    				else if (currentLetter.equals("W"))
    					Boxes[i][j] = WBox(i,j);
    				else if (currentLetter.equals("D")) // On suppose qu'il n'y a qu'un D et qu'un A dans fileName
    					Boxes[i][j] = DBox(i,j);
    				else if (currentLetter.equals("A"))
    					Boxes[i][j] = ABox(i,j);
    			}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		sc.close();
    		br.close();
    		fr.close();
    	}
    }
}
