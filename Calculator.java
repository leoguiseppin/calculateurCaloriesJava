package calculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// Trouver son nombre de calories

		Scanner sc = new Scanner(System.in);
		String erreur = "Erreur. Veuillez essayer a nouveau.";

		// 1. Calculer le nombre de calories idéal
		// 2. Le mettre à l'essai pendant un certain temps
		// 3. L'ajuster si nécessaire en fonction du resultat
		System.out.println("Veuillez entrer votre poids en kg : ");
		int poids = sc.nextInt();
		System.out.println("Veuillez entrer votre taille en cm : ");
		int taille = sc.nextInt();
		System.out.println("Veuillez entrer votre age : ");
		int age = sc.nextInt();
		System.out.println("Veuillez entrer votre sexe (m/f) : ");
		String sexe = sc.next();
		int a = 0;
		
		while(a != 1) {
			if(sexe.equals("m")) {
				System.out.println("Vous êtes un homme, vous pesez " + poids + "kg , vous mesurez " + taille + " cm et vous avez " + age + " ans." );
				System.out.println("");
				a = 1;
			} else if(sexe.equals("f")) {
				System.out.println("Vous êtes un homme, vous pesez " + poids + "kg , vous mesurez " + taille + " cm et vous avez " + age + " ans." );
				System.out.println("");
				a = 1;
	    	} else {
	    		System.out.println(erreur);
	    		System.out.println("Veuillez entrer votre sexe (m/f) : ");
	    		sexe = sc.next();
	    	}
		}
		
		// Multiplicateur [M] :
		System.out.println("1. Peu ou pas d'exercice/sport dans la semaine");
	    System.out.println("2. 1 heure a 3 heures de sport par semaine");
		System.out.println("3. 4 heures a 6 heures de sport intense par semaine");
		System.out.println("4. Plus de 6 heures de sport par semaine et un travail physique");
		
		System.out.println("A quelle fréquence faites-vous du sport ? (1/2/3/4) : ");
		int multiplicateur = sc.nextInt();
		
		double multiplicateurDActivite = 0;
		int maintenance = 0;
		a = 0;
		
		while(a != 1) {
			if(multiplicateur == 1) {
				multiplicateurDActivite = 1.15;
				a = 1;
			} else if(multiplicateur == 2) {
			    multiplicateurDActivite = 1.25;
			    a = 1;
			} else if(multiplicateur == 3) {
			    multiplicateurDActivite = 1.40;
			    a = 1;
			} else if(multiplicateur == 4) {
			    multiplicateurDActivite = 1.55;
			    a = 1;
			} else {
				System.out.println(erreur);
				System.out.println("A quelle fréquence faites-vous du sport ? (1/2/3/4) : ");
				multiplicateur = sc.nextInt();
			}
		}
		
		if(sexe.equals("m")) {
		    maintenance = Hommes(poids,taille,age,multiplicateurDActivite);
		    System.out.println("Votre maintenance est de " + maintenance + " par jour.");
		} else if(sexe.equals("f")) {
			maintenance = Femmes(poids,taille,age,multiplicateurDActivite);
	        System.out.println("Votre maintenance est de " + maintenance + " par jour.");
		}

		System.out.println("Voulez-vous prendre de la masse (o/n) : ");
		String questionMasse = sc.next();
		int priseMasse = 0;

		if(questionMasse.equals("o")) {
		    priseMasse = priseMasseSeche(maintenance);
		} else {
			System.out.println(erreur);
		    System.out.println("Voulez-vous prendre de la masse (O/N) : ");
		    questionMasse = sc.next();
		}

		System.out.println("Vous aurez alors besoin de " + priseMasse + " calories par jour.");
		
		sc.close();
	}
	
	// Formule de Mifflin St.Jeor
	// Hommes = 10*poids(kg) + 6.25*taille(cm) - 5*âge(an) + 5
	// Maintenance = métabolisme_de_base [mifflin st.jeor] * multiplicateur_d'activité [M]
	public static int Hommes(int p,int t,int a,double multiDActivite) {
		int metabolismeDeBase = (int) (10*p + 6.25*t - 5*a + 5);
	    int maintenance = (int) (metabolismeDeBase*multiDActivite);
	    return maintenance;
	}
	
	// Femmes = 10*poids(kg) + 6.25*taille(cm) - 5*âge(an) - 161
	// Maintenance = métabolisme_de_base [mifflin st.jeor] * multiplicateur_d'activité [M]
	public static int Femmes(int p,int t,int a,double multiDActivite) {
		int metabolismeDeBase = (int) (10*p + 6.25*t - 5*a - 161);
	    int maintenance = (int) (metabolismeDeBase*multiDActivite);
		return maintenance;
	}
	
	public static int priseMasseSeche(int maintenance) {
	    int objectif = (int) (maintenance*1.15);
	    return objectif;
	}

}