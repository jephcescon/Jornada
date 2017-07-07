package br.com.jornada.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public void index(){
		System.out.println("chamando a home...");
	}
}
