package com.brandolkuete.springmvc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponsesControllers {
	
	// ----------------------- hello world ------------------------
	@RequestMapping(value = "/a01", method = RequestMethod.GET)
	public String a01() {
		 return "Greetings from Spring Boot!";
	 }
	
	// ----------------------- caractères accentués - UTF8 ------------------------
	@RequestMapping(value = "/a02", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String a02() {
	 return "caractères accentués : éèàôûî";
	 }
	
	// ----------------------- text/xml ------------------------
	@RequestMapping(value = "/a03", method = RequestMethod.GET, produces = "text/xml;charset=UTF-8")
	public String a03() {
	 String greeting = "<greetings><greeting>Greetings from Spring Boot!</greeting></greetings>";
	 return greeting;
	 }
	
	// ----------------------- produire du jSON ------------------------
	@RequestMapping(value = "/a04", method = RequestMethod.GET)
	public Map<String, Object> a04() {
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("1", "un");
	 map.put("2", new int[] { 4, 5 });
	 return map;
	 }
	
	// ----------------------- rendre un flux vide ------------------------
	@RequestMapping(value = "/a06")
	public void a06() {
	 }
	
	// ----------------------- text/html ------------------------
	@RequestMapping(value = "/a07", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String a07() {
	 String greeting = "<h1>Greetings from Spring Boot!</h1>";
	 return greeting;
	 }
	
	// ----------------------- résultat HTML en text/plain ------------------------
	@RequestMapping(value = "/a08", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String a08() {
	 String greeting = "<h1>Greetings from Spring Boot!</h1>";
	 return greeting;
	 }
	
	// ----------------------- résultat HTML en text/xml ------------------------
	@RequestMapping(value = "/a09", method = RequestMethod.GET, produces = "text/xml;charset=UTF-8")
	public String a09() {
	 String greeting = "<h1>Greetings from Spring Boot!</h1>";
	 return greeting;
	 }

}
