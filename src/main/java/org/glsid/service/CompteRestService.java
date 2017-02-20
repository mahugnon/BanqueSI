package org.glsid.service;

import java.util.List;

import org.glsid.dao.entities.Compte;
import org.glsid.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {
	
	@Autowired
	CompteMetier compteMetier;

	@RequestMapping(value="/comptes",method=RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte cp) {
		return compteMetier.saveCompte(cp);
	}
@RequestMapping(value="/comptes",method=RequestMethod.GET)
	public List<Compte> listCompte() {
		return compteMetier.listCompte();
	}
@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	public Compte getCompte(@PathVariable(value = "code") String code) {
		return compteMetier.getCompte(code);
	}
	

}
