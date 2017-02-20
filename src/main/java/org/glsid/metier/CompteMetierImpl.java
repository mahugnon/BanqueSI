package org.glsid.metier;

import java.util.Date;
import java.util.List;

import org.glsid.dao.JpaRepository.CompteRepository;
import org.glsid.dao.entities.Compte;
import org.glsid.dao.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier{
	
	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte cp) {
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public List<Compte> listCompte() {
		return compteRepository.findAll();
	}

	@Override
	public Compte getCompte(String code) {
		return compteRepository.findOne(code);
	}

	

}
