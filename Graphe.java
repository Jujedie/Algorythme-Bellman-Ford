public class Graphe {
	private Sommet[] sommets;

	public Graphe(int n) {
		sommets = new Sommet[n];
		for (int i = 0; i < n; i++) {
			sommets[i] = new Sommet(i);
		}
	}

	public void ajouterArete(int depart, int arrivee, int distance) {
		sommets[depart].ajouterVoisin(sommets[arrivee], distance);
	}
}