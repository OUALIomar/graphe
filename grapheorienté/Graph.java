package grapheorienté;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph implements InterfaceGraph {
	protected int nbsommet;
	protected int tailleGraphe = 0;
	protected int nb_arcs = 0;
	public static int[][] graphe;
	public static HashMap<Integer, String> sommets;
	public static HashMap<Integer, String> arcs; // identifier par sommet depart et arrive
	public static HashMap<String, String> etiquetteArcs; // hashmap contiens les etiquette associer a un arc
	
	/*
	 * constructeur
	 */
	public Graph(int nbsommet) {
		super();
		this.nbsommet = nbsommet;
		arcs = new HashMap<>();
		sommets = new HashMap<>();
		etiquetteArcs = new HashMap<>();
	}

	public int[][] getGraphe() {
		return graphe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grapheorienté.InterfaceGraph#creerGraphe(int)
	 */
	public int[][] creerGraphe(int nbsommet) {
		int i, j;
		System.out.println("creation d'un graph avec  : " + nbsommet + "  sommet");
		if (nbsommet > 1) {
			graphe = new int[nbsommet][nbsommet];
			for (i = 0; i < nbsommet; i++) {
				for (j = 0; j < nbsommet; j++) {
					graphe[i][j] = 0;

				}
			}
		}
		// le bloc est pour l'affichage
		for (i = 0; i < nbsommet; i++) {
			for (j = 0; j < nbsommet; j++) {
				System.out.print(graphe[i][j] + " | ");

			}
			System.out.println();
		}

		return graphe;

	}

	/*
	 * @see grapheorienté.InterfaceGraph#associerESommet(int, java.lang.String) une
	 * méthode qui permets d'associer à un sommet une étiquètte le hashmap sommets
	 * contiens chaque association d'un sommet et une etiquette
	 */
	public void associerESommet(int s, String etiquette) {
		if (s >= 0 && s < graphe.length) {
			if (etiquette != null) {
				sommets.put(s, etiquette);
				System.out.println("L'étiquette \"" + etiquette + "\" a été associée au sommet =>: " + s );
			}
		} else {
			System.out.println("erreur sommet n'existe pas ");
		}
	}

	/*
	 * 
	 * @see grapheorienté.InterfaceGraph#ajouterArc(int, int) l'ajout d'un arc etre
	 * deux sommets stokage dans l'hashmap arcs un strig qui a cette forme ex : 0 ->
	 * 1
	 */
	public void ajouterArc(int depart, int arrive) {
		System.out.println(graphe.length);
		int indicearc = 0;
		String arc = depart + " -> " + arrive;
		//System.out.println("Ajout de l'arc reliant le sommet " + depart + " au sommet => " + arrive );
		if (depart < graphe.length && arrive < graphe.length) {
			if (graphe[depart][arrive] != 1) {
				for (int i = 0; i < graphe.length; i++) {
					for (int j = 0; j < graphe.length; j++) {
						graphe[depart][arrive] = 1;
					}
				}
				System.out.println("l'arc " + arc +" a été créer");

				arcs.put(indicearc, arc);
				indicearc++;
			} else {
				System.out.println("arc existe deja !!");
			}
		} else {
			System.out.println("erreur sommet n'existe pas !! ");
		}
		for (int i = 0; i < graphe.length; i++) {
			for (int j = 0; j < graphe.length; j++) {
				System.out.print(graphe[i][j] + " | ");

			}
			System.out.println();
		}
	}

	/*
	 * @see grapheorienté.InterfaceGraph#associerEArc(int, int, java.lang.String)
	 */
	public void associerEArc(int d, int a, String etiquette) {
		System.out.println(graphe.length);
		String arc = d + " -> " + a;
		if (arcs.containsValue(arc)) {
			etiquetteArcs.put(arc, etiquette);
			System.out.println("Succes => ");
			System.out.println("Association de l'étiquette  " + etiquette + " à l'arc : "+ arc);
		}
	}

	/*
	 * 
	 * @see grapheorienté.InterfaceGraph#getEtiquettesommet(int)
	 */
	public void getEtiquettesommet(int s) {
		System.out.println(graphe.length);
		String etiquette = null;
		if (s >= 0 && s < graphe.length) {
			if (sommets.get(s) != null) {
				etiquette = sommets.get(s);
				System.out.println("L'etiquette associer au sommet  : " + s + "  est  =>  " +  etiquette);
			} else {
				System.out.println("pas d'etiquette associer a ce sommet ");
			}
		} else {
			System.out.println("sommet " + s + " n'existe pas ");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grapheorienté.InterfaceGraph#getEtiquetteArc(int, int)
	 */
	public void getEtiquetteArc(int d, int a) {
		System.out.println(graphe.length);
		String arc = d + " -> " + a;
	
		if (etiquetteArcs.containsKey(arc)) {
			String etique = etiquetteArcs.get(arc);
			System.out.println(" l'etiquette associer a l'arc  " + arc + "  est  => " + etique);

		} else {
			System.out.println("l'arc  " + arc + "n'as pas d'etiquette associer ");
		}
	}
}
