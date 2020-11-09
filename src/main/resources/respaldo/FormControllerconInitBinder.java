package com.bolsadeideas.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.validations.UsuarioValidador;

@Controller
@RequestMapping("/formulario")
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;
	
	@InitBinder
	public void inicializador(WebDataBinder binder) {
		
		/*binder.setValidator(validador); */
		
		binder.addValidators(validador);
		
	}
	
	@GetMapping("/form")
	public String formulario(Model mod) {

		Usuario usuario = new Usuario();

		usuario.setNombre("Erwin");
		usuario.setApellido("Brown");
		usuario.setIndentificador("8-505-161");

		mod.addAttribute("titulo", "Formulario de Registro de Usuarios");

		mod.addAttribute("usuario", usuario);

		return "formularios/form";

	}

	@PostMapping("/form")
	public String procesarform(@Valid Usuario usuario, BindingResult result, Model mod, SessionStatus status) {
       
		/* validador.validate(usuario, result); */
		
		mod.addAttribute("titulo", "Resultado datos enviados desde el formulario");

		if (result.hasErrors()) {

			return "formularios/form";
		}

		mod.addAttribute("usuario", usuario);
		status.setComplete();
		return "formularios/resultado";

	}

}
