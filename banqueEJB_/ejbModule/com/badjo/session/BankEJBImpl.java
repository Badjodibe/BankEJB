package com.badjo.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.badjo.entities.Compte;

@Singleton(name = "BP2")
public class BankEJBImpl implements IbankLocal, IbankRemote {

	private Map<Long, Compte>  comptes = new Hashtable<Long, Compte>();
	@Override
	public void addCompte(Compte c) {

		comptes.put(c.getCode(), c);
		
	}

	@Override
	public List<Compte> consulterComptes() {

		return new ArrayList<Compte>(comptes.values());
	}

	@Override
	public Compte consulterCompte(Long id) {
		Compte c =  comptes.get(id);
		if(c==null) throw new RuntimeException("Compte Introuvable");
		return c;
	}

	@Override
	public void verser(Long code, double montant) {
		Compte cp = comptes.get(code);
		cp.setSolde(cp.getSolde() + montant);
	}

	@Override
	public void retire(Long code, double montant) {
		Compte cp = comptes.get(code);
		if(cp.getSolde() < montant) throw new RuntimeException("Solde insuffisant");
		cp.setSolde(cp.getSolde() - montant);
	}
	
	@PostConstruct
	public void initialisation() {
		addCompte(new Compte(1L, 7000, new Date()));
		addCompte(new Compte(2L, 4000, new Date()));
		addCompte(new Compte(3L, 2000, new Date()));


	}

}
