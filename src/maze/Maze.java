package maze;

import java.io.*;
import java.util.ArrayList;
import dijkstra.*;

/**
 * 
 * 
 * @author Remy
 */
public class Maze implements GraphInterface {
	private MBox[][] boxes;
	private final int nMax;				/* Indice maximum selon les lignes */
	private final int pMax;				/* Indice maximum selon les colonnes */
	private MBox DBox;
	private MBox ABox;
	
	public Maze(int nMax, int pMax) {
		boxes = new MBox[nMax+1][pMax+1];
		this.nMax = nMax;
		this.pMax = pMax;
	}
	
    public ArrayList<VertexInterface> getAllVertices() {
    	ArrayList<VertexInterface> boxesList = new ArrayList<VertexInterface>() ;
    	
    	for (int i = 0; i < nMax+1; i++) {
    		for (int j = 0; j < pMax+1; j++) {
    			boxesList.add(boxes[i][j]);
    		}
    	}
    	return boxesList;
    }
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		MBox box = (MBox) vertex ;
		int n = box.getNPos();
		int p = box.getPPos();
		ArrayList<VertexInterface> neighbourList = new ArrayList<VertexInterface>() ; 
		
		if ((n != 0) && (boxes[n-1][p].getLabel() != "WBox"))
			neighbourList.add(boxes[n-1][p]);
		if ((n != nMax) && (boxes[n+1][p].getLabel() != "WBox"))
			neighbourList.add(boxes[n+1][p]);
		if ((p != 0) && (boxes[n][p-1].getLabel() != "WBox"))
			neighbourList.add(boxes[n][p-1]);
		if ((p != pMax) && (boxes[n][p+1].getLabel() != "WBox"))
			neighbourList.add(boxes[n][p+1]);
			
