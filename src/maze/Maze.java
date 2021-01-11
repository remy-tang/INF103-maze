package maze;
import java.io.*;
import java.util.ArrayList;

import dijkstra.*;

public class Maze implements GraphInterface {
	
	private MBox[][] boxes;
	private final int xMax;				/* Indice maximum selon les x */
	private final int yMax;				/* Indice maximum selon les y */
	private MBox DBox;
	private MBox ABox;
	
	public Maze(int xMax, int yMax) {
		boxes = new MBox[xMax+1][yMax+1];
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
    		
    		int i = 0; // i parcourt les lignes
    		String currentLine = br.readLine();
    				
    		while (currentLine != null && i<=xMax) {
    			int lineLen = currentLine.length() - 1;
    			
    			if (lineLen != xMax) // Labyrinthes supposés carrés
    				throw new MazeReadingException(fileName, 91, "Wrong maze size along x axis: " + lineLen + ". Expected: " + xMax);
    			
    			for (int j=0; j<=yMax; j++) { // j parcourt les colonnes
    				String currentLetter = Character.toString(currentLine.charAt(j)).toUpperCase();
    				
    				if (currentLetter.equals("E"))
    					boxes[i][j] = new EBox(i,j);
    				else if (currentLetter.equals("W"))
    					boxes[i][j] = new WBox(i,j);
    				else if (currentLetter.equals("D")) { // On suppose qu'il n'y a qu'un D et qu'un A dans fileName pour l'instant
    					boxes[i][j] = new DBox(i,j);
    					DBox = boxes[i][j];
    				}
    				else if (currentLetter.equals("A")) {
    					boxes[i][j] = new ABox(i,j);
    					ABox = boxes[i][j];
    				}
    				else
    					throw new MazeReadingException(fileName, 91, "Wrong character: " + currentLetter + ", expected 'E','W','D','A'.");
    			}
    			currentLine = br.readLine();
    			i ++;
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
    
    public final void saveToTextFile(String fileName) {
    	
    	FileReader fr = null;
    	BufferedReader br = null;
    	FileOutputStream fos = null;
    	PrintWriter pw = null;
    	
    	try {
    		fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		fos = new FileOutputStream("data/labyrinthe2.txt");
    		pw = new PrintWriter(fos);
    		
    		String currentLine = br.readLine();
    		while (currentLine != null) {
    			pw.println(currentLine);
    			currentLine = br.readLine();
    		}
    			
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			br.close();
    			fr.close();
    			pw.close();
    			fos.close();
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	}
    }
    
    private void updateBox(Maze maze, int i, int j) {
    	maze.boxes[i][j].updateStatus();
    }
    
    public String solvedMazeString(Maze maze) { //weird thing for arguments here  : maze.func(maze)....
    	
    	Maze solvedMaze = maze;
    	PreviousInterface solution;
    	solution = Dijkstra.dijkstra(maze,DBox);
		ArrayList<VertexInterface> shortestPath = solution.getShortestPathTo(ABox);
		String solvedMazeString = "";
		
		for (VertexInterface vertex : shortestPath) {
			if (((MBox)vertex).getLabel().equals("EBox")) {
				int i=((MBox)vertex).getXPos();
				int j=((MBox)vertex).getYPos();
				updateBox(solvedMaze,i,j);
			}
		}
		
		for (int i=0; i<=xMax; i++) {
			String newline = "";
			for (int j=0; j<=yMax; j++) {
				if (solvedMaze.boxes[i][j].getLabel().equals("EBox")) {
					if (solvedMaze.boxes[i][j].getStatus() == 1)
						newline += "*";
					else
						newline += "E";
				}
				else if (solvedMaze.boxes[i][j].getLabel().equals("WBox"))
					newline += "W";
				else if (solvedMaze.boxes[i][j].getLabel().equals("DBox"))
					newline += "D";
				else if (solvedMaze.boxes[i][j].getLabel().equals("ABox"))
					newline += "A";
			}
			solvedMazeString += newline + "\n";
		}
		
    	return solvedMazeString;
    }
}
