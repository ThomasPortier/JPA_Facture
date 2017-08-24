package fr.codevallee.formation.tp1;

public class Plat {
	private int id_Plat;
	private String nom;
	private int tarif;
	
	
	public Plat(int id_Plat, String nom, int tarif) {
		super();
		this.id_Plat = id_Plat;
		this.nom = nom;
		this.tarif = tarif;
	}
	
	
	public int getId_Plat() {
		return id_Plat;
	}
	public String getNom() {
		return nom;
	}
	public double getTarif() {
		return tarif;
	}

	
}
