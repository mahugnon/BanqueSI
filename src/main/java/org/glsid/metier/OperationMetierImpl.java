package org.glsid.metier;

import java.util.Date;

import org.glsid.dao.JpaRepository.CompteRepository;
import org.glsid.dao.JpaRepository.EmployeRepository;
import org.glsid.dao.JpaRepository.OperationRepository;
import org.glsid.dao.entities.Compte;
import org.glsid.dao.entities.Employe;
import org.glsid.dao.entities.Operation;
import org.glsid.dao.entities.Retrait;
import org.glsid.dao.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier{
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employerRepository;

	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.findOne(code);
		Employe emp=employerRepository.findOne(codeEmp);
		Operation op=new Versement();
		op.setCompte(cp);
		op.setEmploye(emp);
		op.setDateOperation(new Date());
		op.setMontant(montant);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()+montant);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp=compteRepository.findOne(code);
		if(cp.getSolde()<montant) throw new RuntimeException("Solde insufisant");
		Employe emp=employerRepository.findOne(codeEmp);
		Operation op=new Retrait();
		op.setCompte(cp);
		op.setEmploye(emp);
		op.setDateOperation(new Date());
		op.setMontant(montant);
		operationRepository.save(op);
		cp.setSolde(cp.getSolde()-montant);
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String cp1, String cp2, double montant, Long codeEmp) {
		
		retirer(cp1, montant, codeEmp);
		verser(cp2, montant, codeEmp);
		return false;
	}

}
