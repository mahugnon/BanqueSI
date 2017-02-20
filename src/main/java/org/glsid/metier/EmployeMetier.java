package org.glsid.metier;

import java.util.List;

import org.glsid.dao.entities.Employe;

public interface EmployeMetier {

	public Employe save(Employe emp);
	public List<Employe> listEmploye();
}
