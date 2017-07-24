package br.com.jornada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.ComentarioDAO;
import br.com.jornada.models.Comentario;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	private ComentarioDAO comentarioDao;
	
	@RequestMapping("/gravar")
	public ModelAndView gravar(Comentario comentario, BindingResult result) {
		comentarioDao.gravar(comentario);
		return new ModelAndView("redirect:/evento");
	}
	
	@RequestMapping("/lista")
	public ModelAndView listar(Comentario comentario, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("comentarios/lista");
		List<Comentario> comentarios = comentarioDao.listar();
		modelAndView.addObject("comentarios", comentarios);
		return modelAndView;
	}

	@RequestMapping("/apagar")
	public ModelAndView apagar(Integer id) {
		comentarioDao.apagar(id);
		return new ModelAndView("redirect:lista");
	}
}
