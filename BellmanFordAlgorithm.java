public class BellmanFordAlgorithm {
	public static double[] bellmanFordAlgorithm(Graphe g,int[][] matriceAdjacence, Sommet s){
		double[] d = new double[g.getNombreSommets()];
		
		d[s.getId()] = 0;
		for (int i = 0; i < g.getNombreSommets(); i++) {
			if (i != s.getId()) {
				d[i] = Double.POSITIVE_INFINITY;
			}
		}

		for(int i = 0; i < g.getNombreSommets() - 1; i++){
			for (int j = 0; j < g.getNombreSommets(); j++) {
				for (int k = 0; k < g.getNombreSommets(); k++) {
					if (d[j] != Double.POSITIVE_INFINITY) {
						if (d[k] > (d[j] + matriceAdjacence[j][k])) {
							d[k] = (int)(d[j] + matriceAdjacence[j][k]);
						}
					}
				}
			}
		}


		return d;
	}

	public static void afficherResultats(double[] d){
		for (int i = 0; i < d.length; i++) {
			System.out.println("Distance du sommet 0 au sommet " + i + " : " + d[i]);
		}
	}
}
