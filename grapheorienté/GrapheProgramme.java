package grapheorienté;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class GrapheProgramme {

	private static Graph graph;

	public static void main(String[] args) {
		while (true) {

			int nbrsommet;
			int[][] graphe;
			String req = "";
			Scanner clavier = new Scanner(System.in);
			Console console = System.console();
			System.out.println("|--------------------------------------------------------|");
			System.out.println("|                      BIENVENUE                         |");
			System.out.println("|--------------------------------------------------------|");
			System.out.println("|         Choisissez une fonctionnalité :                |");
			System.out.println("|              1- Creer un graphe                        |");
			System.out.println("|              2- Associer une etiquette a un sommet     |");
			System.out.println("|              3- Ajouter un arc entre deux sommets      |");
			System.out.println("|              4- Obtenir l'etiquette d'un sommet        |");
			System.out.println("|              5- Associer une etiquette a un arc        |");
			System.out.println("|              6- Obtenir etiquette d'un arc             |");
			System.out.println("|              7- Lire un graphe a partir d'un fichier   |");
			System.out.println("|              8- sauvegarder un graphe dans un fichier  |");
			System.out.println("|--------------------------------------------------------|");
			req = clavier.nextLine();
			// clearTerminal();

			switch (req) {
			case "1": {

				System.out.println("Saisir un nombre de sommet");
				nbrsommet = Integer.parseInt(clavier.nextLine());
				// clearTerminal();
				graph = new Graph(nbrsommet);
				graph.creerGraphe(nbrsommet);
				graphe = new int[nbrsommet][nbrsommet];
				graphe = graph.getGraphe();
			}
				;
				break;
			case "2": {
				System.out.println(" sisir le numero de sommet ");
				int numsommet = Integer.parseInt(clavier.nextLine());
				System.out.println("saisir l'étiquette");
				String etiquette = clavier.nextLine();
				graph.associerESommet(numsommet, etiquette);
				System.out.println("ajout avec succes ");
			}
				;
				break;
			case "3": {
				System.out.println(" sisir le numero du sommet de depart ");
				int depart = Integer.parseInt(clavier.nextLine());
				System.out.println(" sisir le numero du sommet d'arrivé  ");
				int arrive = Integer.parseInt(clavier.nextLine());
				graph.ajouterArc(depart, arrive);
				System.out.println(" ajout avec succes ");

			}
				;
				break;
			case "4": {

				System.out.println(" sisir le numero du sommet  pour avoir son etiquette ");
				int depart = Integer.parseInt(clavier.nextLine());
				graph.getEtiquettesommet(depart);

			}
				;
				break;
			case "5": {
				System.out.println(" sisir le numero du sommet de depart de l'arc  ");
				int depart = Integer.parseInt(clavier.nextLine());
				System.out.println(" sisir le numero du sommet d'arrivé  de l'arc ");
				int arrive = Integer.parseInt(clavier.nextLine());
				System.out.println("saisir l'étiquette");
				String etiquette = clavier.nextLine();
				graph.associerEArc(depart, arrive, etiquette);
			}
				break;
			case "6": {
				System.out.println(" sisir le numero du sommet de depart de l'arc  ");
				int depart = Integer.parseInt(clavier.nextLine());
				System.out.println(" sisir le numero du sommet d'arrivé  de l'arc ");
				int arrive = Integer.parseInt(clavier.nextLine());
				graph.getEtiquetteArc(depart, arrive);
			}
				;
				break;
			case "7": {

			}
				;
				break;
			case "8": {

			}
				;
				break;
			default:
				break;
			}
		}
	}

	// pour nettoyer la console
	public static void clearTerminal() {
		System.out.print(" \033[H\033[2J");
		System.out.flush();
	}
}
