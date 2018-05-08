package grapheorienté;


import java.io.IOException;
import java.util.Scanner;

public class GrapheProgramme {
	// chemin du fichier ou sauvegarder le graphe
	public final static String CHEMIN_FILE = "/home/deniro/Bureau/test.dot";
	private static Graph graph;
	private static Scanner clavier;

	public static void main(String[] args) {
		while (true) {

			int nbrsommet;
			String req = "";
			clavier = new Scanner(System.in);
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
			System.out.println("|              7- sauvegarder un graphe dans un fichier  |");
			System.out.println("|              8- densité du graphe                      |");
			System.out.println("|--------------------------------------------------------|");
			req = clavier.nextLine();
			// clearTerminal();

			switch (req) {
			case "1": {

				System.out.println("Saisir un nombre de sommet");
				nbrsommet = Integer.parseInt(clavier.nextLine());
				graph = new Graph(nbrsommet);
				graph.creerGraphe(nbrsommet);
				// clearTerminal();
			}
				;
				break;
			case "2": {
				System.out.println(" sisir le numero de sommet ");
				int numsommet = Integer.parseInt(clavier.nextLine());
				System.out.println("saisir l'étiquette");
				String etiquette = clavier.nextLine();
				try {
					graph.associerESommet(numsommet, etiquette);
				} catch (SommetInexistantException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("ajout avec succes ");
			}
				;
				break;
			case "3": {
				System.out.println(" sisir le numero du sommet de depart ");
				int depart = Integer.parseInt(clavier.nextLine());
				System.out.println(" sisir le numero du sommet d'arrivé  ");
				int arrive = Integer.parseInt(clavier.nextLine());
				try {
					graph.ajouterArc(depart, arrive);
				} catch (SommetInexistantException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(" ajout avec succes ");

			}
				;
				break;
			case "4": {

				System.out.println(" sisir le numero du sommet  pour avoir son etiquette ");
				int depart = Integer.parseInt(clavier.nextLine());
				try {
					graph.getEtiquettesommet(depart);
				} catch (SommetInexistantException e) {
					System.out.println(e.getMessage());
				}

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
				try {
					graph.associerEArc(depart, arrive, etiquette);
				} catch (ArcInexistantException e) {
					System.out.println(e.getMessage());
				}
			}
				break;
			case "6": {
				System.out.println(" sisir le numero du sommet de depart de l'arc  ");
				int depart = Integer.parseInt(clavier.nextLine());
				System.out.println(" sisir le numero du sommet d'arrivé  de l'arc ");
				int arrive = Integer.parseInt(clavier.nextLine());
				try {
					graph.getEtiquetteArc(depart, arrive);
				} catch (ArcInexistantException e) {
					System.out.println(e.getMessage());
				}
			}
				;
				break;
			case "7": {
				try {
					graph.sauvegarder(CHEMIN_FILE);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
				;
				break;
			case "8": {
				graph.densité();
			}
				;
				break;
			default:
				System.out.println("Invalid option");

			}
		}
	}

	// to clear terminal 
	public static void clearTerminal() {
		System.out.print(" \033[H\033[2J");
		System.out.flush();
	}
}
