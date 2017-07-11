package br.com.jornada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping("/usuarios/lista")
	public ModelAndView listar() {
		List<Usuario> usuarios = usuarioDao.listar();
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}

	@RequestMapping("/usuarios/apagar")
	public ModelAndView apagar(Integer id) {
		usuarioDao.apagar(id);
		return new ModelAndView("redirect:lista");
	}

	@RequestMapping(value = "/usuarios/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("usuarios/editar");
		Usuario usuario = usuarioDao.buscar(id);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
	
	@RequestMapping(value="/usuarios/editar/{id}", method=RequestMethod.POST)
	public ModelAndView editarUsuario(@ModelAttribute Usuario usuario, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/usuarios/lista");
		
		usuarioDao.alterar(usuario);
		
		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
}
