public class Graphe
{
	private Sommet[] sommets;

	public Graphe(int n)
	{
		this.sommets = new Sommet[n];

		for (int i = 0; i < n; i++)
		{
			this.sommets[i] = new Sommet(i);
		}
	}

	public Graphe(int nbSommet, int nbArc)
	{
		this(nbSommet);

		for(int i = 0; i < nbArc; i++)
		{
			int randomSommet1;
			int randomSommet2;
			int cpt;

			cpt = 0;
			do
			{
				randomSommet1 = (int)(Math.random()*nbSommet);
				randomSommet2 = (int)(Math.random()*nbSommet);
				cpt++;
			}
			while(!hasNotArc(randomSommet1, randomSommet2) && cpt < 1000);

			if (cpt == 1000)
			{
				return;
			}

			this.getSommet(randomSommet1).ajouterArrete(this.getSommet(randomSommet2), (int)(Math.random()*(nbArc+nbSommet))+1);
		}
	}

	public int[][] getMatriceAdjacence()
	{
		int[][] matrice = new int[this.sommets.length][this.sommets.length];

		for (int i = 0; i < this.sommets.length; i++)
		{
			for (int j = 0; j < this.sommets.length; j++)
			{
				matrice[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < this.sommets.length; i++)
		{
			for (Arc arc : this.sommets[i].getArcs())
			{
				matrice[arc.getDepart().getId()][arc.getArrivee().getId()] = arc.getDistance();
			}
		}

		return matrice;
	}

	public boolean hasNotArc(int sommet1, int sommet2)
	{
		if (sommet1 == sommet2)
		{
			return false;
		}

		for (Arc arc : this.getSommet(sommet1).getArcs())
		{
			if (arc.getArrivee().getId() == sommet2)
			{
				return false;
			}
		}

		return true;
	}

	public Sommet[] getSommets()
	{
		return this.sommets;
	}

	public Sommet getSommet(int id)
	{
		return this.sommets[id];
	}

	public int getNombreSommets()
	{
		return this.sommets.length;
	}

	@Override
	public String toString()
	{
		String res = "================== GRAPHE ==================";

		for(int i = 0; i < this.getNombreSommets(); i++)
		{
			res += "\n"+this.getSommet(i);
		}

		return res;
	}

	public static void main(String[] args)
	{
		Graphe graphe = new Graphe(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		System.out.println(graphe);

		Sommet[] sommets = graphe.getSommets();

		int[][] matriceAdjacence = graphe.getMatriceAdjacence();

		for (Sommet sommet : sommets)
		{
			System.out.println("\n======= "+sommet.getId()+" =======\n\n"+sommet+"\n\n");
			BellmanFordAlgorithm.bellmanFordAlgorithm(graphe, matriceAdjacence, sommet);
		}
	}
}