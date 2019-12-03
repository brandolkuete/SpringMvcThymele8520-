package com.brandolkuete.springmvc.controllers;

import com.brandolkuete.springmvc.models.Employe;
import com.brandolkuete.springmvc.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modifier/{code}")
public class ModifierEmployeController {
    @Autowired
    private IService service;


    @GetMapping("/modifierEmploye")
    public String index() {
        return "template";
    }

    @ModelAttribute("view")
    public String view() {
        return "Pages/modifierEmploye";
    }

    @ModelAttribute("employe")
    public Employe formulaireModif(@PathVariable("code") String code) {
        return service.rechercherEmploye(code);
    }

    // controlleur pour la modification
    @PostMapping("/enregistrerModif")
    public String enregistrerModif(@ModelAttribute Employe employe){
        service.modifierEmploye(employe);
        return "redirect:/liste/listeEmploye";

    }
}
