package org.glsid.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(String code, Date dateCreation, double solde, double decouvert) {
		super(code, dateCreation, solde);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	

}
