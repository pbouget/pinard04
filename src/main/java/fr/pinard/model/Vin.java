package fr.pinard.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

@Entity
public class Vin implements Serializable {
	public static final long serialVersionUID=56439876525L;


	/* 
	 * On déclare un objet de la classe VinPK qui contient la clef
	 * composée de codeProduit et designation avec l'annotation @EmbeddedId
	 * pour clef embarquée
	*/
	@EmbeddedId
	private VinPK vinPK;

	@Column(length = 45)
	private String region;

	public enum choix {ROUGE,BLANC,ROSE};

	@Enumerated(value = EnumType.STRING)
	@Column(length = 5)    
	private choix couleur;

	@Column(precision = 3, scale = 2)
	private double prix;

	@Column(precision = 2, scale = 2)
	private double remise;

	@Column(length = 3)
	private int quantite;

	@Transient
	public Integer getCodeProduit() {
		return this.vinPK.getCodeProduit();
	}

	@Transient
	public String getDesignation() {
		return this.vinPK.getDesignation();
	}

	public VinPK getVinPK() {
		return vinPK;
	}

	public void setVinPK(VinPK vinPK) {
		this.vinPK = vinPK;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public choix getCouleur() {
		return couleur;
	}

	public void setCouleur(choix couleur) {
		this.couleur = couleur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getCodeProduit() != null ? this.getCodeProduit().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vin other = (Vin) obj;
		if (couleur != other.couleur)
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		if (quantite != other.quantite)
			return false;
		if (region == null)
		{
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (Double.doubleToLongBits(remise) != Double.doubleToLongBits(other.remise))
			return false;
		if (vinPK == null) {
			if (other.vinPK != null)
				return false;
		}
		else if (!vinPK.equals(other.vinPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vin vinPK : " + vinPK + " " + region + " " + prix + " "+ remise + " qte = "+quantite;
	}




}
