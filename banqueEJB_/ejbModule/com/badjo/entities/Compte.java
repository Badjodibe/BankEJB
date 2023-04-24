package com.badjo.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Compte {

	private Long code;
	private double solde;
	private Date datecration;
	
	public Compte(Long code, double solde, Date datecration) {
		super();
		this.code = code;
		this.solde = solde;
		this.datecration = datecration;
	}

	@Override
	public String toString() {
		return "Compte [code=" + code + ", solde=" + solde + ", datecration=" + datecration + "]";
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDatecration() {
		return datecration;
	}

	public void setDatecration(Date datecration) {
		this.datecration = datecration;
	}
	
	
}
