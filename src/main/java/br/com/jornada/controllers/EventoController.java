package br.com.jornada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.EventoDAO;
import br.com.jornada.models.Evento;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoDAO eventoDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("eventos/lista");
		List<Evento> eventos = eventoDao.listar();
		modelAndView.addObject("eventos", eventos);
		return modelAndView;
	}

	@RequestMapping("/form")
	public ModelAndView form(Evento evento) {
		ModelAndView modelAndView = new ModelAndView("eventos/form");
		return modelAndView;
	}
}
