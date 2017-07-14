package br.com.jornada.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.PalestraDAO;
import br.com.jornada.models.Palestra;

@Controller
@RequestMapping("/palestra")
public class PalestraController {

	@Autowired
	private PalestraDAO palestraDao;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("palestras/lista");
		List<Palestra> palestras = palestraDao.listar();
		modelAndView.addObject("palestras", palestras);
		return modelAndView;
	}
}