		return neighbourList;	
	}

	
    public int getWeight(VertexInterface src,VertexInterface dst) {
    	return 1;
    }
    
    public static final int countLines(String fileName) {
    	FileReader fr = null;
    	BufferedReader br = null;
        int lineCount = 0;
        
        try {
        	fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		
    		while (br.readLine() != null) 
    			lineCount++;
    		
    		return lineCount;
    	} catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
        	try {
        	br.close();
        	fr.close();
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
    }
    
    public static final int firstLineLen(String fileName) {
    	FileReader fr = null;
    	BufferedReader br = null;
    	
        try {
        	fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		
    		String firstLine = br.readLine();
    		
    		return firstLine.length();
    	} catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
        	try {
        	br.close();
        	fr.close();
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
    }
    
    public final int checkLinesLen(String fileName, int pMax) {
    	FileReader fr = null;
    	BufferedReader br = null;
        
        try {
        	fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		int lineLen;
    		String currentLine = br.readLine();
    		
    		if (currentLine == null)
    			return 0;
    		
    		while (currentLine != null) {
    			lineLen = currentLine.length() - 1;
    			if (lineLen != pMax)
    				return lineLen;
    			currentLine = br.readLine();
    		}
    		return pMax;
    	} catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
        	try {
        	br.close();
        	fr.close();
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        }
    }
    

    public final void initFromTextFile(String fileName) throws MazeReadingException {
    	FileReader fr = null;
    	BufferedReader br = null;
    	
    	try {
    		fr = new FileReader("data/" + fileName + ".txt");
    		br = new BufferedReader(fr);
    		String currentLine = br.readLine();
    		
			/* V�rification du format des lignes */
    		int lineLen = checkLinesLen(fileName, pMax);
			if (lineLen != pMax) 
				throw new MazeReadingException(fileName, 0, 
											   "Wrong size along horizontal axis "
											   + "while reading data/" 
										       + fileName + ".txt : " 
											   + lineLen + ". Expected: " + pMax);
    		
			/* Initialisation */
    		int n = 0;
    		int dBoxFlag = 0;
    		int aBoxFlag = 0;
    		while (n<=nMax) {
    			
    			for (int p=0; p<=pMax; p++) {
    				String currentLetter = Character.toString(currentLine.charAt(p));
    				currentLetter = currentLetter.toUpperCase();
    				
    				/* On suppose qu'il n'y a qu'un D et qu'un A dans fileName */
    				if (currentLetter.equals("E")) {
    					boxes[n][p] = new EBox(n,p);
    				} else if (currentLetter.equals("W")) {
    					boxes[n][p] = new WBox(n,p);
    				} else if (currentLetter.equals("D")) {
    					if (dBoxFlag == 0) {
    						boxes[n][p] = new DBox(n,p);
    						DBox = boxes[n][p];
    						dBoxFlag = 1;
    					} else {
    						throw new MazeReadingException(fileName, 0, 
									   "Multiple characters 'D' detected. "
									   + "Only one authorized. "
									   + "Please check the maze at "
									   + "data/" + fileName + ".txt");
    					}
    				} else if (currentLetter.equals("A")) {
    					if (aBoxFlag == 0) {
    						boxes[n][p] = new ABox(n,p);
    						ABox = boxes[n][p];
    					} else {
    						throw new MazeReadingException(fileName, 0, 
									   "Multiple characters 'A' detected. "
									   + "Only one authorized. "
									   + "Please check the maze at "
									   + "data/" + fileName + ".txt");
    					}
    				} else {
    					throw new MazeReadingException(fileName, 91, 
    												   "Wrong character: " + currentLetter 
    												   + ", expected 'E','W','D', or 'A'.");
    				}
    			}
    			currentLine = br.readLine();
    			n++;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			br.close();
    			fr.close();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public final void saveToTextFile(String fileName, String solvedMazeString) {
    	FileOutputStream fos = null;
    	PrintWriter pw = null;
    	
    	try {
    		String filePath = "data/" + fileName + ".txt";
    		fos = new FileOutputStream(filePath);
    		pw = new PrintWriter(fos);
    		pw.print(solvedMazeString);
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			pw.close();
    			fos.close();
    		} catch (Exception e) {
    		e.printStackTrace();
    		}
    	}
    }
    
    /* Permet d'indiquer que la box fait partie du plus court chemin */
    private final void updateBox(int i, int j) {
    	boxes[i][j].updateStatus();
    }
    
    public final Maze solvedMaze() {
    	Maze solvedMaze = this;
    	PreviousInterface solution = Dijkstra.dijkstra(this, this.DBox);
		ArrayList<VertexInterface> shortestPath = solution.getShortestPathTo(this.ABox);
		
		for (VertexInterface vertex : shortestPath) {
			int i = ((MBox)vertex).getNPos();
			int j = ((MBox)vertex).getPPos();
			solvedMaze.updateBox(i, j);
		}
		return solvedMaze;
    }

    /* Cr�ation du string du labyrinthe r�solu */
    public String solvedMazeToString() {
		String solvedMazeString = "";
		int pathLen = 0;
		int solved = 0;
		
		for (int i = 0; i <= nMax; i++) {
			String newline = "";
			
			for (int j = 0; j <= pMax; j++) {
				if (boxes[i][j].getLabel().equals("EBox")) {
					if (boxes[i][j].getStatus() == 1) {
						newline += "."; 
						pathLen++;
						solved = 1;
					} else {
						newline += "E";
					}
				} else if (boxes[i][j].getLabel().equals("WBox")) {
					newline += "W";
				} else if (boxes[i][j].getLabel().equals("DBox")) {
					newline += "D";
				} else if (boxes[i][j].getLabel().equals("ABox")) {
					newline += "A";
					pathLen++;
				}
			}
			solvedMazeString += newline + "\n";
		}
		
		if (solved == 1) {
			solvedMazeString += "A solution was found!\n";
			solvedMazeString += "Path length : " + pathLen;
		}
		
    	return solvedMazeString;
    }
}
