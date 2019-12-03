package com.brandolkuete.springmvc.models;

import javax.persistence.*;

import com.brandolkuete.springmvc.config.AutoGenerateurCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Employe {
	
	// identifiant
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	// codeEmploye unique
	@Column(unique = true)
	protected String code = AutoGenerateurCode.generateSequence(this);
	// nom
	private String nom;
	// prenom
	private String prenom;
	// sexe
	private String sexe;
	// âge
	private int age;
	// active
	private boolean active= true;
}
