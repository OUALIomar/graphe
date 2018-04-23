package grapheorienté;

import java.util.ArrayList;
import java.util.List;

/*
 *  <V> type pour les sommet v:vertex
 *  <E> type pour les arc E:edge
 */
public interface InterfaceGraph <V> {
	
	 public int nombresommet (); // nombre de sommet
	 /*
	  * revoie un sommet pour un indice donné
	  */
	 public Vertex<V> getVertex(int ind);
	/*
	 * ajouter un arc 
	 */
	 public void addEdge(Edge e);
	 /*
	  * ajouter etiquette a un sommet 
	  */
	 public void addEtiquetteToVertex(V e, String label);
	 /*
	  * ajouter une etiquette a un arc
	  */
	 public void addEtiquetteToEdge(Edge e, String label);
	 /*
	  * retourner l'etiquette d'un sommet
	  */
	 public String getLabelVertex(V e);
	 /*
	  * retourner l'etiquete d'un arc
	  */
	 public String getLabelEdge (Edge e);
	 /*
	  * lire un graph
	  */
	 public void readGraph();
	 /*
	  * save graph
	  */
	 public void saveGraph();
	 
	
}
