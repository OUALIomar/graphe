package grapheorienté;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph implements InterfaceGraph {
	protected int nbsommet;
	//protected ArrayList<HashMap<Integer, String> > successeurs;
	protected int tailleGraphe = 0;
	protected int nb_arcs = 0;
	protected int [][] graphe;
	protected HashMap<Integer, String> sommets = null;
	protected HashMap<Integer, String>  arcs; // identifier par sommet depart et arrive 
	HashMap<String, String> etiquetteArcs; // hashmap contiens les etiquette associer a un arc
	
	/*
	 * (non-Javadoc)
	 * @see grapheorienté.InterfaceGraph#creerGraphe(int)
	 */
	public void creerGraphe(int nbsommet) {
		int i, j;
		System.out.println( "creation d'un graph avec  : " + nbsommet + "  sommet");
		
		if (nbsommet > 1) {
			graphe = new int [nbsommet][nbsommet];
			for ( i = 0; i < nbsommet; i++) {
				for (j = 0; j < nbsommet; j++) {
					graphe[i][j] = 0;
					
				}
			}
			
		}
		// le bloc est pour l'affichage 
		for ( i = 0; i < nbsommet; i++) {
			for (j = 0; j < nbsommet; j++) {
				System.out.print(graphe[i][j] + " | ");
				
			} System.out.println();
		}
		
		
		
	}
	/*
	 * 
	 * @see grapheorienté.InterfaceGraph#associerESommet(int, java.lang.String)
	 * une méthode qui permets d'associer à un sommet une étiquètte
	 * le hashmap sommets contiens chaque association d'un sommet et une etiquette 
	 */
	public void associerESommet (int s ,String etiquette) {
		//System.out.println("Association de l'étiquette \"" + etiquette +"\" au sommet " + s + " :::");
		if (s >= 0 && s < graphe.length ) {
			if(etiquette !=null) {
					sommets.put(s, etiquette);
					System.out.println("L'étiquette \"" + etiquette + "\" a été associée au sommet " + s + ".");
			}
		}else {
			System.out.println("erreur sommet n'existe pas ");
		}
	}
	/*
	 * 
	 * @see grapheorienté.InterfaceGraph#ajouterArc(int, int)
	 * l'ajout d'un arc etre deux sommets 
	 * stokage dans l'hashmap arcs un strig qui a cette  forme  ex : 0 -> 1
	 */
	public void ajouterArc(int depart, int arrive) {
		int indicearc = 0;
		String arc = depart +" -> "+arrive;
		System.out.println("Ajout de l'arc reliant le sommet " + depart + " au sommet " + arrive + " :::");
		if (depart < graphe.length && arrive< graphe.length) {
			if (graphe[depart][arrive] != 1) {
				for (int i = 0; i < graphe.length; i++) {
					for (int j = 0; j < graphe.length; j++) {
						graphe[depart][arrive] = 1;
					}
				}
				System.out.println("Arc creer avec succes entre sommet :" + depart +"est le sommer : " + arrive);
				arcs.put(indicearc, arc);
				indicearc++;
			} else {
				System.out.println("arc existe deja !!");
			}
		} else {
			System.out.println("erreur sommet n'existe pas !! ");
		}
	}
	/*
	 * @see grapheorienté.InterfaceGraph#associerEArc(int, int, java.lang.String)
	 */
	public void associerEArc(int d,int a,  String etiquette) {
		String arc = d+" -> "+a; 
		System.out.println("Association de l'étiquette \"" + etiquette +"\" à l'arc reliant le sommet " + d + " au sommet " + a + " :::");
			if (arcs.containsValue(arc)) {
				etiquetteArcs.put(arc, etiquette);
				System.out.println("Etiquette ajoué avec succes");
			}
	}
	/*
	 * 
	 * @see grapheorienté.InterfaceGraph#getEtiquettesommet(int)
	 */
	public void  getEtiquettesommet (int s) {
		String etiquette = null;
		if (s >= 0 && s < graphe.length ) {
			 if (sommets.get(s) != null) {
				 etiquette = sommets.get(s);
				 System.out.println("pas d'etiquette associer au sommet " + s + "est " + etiquette);
			}else {
				System.out.println("pas d'etiquette associer a ce sommet ");
			}
		} else {
			System.out.println("sommet "+ s + "n'existe pas ");
		}
	}
	/*
	 * (non-Javadoc)
	 * @see grapheorienté.InterfaceGraph#getEtiquetteArc(int, int)
	 */
	public void getEtiquetteArc(int d, int a) {
		String arc = d+" -> "+a; 
		if (etiquetteArcs.containsKey(arc)) {
			String etique = etiquetteArcs.get(arc);
			System.out.println(" l'etiquette associer a l'arc"+ arc + "est " + etique);
			
		}else {
			System.out.println("l'arc " + arc + "n'as pas d'etiquette associer ");
		}
	}
}
