package br.com.jornada.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.EventoDAO;
import br.com.jornada.daos.UsuarioDAO;
import br.com.jornada.models.Evento;
import br.com.jornada.models.Usuario;
import br.com.jornada.validation.EventoValidation;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoDAO eventoDao;
	@Autowired
	private UsuarioDAO usuarioDao;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(new EventoValidation());
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("eventos/lista");
		List<Evento> eventos = eventoDao.listar();
		modelAndView.addObject("eventos", eventos);
		return modelAndView;
	}

	@RequestMapping("/form")
	public ModelAndView form(Evento evento) {
		List<Usuario> usuarios = usuarioDao.listar();
		ModelAndView modelAndView = new ModelAndView("eventos/form");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}

	@RequestMapping("/gravar")
	public ModelAndView gravar(@Valid Evento evento, BindingResult result) {
		eventoDao.gravar(evento);
		return new ModelAndView("redirect:/evento");
	}
}
