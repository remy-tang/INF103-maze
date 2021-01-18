package dijkstra;

import java.util.ArrayList;

/**
 * Classe qui implémente l'algorithme de Dijkstra.
 * 
 * @author Remy
 */
public class Dijkstra {
	
	/**
	 * Renvoie la fonction père obtenue après application de l'algorithme de Dijkstra.
	 * 
	 * @param  g  le graphe
	 * @param  r  la racine du graphe
	 * @return 	  la fonction père obtenue après application de Dijkstra
	 */
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		/* Initialisation des paramètres */
		ASetInterface A = new ASet();
		PiInterface Pi = new Pi();
		PreviousInterface previous = new Previous();
		
		ArrayList<VertexInterface> vertexList = g.getAllVertices();
		int verticesCount = vertexList.size();
		VertexInterface pivot = r;
		VertexInterface nextPivot = r;
		Pi.setValue(r, 0);
		
		/* Initialisation de la fonction Pi pour tous les sommets autres que la racine */
		for (VertexInterface vertex : vertexList) {
			if (vertex != r)
				Pi.setValue(vertex, Integer.MAX_VALUE);
		}
		
		/* Mise à jour des valeurs de Pi et de la fonction père 
		 * pour tous les successeurs du pivot */
		for (int j = 1; j < verticesCount; j++) {
			ArrayList<VertexInterface> pivotSuccessors = g.getSuccessors(pivot);
			
			for (VertexInterface y : pivotSuccessors) {
				if (!A.isInA(y)) {
					if (Pi.getValue(y) + g.getWeight(pivot, y) < Pi.getValue(y)) {
						Pi.setValue(y, Pi.getValue(pivot) + g.getWeight(pivot, y));
						previous.updatePrevious(y, pivot);
					}
				}
			}
			/* Recherche du prochain pivot par le minmum de Pi pour les sommets 
			 * qui ne sont pas encore dans A. */
			int minPi = Integer.MAX_VALUE;
			for (VertexInterface vertex : vertexList) {
				if (!A.isInA(vertex)) {
					if (Pi.getValue(vertex) < minPi) {
						minPi = Pi.getValue(vertex);
						nextPivot = vertex;
					}
				}
			}
			pivot = nextPivot;
			A.addVertex(pivot);
		}
		
		return previous;
	}
}
