package grapheorienté;

import java.util.ArrayList;
import java.util.List;

/*
 *  <V> type pour les sommet v:vertex
 *  <E> type pour les arc E:edge
 */
public interface InterfaceGraph  {
	
	void creerGraphe(int s); // creer un graphe avec s sommets
	void associerESommet(int s, String etiq); // associer etiquette a un sommet s 
	void ajouterArc(int depart, int arrive); // ajouter arc entre sommet depart et arrive
	void associerEArc(int d,int a,  String etiq); //associer etiquette a un arcs
	void getEtiquettesommet ( int s); // renvoie etiquette d'un sommet
	void getEtiquetteArc(int d, int a); //  renvoie etiquette d'un arc
}
