package metier.entities;

import java.io.Serializable;

public class Chaussure implements Serializable{
	
	private Long idChauss;
	private String nomChauss;
	private double prix;
	public Chaussure() {
	super();
	}
	public Chaussure(String nomChauss, double prix) {
	super();
	this.nomChauss = nomChauss;
	this.prix = prix;
	}
	public Long getIdChaussure() {
	return idChauss;
	}
	public void setIdChaussure(Long idChauss) {
	this.idChauss = idChauss;
	}
	public String getNomChaussure() {
	return nomChauss;
	}
	public void setNomChaussure(String nomChauss) {
	this.nomChauss = nomChauss;
	}
	public double getPrix() {
	return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
		}
	@Override
	public String toString() {
		return "Chaussure [idChauss=" + idChauss + ", nomChauss=" + nomChauss + ", prix=" + prix + "]";
	}
}

