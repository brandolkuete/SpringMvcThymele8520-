package com.brandolkuete.springmvc.controllers;

import com.brandolkuete.springmvc.config.AutoGenerateurCode;
import com.brandolkuete.springmvc.exception.SprinMVCAppException;
import com.brandolkuete.springmvc.models.Employe;
import com.brandolkuete.springmvc.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/save")
public class SaveEmployeController {

    @Autowired
    private IService service;


    @GetMapping("/enregistrerEmploye")
    public String index() {
        return "template";
    }

    @ModelAttribute("view")
    public String view() {
        return "Pages/enregistrerEmploye";
    }

    @ModelAttribute("employe")
    public Employe pageEnregistrement() {
        return new Employe();
    }

    // controlleur pour l'enregistrement
    @PostMapping("/enregistrerEmployeForm")
    public String enregistrerEmploye(@ModelAttribute Employe employe, Model model) throws SprinMVCAppException {
        employe.setCode(AutoGenerateurCode.generateSequence(employe));
        service.enregistrerEmploye(employe);
        return "redirect:/liste/listeEmploye";

    }
}
