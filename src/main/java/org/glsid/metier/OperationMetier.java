package org.glsid.metier;

import org.glsid.dao.entities.Compte;

public interface OperationMetier {
	
	public boolean verser(String code, double montant,Long codeEmp);
	public boolean retirer(String code, double montant,Long codeEmp);
	public boolean virement(String cp1,String cp2, double montant,Long codeEmp);

}
