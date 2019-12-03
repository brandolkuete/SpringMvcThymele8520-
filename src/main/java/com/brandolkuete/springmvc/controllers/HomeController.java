/**
 *
 */
package com.brandolkuete.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping(path = {"/","/index"})
	public String index() {
		return "template";
	}

	@ModelAttribute("view")
	public String view() {
		return "Pages/index";
	}

	@GetMapping("/carte")
	public String carteOpenStreetMap(){
		return "Pages/carteOpenStreetMap";
	}
}
