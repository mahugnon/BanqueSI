package org.glsid.metier;

import java.util.List;

import org.glsid.dao.entities.Compte;

public interface CompteMetier {
	
	public Compte saveCompte(Compte cp);
	public List<Compte> listCompte();
	public Compte getCompte(String code);

}
