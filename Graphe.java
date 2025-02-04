public class Graphe {
	private Sommet[] sommets;

	public Graphe(int n) {
		this.sommets = new Sommet[n];
		for (int i = 0; i < n; i++) {
			this.sommets[i] = new Sommet(i);
		}
	}

	public int[][] getMatriceAdjacence() {
		int[][] matrice = new int[this.sommets.length][this.sommets.length];

		for (int i = 0; i < this.sommets.length; i++) {
			for (int j = 0; j < this.sommets.length; j++) {
				matrice[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < this.sommets.length; i++) {
			for (Arc arc : this.sommets[i].getArcs()) {
				matrice[arc.getDepart().getId()][arc.getArrivee().getId()] = arc.getDistance();
			}
		}
		
		return matrice;
	}

	public Sommet[] getSommets() {
		return this.sommets;
	}
	public Sommet getSommet(int id) {
		return this.sommets[id];
	}
	public int getNombreSommets() {
		return this.sommets.length;
	}

	public static void main(String[] args) {
		Graphe graphe = new Graphe(7);	

		graphe.getSommet(0).ajouterArrete(graphe.getSommet(1), 6);
		graphe.getSommet(0).ajouterArrete(graphe.getSommet(2), 7);
		graphe.getSommet(1).ajouterArrete(graphe.getSommet(3), 5);
		graphe.getSommet(1).ajouterArrete(graphe.getSommet(4), 4);
		graphe.getSommet(1).ajouterArrete(graphe.getSommet(2), 8);
		graphe.getSommet(2).ajouterArrete(graphe.getSommet(1), 3);
		graphe.getSommet(2).ajouterArrete(graphe.getSommet(4), 9);
		graphe.getSommet(3).ajouterArrete(graphe.getSommet(2), 2);
		graphe.getSommet(4).ajouterArrete(graphe.getSommet(3), 7);
		graphe.getSommet(4).ajouterArrete(graphe.getSommet(0), 2);
		graphe.getSommet(5).ajouterArrete(graphe.getSommet(1), 2);
		graphe.getSommet(5).ajouterArrete(graphe.getSommet(6), 1);
		graphe.getSommet(6).ajouterArrete(graphe.getSommet(0), 2);
		graphe.getSommet(6).ajouterArrete(graphe.getSommet(5), 1);

		Sommet[] sommets = graphe.getSommets();

		

		int[][] matriceAdjacence = graphe.getMatriceAdjacence();

		for (Sommet sommet : sommets) {
			System.out.println("\n======= "+sommet.getId()+" =======\n\n"+sommet+"\n\n");
			BellmanFordAlgorithm.afficherResultats(BellmanFordAlgorithm.bellmanFordAlgorithm(graphe, matriceAdjacence, sommet));
		}
		

	}
}