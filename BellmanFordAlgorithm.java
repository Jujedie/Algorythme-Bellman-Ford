public class BellmanFordAlgorithm {
	public static int[] bellmanFordAlgorithm(Graphe g,int[][] matriceAdjacence, Sommet s){
		int[] d = new int[g.getNombreSommets()];
		
		d[s.getId()] = 0;
		for (int i = 0; i < g.getNombreSommets(); i++) {
			if (i != s.getId()) {
				d[i] = Integer.MAX_VALUE;
			}
		}

		for(int i = 0; i < g.getNombreSommets() - 1; i++){
			for (int j = 0; j < g.getNombreSommets(); j++) {
				for (int k = 0; k < g.getNombreSommets(); k++) {
					if (matriceAdjacence[j][k] != Integer.MAX_VALUE) {
						if (d[k] > (d[j] + matriceAdjacence[j][k])) {
							d[k] = d[j] + matriceAdjacence[j][k];
						}
					}
				}
			}
		}


		return d;
	}

	public static void afficherResultats(int[] d){
		for (int i = 0; i < d.length; i++) {
			System.out.println("Distance du sommet 0 au sommet " + i + " : " + d[i]);
		}
	}
}
