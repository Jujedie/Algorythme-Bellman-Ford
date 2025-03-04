public class Graphe {
	private Sommet[] sommets;

	public Graphe(int n) {
		this.sommets = new Sommet[n];
		for (int i = 0; i < n; i++) {
			this.sommets[i] = new Sommet(i);
		}
	}
	public Graphe(int nbSommet, int nbArc){
		this(nbSommet);
		for(int i = 0; i < nbArc; i++){
			int randomSommet1 = (int)(Math.random()*nbSommet);
			int randomSommet2 = (int)(Math.random()*nbSommet);
			if (randomSommet2 == randomSommet1) {
				randomSommet2 = (int)(Math.random()*nbSommet);
			}

			this.getSommet(randomSommet1).ajouterArrete(this.getSommet(randomSommet2), (int)(Math.random()*(nbArc+nbSommet)));
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

    @Override
    public String toString() {
        String res = "================== GRAPHE ==================";

		for(int i = 0; i < this.getNombreSommets(); i++){
			res += "\n"+this.getSommet(i);
		}

		return res;
    }

	public static void main(String[] args) {
		Graphe graphe = new Graphe(Integer.parseInt(args[0]),Integer.parseInt(args[1]));	
		System.out.println(graphe);

		Sommet[] sommets = graphe.getSommets();

		int[][] matriceAdjacence = graphe.getMatriceAdjacence();

		for (Sommet sommet : sommets) {
			System.out.println("\n======= "+sommet.getId()+" =======\n\n"+sommet+"\n\n");
			BellmanFordAlgorithm.bellmanFordAlgorithm(graphe, matriceAdjacence, sommet);
		}
		

	}
}