package com.brandolkuete.springmvc.service;

import java.util.List;

import com.brandolkuete.springmvc.exception.SprinMVCAppException;
import com.brandolkuete.springmvc.models.Employe;

public interface IService {

	public Employe enregistrerEmploye(Employe employe) throws SprinMVCAppException;
	public List<Employe> listeEmployes();
	public Employe rechercherEmploye(String code);
	public void modifierEmploye(Employe employe);
	public void supprimerEmploye(Employe employe);
}
