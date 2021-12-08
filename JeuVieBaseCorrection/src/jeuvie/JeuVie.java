package jeuvie;

import jeuvie.bestiole.Bestiole;
import jeuvie.bestiole.Dauphin;


public class JeuVie {

	public static void main(String[] args) {
		
		//new Controleur(new BordDeCote(Ocean.PI));
		//new Controleur(new BordDeCote(Ocean.ALEA));

		//new Controleur(new HauteMer(Ocean.ALEA));
		//new Controleur(new HauteMer(Ocean.BARRE));
		//new Controleur(new HauteMer(Ocean.CANON));
		//new Controleur(new HauteMer(Ocean.CLOWN), Controleur.ITER_CLOWN);
		//new Controleur(new HauteMer(Ocean.PI), Controleur.ITER_PI);
		//new Controleur(new HauteMer(Ocean.GRAND_VAISSEAU));
		//new Controleur(new HauteMer(Ocean.PETIT_VAISSEAU));

		for (int i = 0; i < 10; i++) {
			Bestiole b = new Dauphin();
			if (i%2==0) {
				b.tuer();
			}
			System.out.println(b);
		}
		
	}

}
