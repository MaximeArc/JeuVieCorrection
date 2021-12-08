package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import controleur.Controleur;


public class IHMSwing extends JFrame{

	private static final long serialVersionUID = 1L;
	final static int COTE = 3;

	// Ces valeurs sont li�es � l'�paisseur du bord de vos fen�tres. 
	private static final int deltaY = 31;
	private static final int deltaX = 8;

	private int ihmLargeur;
	private int ihmLongueur;

	private List<ArrayList<Color>> matrice = null;
	private boolean premiereFois=true;

	public void setMatrice(List<ArrayList<Color>> matrice) {
		this.matrice = matrice;
		ihmLongueur = matrice.size() * (COTE + 1) + 1;
		if (!matrice.isEmpty()) {
			ihmLargeur= ((matrice.get(0)).size()) * (COTE + 1) + 1;
		}
		setSize(ihmLargeur+deltaX*2, ihmLongueur+deltaY+deltaX);
	}

	class Fermeur extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	public IHMSwing(String title, Controleur controleur) {
		super(title);
		addWindowListener(new Fermeur());
		addMouseListener(new EcouteSouris(this, controleur));
		setVisible(true);
	}

	public void paint(Graphics g) {
		int y = 0;
		// permet de dessiner les contours des cases au d�but
		if (premiereFois) {
		g.setColor(Color.gray);
		g.fillRect(deltaX, deltaY, ihmLargeur, ihmLongueur);
		premiereFois=false;
		}
		for (List<Color> ligne : matrice) {
			int x = 0;
			for (Color point : ligne) {
				g.setColor(point);
				g.fillRect(x+deltaX, y+deltaY, COTE, COTE);
				x += COTE + 1;
			}
			y += COTE + 1;
		}

	}

}
