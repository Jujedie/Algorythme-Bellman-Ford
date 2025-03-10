public class Sommet
{
	private int id;
	private Arc[] arcs;

	public Sommet(int id)
	{
		this.id   = id;
		this.arcs = new Arc[]{new Arc(this, this, 0)};
	}

	public void ajouterArrete(Sommet arrivee, int distance)
	{
		Arc[] newArcs = new Arc[this.arcs.length + 1];
		System.arraycopy(this.arcs, 0, newArcs, 0, this.arcs.length);

		newArcs[arcs.length] = new Arc(this, arrivee, distance);
		this.arcs = newArcs;
	}

	public Arc[] getArcs()
	{
		return this.arcs;
	}

	public int getId()
	{
		return this.id;
	}

	@Override
	public String toString()
	{
		String res = "Sommet " + this.id;
		for (Arc arc : this.arcs)
		{
			res += "\n\t  " + arc;
		}

		return res;
	}
}