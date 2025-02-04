
import java.util.HashMap;

public class Sommet {
	private int id;
	private HashMap<Sommet, Integer> voisins;

	public Sommet(int id) {
		this.id = id;
		voisins = new HashMap<Sommet, Integer>();
	}

	public void ajouterVoisin(Sommet voisin, int distance) {
		voisins.put(voisin, distance);
	}
}
