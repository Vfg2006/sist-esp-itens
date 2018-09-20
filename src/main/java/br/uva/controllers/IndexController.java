package br.uva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.uva.main.MotorInferencia;
import br.uva.modelo.PerguntaResposta;

@Controller
public class IndexController {

	@Autowired
	private MotorInferencia mi;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("pr", new PerguntaResposta("O item é comestivel ?"));

		return "index";
	}

	@RequestMapping(value = "/responder", method = RequestMethod.POST)
	public String form(Model model, @ModelAttribute("pr") PerguntaResposta pr) {
		System.out.println(pr);

		
//		String novaPergunta = null;
		pr.setPergunta("Testando");
		model.addAttribute("pr", pr);
		return "index";
	}
}
