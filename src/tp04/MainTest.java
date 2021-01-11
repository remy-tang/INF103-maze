package tp04;

import maze.*;
import dijkstra.*;
import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		
		/* Sauvegarde labyrinthe */
//		Maze SolvedMaze = new Maze(9,9);
//		try {maze.saveToTextFile("solvedLabyrinthe");}
//		catch (Exception e) {
//			e.printStackTrace();
		
		/* Initialisation labyrinthe */
		Maze maze = new Maze(9,9);
		try {maze.initFromTextFile("labyrinthe");}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		PreviousInterface previous;
		ArrayList<VertexInterface> boxes = maze.getAllVertices();
		VertexInterface DBox = boxes.get(0), ABox = boxes.get(0);
		for (VertexInterface box : boxes) {
			if (box.getLabel() == "DBox")
				DBox = box;
			else if (box.getLabel() == "ABox")
				ABox = box;
		}
		previous = Dijkstra.dijkstra(maze,DBox);
			
		ArrayList<VertexInterface> shortestPath = previous.getShortestPathTo(ABox);
		
		for (VertexInterface vertex : shortestPath) {
//			if (vertex.getLabel() == "EBox") {
				int x=((MBox)vertex).getXPos();
				int y=((MBox)vertex).getYPos();
				System.out.println(x + "|" +y);
				
		
		}
		
		
		}
	}
