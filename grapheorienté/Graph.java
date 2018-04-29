package grapheorienté;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph implements InterfaceGraph {
	protected int nbsommet;
	//protected ArrayList<HashMap<Integer, String> > successeurs;
	protected int tailleGraphe = 0;
	protected int nb_arcs = 0;
	protected int [][] graphe;
	protected ArrayList<String> sommets = null;
	protected ArrayList<HashMap<Integer, String> > arcs; // identifier par sommet depart et arrive 
	public void creerGraphe(int nbsommet) {
		System.out.println( "creation d'un graph avec " + nbsommet + "de sommet");
		
		if (nbsommet > 1) {
			for (int i = 0; i < graphe.length; i++) {
				for (int j = 0; j < graphe.length; j++) {
					graphe[i][j] = 0;
				}
			}
			
		}
	}
	public void associerESommet (int s ,String etiquette) {
		System.out.println("Association de l'étiquette \"" + etiquette +"\" au sommet " + s + " :::");
		if ((s > -1) && (s < graphe.length)) {
			int index = sommets.indexOf(etiquette);
			if ( (etiquette == null) || (index == -1) ) {
				sommets.set(s, etiquette);
				System.out.println("L'étiquette \"" + etiquette + "\" a été associée au sommet " + s + ".");
			}else {
				System.out.println("Le sommet " + index + "contient déjà l'étiquette \"" + etiquette + "\". \"" + etiquette + "\" n'a pas été associé au sommet " + s + ".");
			}
		}else {
				System.out.println("Le sommet " + s + " n'est pas défini. Abandon de l'association.");
			}
			
		
	}
	public void ajouterArc(int depart, int arrive) {
		System.out.println("Ajout de l'arc reliant le sommet " + depart + " au sommet " + arrive + " :::");
		if (depart < graphe.length && arrive< graphe.length) {
			if (graphe[depart][arrive] != 1) {
				for (int i = 0; i < graphe.length; i++) {
					for (int j = 0; j < graphe.length; j++) {
						graphe[depart][arrive] = 1;
					}
				}
				System.out.println("Arc creer avec succes entre sommet :" + depart +"est le sommer : " + arrive);
			} else {
				System.out.println("arc existe deja !!");
			}
		} else {
			System.out.println("erreur sommet n'existe pas !! ");
		}
	}
	public void associerEArc(int d,int a,  String etiquette) {
		HashMap<Integer, String> etiquetteArcs = arcs.get(d);
		System.out.println("Association de l'étiquette \"" + etiquette +"\" à l'arc reliant le sommet " + d + " au sommet " + a + " :::");
		if ((d > 0) && (d < graphe.length) ) {
			if (etiquetteArcs.containsKey((Integer) a)) {
				String oldEtiquette = etiquetteArcs.put(d,etiquette);
				System.out.println("L'ancienne étiquette \"" + oldEtiquette + "\" de l'arc reliant les sommets " + d + " et " + a + " a été remplacée par l'étiquette \"" + etiquette + "\".");
			}
			else {
				System.out.println("Aucun arc reliant le sommet " + d + " au sommet " + a + ". Aucune étiquette n'a été ajoutée.");
			}
			
		}else {
			System.out.println("Le sommet " + d + " n'est pas défini. Aucune étiquette n'a été ajoutée.");
		}
	}
	
	public void  getEtiquettesommet ( int s) {
		String etiquette = null;
		if (s > 0 && s < graphe.length ) {
			 if (sommets.get(s) != null) {
				 etiquette = sommets.get(s);
				
			}else {
				System.out.println("pas d'etiquette associer au sommet " + s + "!!");
			}
		} else {
			System.out.println("sommet "+ s + "n'existe pas ");
		}
	}
	public void getEtiquetteArc(int d, int a) {
		
	}
}
