package br.uva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.uva.main.MotorInferencia;
import br.uva.modelo.Atributo;

@Controller
public class QuestionController {

	@Autowired
	private MotorInferencia motor;

	@RequestMapping("/questions")
	public String index(Model model) {
		motor = new MotorInferencia();
		
		model.addAttribute("atributo", new Atributo("O item " + motor.getPrimeiraPergunta().toLowerCase()));

		return "questions";
	}

	@RequestMapping(value = "/responder", method = RequestMethod.POST)
	public String form(Model model, @ModelAttribute("atributo") Atributo atributo) {
		System.out.println(atributo);
		
		Atributo atributoNovo = motor.inferirResposta(atributo);
		
		if(atributo.getResultadoFinal() != null || atributo.getResultadoFinal() == "") {
			String pathImg = "/images/" + atributo.getResultadoFinal().toLowerCase() + ".jpg";
			
			model.addAttribute("pathImg", pathImg);
			model.addAttribute("atributo", atributo);
			
			return "resultado-final";
		}
		
		model.addAttribute("atributo", atributoNovo);
		
		return "questions";
	}
	
}
