public class BellmanFordAlgorithm {
	public static double[] bellmanFordAlgorithm(Graphe g,int[][] matriceAdjacence, Sommet s){
		double[] d = new double[g.getNombreSommets()];
		
		d[s.getId()] = 0;
		for (int i = 0; i < g.getNombreSommets(); i++) {
			if (i != s.getId()) {
				d[i] = Double.POSITIVE_INFINITY;
			}
		}

		System.out.println("Initialisation");
		afficherResultats(d);

		for(int i = 0; i < g.getNombreSommets() - 1; i++){
			for (int u = 0; u < g.getNombreSommets(); u++) {
				for (int v = 0; v < g.getNombreSommets(); v++) {
					if (d[u] != Double.POSITIVE_INFINITY) {
						if (d[v] > (d[u] + matriceAdjacence[u][v])) {
							d[v] = (int)(d[u] + matriceAdjacence[u][v]);
							
						}
					}
				}
			}
			System.out.println("Itération : " + i);
			afficherResultats(d);
		}


		return d;
	}

	public static void afficherResultats(double[] d){
		for (int i = 0; i < d.length; i++) {
			if (d[i] == Integer.MAX_VALUE) {
				System.out.println("Distance du sommet 0 au sommet " + i + " : Infinity");
			}
			else{
				System.out.println("Distance du sommet 0 au sommet " + i + " : " + d[i]);
			}
		}
		System.out.println();
	}
}
