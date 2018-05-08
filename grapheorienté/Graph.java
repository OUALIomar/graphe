package grapheorienté;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import grapheorienté.SommetInexistantException;
import grapheorienté.ArcInexistantException;

public class Graph implements InterfaceGraph {
	protected int nbsommet;
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
	public void associerESommet(int s, String etiquette) throws SommetInexistantException {

		if (s >= 0 && s < graphe.length) {
			if (etiquette != null) {
				sommets.put(s, etiquette);
				System.out.println("L'étiquette \"" + etiquette + "\" a été associée au sommet =>: " + s);
			}
		} else {
			throw new SommetInexistantException();

		}
	}

	/*
	 * 
	 * @see grapheorienté.InterfaceGraph#ajouterArc(int, int) l'ajout d'un arc etre
	 * deux sommets stokage dans l'hashmap arcs un strig qui a cette forme ex : 0 ->
	 * 1
	 */
	public void ajouterArc(int depart, int arrive) throws SommetInexistantException {
		System.out.println(graphe.length);
		int indicearc = 3 * depart + arrive;
		String arc = depart + " -> " + arrive;
		// System.out.println("Ajout de l'arc reliant le sommet " + depart + " au sommet
		// => " + arrive );
		if (depart < graphe.length && arrive < graphe.length) {
			if (graphe[depart][arrive] != 1) {
				for (int i = 0; i < graphe.length; i++) {
					for (int j = 0; j < graphe.length; j++) {
						graphe[depart][arrive] = 1;
					}
				}
				System.out.println("l'arc " + arc + " a été créer");

				arcs.put(indicearc, arc);
				// etiquetteArcs.put(arc, null);
				// indicearc++;
			} else {
				System.out.println("arc existe deja !!");
			}
		} else {
			throw new SommetInexistantException();

		}

	}

	/*
	 * @see grapheorienté.InterfaceGraph#associerEArc(int, int, java.lang.String)
	 */
	public void associerEArc(int d, int a, String etiquette) throws ArcInexistantException {
		System.out.println(graphe.length);
		String arc = d + " -> " + a;
		if (arcs.containsValue(arc)) {
			etiquetteArcs.put(arc, etiquette);
			System.out.println("Succes => ");
			System.out.println("Association de l'étiquette  " + etiquette + " à l'arc : " + arc);
		} else {
			throw new ArcInexistantException();
		}
	}

	/*
	 * 
	 * @see grapheorienté.InterfaceGraph#getEtiquettesommet(int)
	 */
	public String getEtiquettesommet(int s) throws SommetInexistantException {
		System.out.println(graphe.length);
		String etiquette = null;
		if (s >= 0 && s < graphe.length) {
			if (sommets.get(s) != null) {
				etiquette = sommets.get(s);
				System.out.println("L'etiquette associer au sommet  : " + s + "  est  =>  " + etiquette);
			} else {
				System.out.println("pas d'etiquette associer a ce sommet ");
			}
		} else {
			throw new SommetInexistantException();
		}
		return etiquette;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grapheorienté.InterfaceGraph#getEtiquetteArc(int, int)
	 */
	public String getEtiquetteArc(int d, int a) throws ArcInexistantException {
		String arc = d + " -> " + a;
		String etiquette = " ";
		if (arcs.containsValue(arc)) {
			if (etiquetteArcs.containsKey(arc)) {
				String etique = etiquetteArcs.get(arc);
				System.out.println(" l'etiquette associer a l'arc  " + arc + "  est  => " + etique);
				etiquette = etique;
			} else {
				System.out.println("l'arc  " + arc + "n'as pas d'etiquette associer ");
			}
		} else {
			throw new ArcInexistantException();
		}
		return etiquette;
	}

	public boolean sauvegarder(String nomFichier) throws IOException {
		Boolean resultat = true;
		String etiq_sm = " ";
		try {
			BufferedWriter ff = new BufferedWriter(new FileWriter(nomFichier));
			ff.write("digraph mon_nouveau_graphe {");
			ff.newLine();
			for (int i = 0; i < graphe.length; i++) {
				ff.write(i + " ");
				try {
					if (this.getEtiquettesommet(i) != null) {
						etiq_sm = this.getEtiquettesommet(i);
						ff.write("[label = \"" + etiq_sm + "\"]");
					}
				} catch (SommetInexistantException e) {
					e.getMessage();
				}
				ff.write(";");
				ff.newLine();
			}
			int clef;
			Iterator<Integer> i = arcs.keySet().iterator();
			while (i.hasNext()) {
				clef = (int) i.next();
				String valeur = arcs.get(clef);
				System.out.println(valeur);
				ff.write(valeur + " ");
				String label = etiquetteArcs.get(valeur);
				if (label != null) {
					ff.write("[label = \"" + label + "\"]");
				}

				ff.write(";");
				ff.newLine();
			}
			ff.write("} ");
			ff.close();

		} catch (IOException e) {
			e.printStackTrace();
			resultat = false;
		}
		return resultat;
	}

	// algo 1 densité
	public double densité() {
		double densité = ((double) nbsommet) / (graphe.length * graphe.length);
		System.out.println("La densité du graphe est " + densité);
		return densité;
	}
}
