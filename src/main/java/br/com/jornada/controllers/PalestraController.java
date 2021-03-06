package br.com.jornada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.EventoDAO;
import br.com.jornada.daos.PalestraDAO;
import br.com.jornada.daos.UsuarioDAO;
import br.com.jornada.models.Evento;
import br.com.jornada.models.Palestra;
import br.com.jornada.models.Usuario;

@Controller
@RequestMapping("/palestra")
public class PalestraController {

	@Autowired
	private PalestraDAO palestraDao;
	@Autowired
	private UsuarioDAO usuarioDao;
	@Autowired
	private EventoDAO eventoDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("palestras/lista");
		List<Palestra> palestras = palestraDao.listar();
		modelAndView.addObject("palestras", palestras);
		return modelAndView;
	}

	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("palestras/form");

		List<Usuario> usuarios = usuarioDao.listar();
		modelAndView.addObject("usuarios", usuarios);

		List<Evento> eventos = eventoDao.listarAtivos();
		modelAndView.addObject("eventos", eventos);

		return modelAndView;
	}

	@RequestMapping("/gravar")
	public ModelAndView gravar(Palestra palestra, BindingResult result) {
		palestraDao.gravar(palestra);
		return new ModelAndView("redirect:/palestra");
	}
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("palestras/editar");
		
		Palestra palestra = palestraDao.buscar(id);
		modelAndView.addObject("palestra", palestra);
		
		List<Usuario> usuarios = usuarioDao.listar();
		modelAndView.addObject("usuarios", usuarios);

		List<Evento> eventos = eventoDao.listarAtivos();
		modelAndView.addObject("eventos", eventos);
		
		return modelAndView;
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
	public ModelAndView editarPalestra(@ModelAttribute Palestra palestra, @PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("redirect:/palestra");

		palestraDao.alterar(palestra);

		return modelAndView;
	}

	@RequestMapping("/apagar")
	public ModelAndView apagar(Integer id) {
		palestraDao.apagar(id);
		return new ModelAndView("redirect:/palestra");
	}
}