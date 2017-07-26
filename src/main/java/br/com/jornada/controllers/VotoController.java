package br.com.jornada.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jornada.daos.VotoDAO;
import br.com.jornada.models.Voto;

@Controller
@RequestMapping("/voto")
public class VotoController {

	@Autowired
	private VotoDAO votoDao;
	
	@RequestMapping("/votar")
	public ModelAndView votar(Voto voto, BindingResult result, HttpServletRequest request) {
		List<Voto> buscarVoto = votoDao.buscarVoto(voto.getPalestra().getId(), voto.getUsuario().getId());
		
		if(buscarVoto.size() == 0 || buscarVoto.isEmpty()){
			votoDao.gravar(voto);
		}else{
			buscarVoto.get(0).setVoto(voto.getVoto());
			votoDao.alterar(buscarVoto.get(0));
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/palestraDetalhe/"+voto.getPalestra().getId());
		return modelAndView;
	}
	
}
