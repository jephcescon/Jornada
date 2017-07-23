package br.com.jornada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.EventoDAO;
import br.com.jornada.daos.PalestraDAO;
import br.com.jornada.models.Evento;
import br.com.jornada.models.Palestra;

@Controller
public class HomeController {
	
	@Autowired
	private EventoDAO eventoDao;
	@Autowired
	private PalestraDAO palestraDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home/eventos");
		List<Evento> eventos = eventoDao.listar();
		modelAndView.addObject("eventos", eventos);
		return modelAndView;
	}
	
	@RequestMapping(value = "/eventoDetalhe/{id}", method = RequestMethod.GET)
	public ModelAndView detalhes(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home/eventosDetalhe");
		Evento evento = eventoDao.buscar(id);
		modelAndView.addObject("evento", evento);
		List<Palestra> palestras = palestraDao.listar(evento);
		modelAndView.addObject("palestras", palestras);
		return modelAndView;
	}
	
	@RequestMapping(value = "/palestraDetalhe/{id}", method = RequestMethod.GET)
	public ModelAndView palestraDetalhe(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home/palestrasDetalhe");
		Palestra palestra = palestraDao.buscar(id);
		modelAndView.addObject("palestra", palestra);
		return modelAndView;
	}
}
