package com.badjo.session;

import java.util.List;

import javax.ejb.Local;

import com.badjo.entities.Compte;

@Local
public interface IbankLocal {

	public void addCompte(Compte c);
	public List<Compte> consulterComptes();
	public Compte consulterCompte(Long id);
	public void verser(Long code, double montant);
	public void retire(Long code, double montant);
}
