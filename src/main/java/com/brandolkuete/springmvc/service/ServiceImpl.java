package com.brandolkuete.springmvc.service;

import java.util.List;

import com.brandolkuete.springmvc.exception.SprinMVCAppException;
import com.brandolkuete.springmvc.models.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brandolkuete.springmvc.repository.EmployeRepository;
import org.zalando.problem.Status;

@Service
public class ServiceImpl implements IService {
	
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public Employe enregistrerEmploye(Employe employe) throws SprinMVCAppException {

		final boolean isExist = employeRepository.existsByCodeIgnoreCase(employe.getCode());
		if (isExist){
			throw new SprinMVCAppException("CODE_EXISTANT_DEJA",Status.NOT_FOUND);
		}else {
			return employeRepository.save(employe);
		}
	}

	@Override
	public List<Employe> listeEmployes() {
		return employeRepository.findAllByActive(true);
	}

	@Override
	public Employe rechercherEmploye(String code) {
		return employeRepository.findOneByCode(code);
	}

	@Override
	public void modifierEmploye(Employe employe) {
		employeRepository.saveAndFlush(employe);
	}

	@Override
	public void supprimerEmploye(Employe employe) {
		employe.setActive(false);
		modifierEmploye(employe);
	}

}
