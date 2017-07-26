package br.com.jornada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.ComentarioDAO;
import br.com.jornada.daos.EventoDAO;
import br.com.jornada.daos.PalestraDAO;
import br.com.jornada.daos.VotoDAO;
import br.com.jornada.models.Comentario;
import br.com.jornada.models.Evento;
import br.com.jornada.models.Palestra;
import br.com.jornada.models.TipoVoto;
import br.com.jornada.models.Votacao;
import br.com.jornada.models.Voto;

@Controller
public class HomeController {
	
	@Autowired
	private EventoDAO eventoDao;
	@Autowired
	private PalestraDAO palestraDao;
	@Autowired
	private ComentarioDAO comentarioDao;
	@Autowired
	private VotoDAO votoDao;
	
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
		List<Comentario> comentarios = comentarioDao.buscar(palestra);
		modelAndView.addObject("comentarios", comentarios);
		
		List<Voto> votos = votoDao.listar();
		modelAndView.addObject("votos", votos);
		
		Votacao votacao = new Votacao();
		List<Voto> contarVotos = votoDao.contarVotos(palestra);
		int negativos = 0, positivos = 0;
		
		for (Voto voto : contarVotos) {
			if(voto.getVoto() == TipoVoto.NAO){
				negativos++;
			}else{
				positivos++;
			}
		}
		votacao.setVotos(contarVotos.size());
		votacao.setPositivos(positivos);
		votacao.setNegativos(negativos);
		modelAndView.addObject("votacao", votacao);
		
		return modelAndView;
	}
}
