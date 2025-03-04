public class BellmanFordAlgorithm {
	public static double[] bellmanFordAlgorithm(Graphe g,int[][] matriceAdjacence, Sommet s){
		double[] d = new double[g.getNombreSommets()];
		
		d[s.getId()] = 0;
		for (int i = 0; i < g.getNombreSommets(); i++) {
			if (i != s.getId()) {
				d[i] = Double.POSITIVE_INFINITY;
			}
		}

		String resultat = afficherResultats(d,s.getId()+"");
		String resultat2 = resultat;

		System.out.println("Initialisation\n"+resultat);
		

		for(int i = 0; i < g.getNombreSommets() - 1; i++){
			resultat = resultat2;
			for (int u = 0; u < g.getNombreSommets(); u++) {
				for (int v = 0; v < g.getNombreSommets(); v++) {
					if (d[v] > (d[u] + matriceAdjacence[u][v])) {
						d[v] = (int)(d[u] + matriceAdjacence[u][v]);
					}
				}
			}
			resultat2 = afficherResultats(d,s.getId()+"");
			System.out.println("Itération : "+i+"\n"+resultat2);
			if (resultat2.equals(resultat)){
				return d;
			}
			if (!isDNegative(d)){return d;}
		}


		return d;
	}

	public static String afficherResultats(double[] d, String idSommet){
		String res = "";
		for (int i = 0; i < d.length; i++) {
			if (d[i] == Integer.MAX_VALUE) {
				res += "Distance du sommet "+idSommet+" au sommet " + i + " : " + "Infinity\n";
			}
			else{
				res += "Distance du sommet "+idSommet+" au sommet " + i + " : " + d[i]+"\n";
			}
		}
		res += "\n";
		return res;
	}
	public static boolean isDNegative(double[] d){
		for (int i = 0; i < d.length;i++){
			if (d[i] < 0){return false;}
		}
		return true;
	}
	public static boolean isActualDInferiorToLastD(double[] dActuel, double[] dPrec){
		# ne pas tester avec le max MAX_VALUE ou le infinity.

	}
}
