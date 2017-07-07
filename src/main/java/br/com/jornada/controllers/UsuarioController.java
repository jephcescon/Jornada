package br.com.jornada.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.UsuarioDAO;
import br.com.jornada.models.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@RequestMapping("/usuarios/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		return modelAndView;
	}
	
	@RequestMapping("/usuarios")
	public String gravar(Usuario usuario) {
		System.out.println(usuario);
		usuarioDao.gravar(usuario);
		return "/usuarios/ok";
	}
}