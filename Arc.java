public class Arc {
	private final Sommet depart;
	private final Sommet arrivee;
	private final int distance;

	public Arc(Sommet depart, Sommet arrivee, int distance) {
		this.depart = depart;
		this.arrivee = arrivee;
		this.distance = distance;
	}

	public Sommet getDepart() {
		return depart;
	}

	public Sommet getArrivee() {
		return arrivee;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return "Arc de " + this.depart.getId() + " à " + this.arrivee.getId() + " de distance " + this.distance;
	}
}

