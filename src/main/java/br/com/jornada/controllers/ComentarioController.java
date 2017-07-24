package br.com.jornada.controllers;

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
}
