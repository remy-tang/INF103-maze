package tp04;
import java.io.*;
import java.util.ArrayList;



public class Maze implements GraphInterface {
	
	private MBox[][] boxes;
	private final int xMax;				/* Indice maximum selon les x */
	private final int yMax;				/* Indice maximum selon les y */
	
	public Maze(int xMax, int yMax) {
		boxes = new MBox[xMax][yMax];
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
    public ArrayList<VertexInterface> getAllVertices() {
    	
    	ArrayList<VertexInterface> boxesList = new ArrayList<VertexInterface>() ;
    	
    	for (int i = 0; i < xMax+1; i++) {
    		for (int j = 0; j < yMax+1; j++) {
    			boxesList.add(boxes[i][j]);
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
			neighbourList.add(boxes[x-1][y]);
		if (x != xMax)
			neighbourList.add(boxes[x+1][y]);
		if (y != 0)
			neighbourList.add(boxes[x][y-1]);
		if (y != yMax)
			neighbourList.add(boxes[x][y+1]);
			
		return neighbourList;	}

    public int getWeight(VertexInterface src,VertexInterface dst) {
    	return 1;
    }
    
    public final void initFromTextFile(String fileName) 
    		throws MazeReadingException {
    	
    	FileReader fr = null;
    	BufferedReader br = null;
    	try {
    		fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		
    		int i = 0; // i correspond à xPos
    		int hasNext = 1;
    				
    		while (hasNext == 1) {

    			String currentLine = br.readLine();
    			
    			if (currentLine == null) {
    				hasNext = 0;
    			    break;
    			    }
    			
    			int lineLen = currentLine.length();
    			if (lineLen != xMax)
    				throw new MazeReadingException(fileName, 91, "Wrong maze size along x axis: " + lineLen + ", expected " + xMax);
    			
    			for (int j=0; j<lineLen; j++) { // j correspond à yPos
    				String currentLetter = Character.toString(currentLine.charAt(j)).toUpperCase();
    				
    				if (currentLetter.equals("-1"))
    					hasNext = 0;
    				else if (currentLetter.equals("\n"))
    					i += 1;
    				else if (currentLetter.equals("E"))
    					boxes[i][j] = new EBox(i,j);
    				else if (currentLetter.equals("W"))
    					boxes[i][j] = new WBox(i,j);
    				else if (currentLetter.equals("D")) // On suppose qu'il n'y a qu'un D et qu'un A dans fileName
    					boxes[i][j] = new DBox(i,j);
    				else if (currentLetter.equals("A"))
    					boxes[i][j] = new ABox(i,j);
    				else
    					throw new MazeReadingException(fileName, 91, "Wrong character: " + currentLetter + ", expected 'E','W','D','A'.");
    			}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		try {
    			br.close();
    			fr.close();}
    		catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
}
