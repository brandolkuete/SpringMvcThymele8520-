package com.brandolkuete.springmvc.controllers;

import java.util.List;

import com.brandolkuete.springmvc.models.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.brandolkuete.springmvc.service.IService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/liste")
public class ListeEmployesController {

	@Autowired
	private IService service;

    @GetMapping("/listeEmploye")
    public String index() {
        return "template";
    }

    @ModelAttribute("view")
    public String view() {
        return "Pages/listeEmploye";
    }

    @ModelAttribute("employes")
    public List<Employe> listeEmployes() {
        return service.listeEmployes();
    }

    @GetMapping("/suppression/{code}")
    public String supprimerEtudiant (@PathVariable("code") String code) {
        service.supprimerEmploye(service.rechercherEmploye(code));
        return "redirect:/liste/listeEmploye";
    }
}
