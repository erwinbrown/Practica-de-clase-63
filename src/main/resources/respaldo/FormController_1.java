package com.bolsadeideas.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
@RequestMapping("/formulario")
public class FormController {

	@GetMapping("/form")
	public String formulario(Model mod) {
		
		Usuario usuario = new Usuario();
		
		mod.addAttribute("titulo", "Formulario de Usuarios");
		
		mod.addAttribute("usuario", usuario);
		
		return "formularios/form";

	}

	/*
	 * @PostMapping("/form") public String procesarform(Model mod, @RequestParam
	 * String username,
	 * 
	 * @RequestParam String password,
	 * 
	 * @RequestParam String email) {
	 * 
	 * Usuario usr = new Usuario();
	 * 
	 * usr.setUsername(username); usr.setPassword(password); usr.setEmail(email);
	 * 
	 * mod.addAttribute("titulo", "Resultado datos enviados desde el formulario");
	 * mod.addAttribute("usuario", usr);
	 * 
	 * 
	 * return "formularios/resultado";
	 * @ModelAttribute("user")
	 * }
	 */

	/*
	 * @PostMapping("/form") public String
	 * procesarform(@Valid @ModelAttribute("user") Usuario usuario, BindingResult
	 * result, Model mod) {
	 * 
	 * mod.addAttribute("titulo", "Resultado datos enviados desde el formulario");
	 * 
	 * if (result.hasErrors()) {
	 * 
	 * Map<String, String> errores = new HashMap<>();
	 * result.getFieldErrors().forEach(err -> {
	 * 
	 * errores.put(err.getField(),
	 * "El campo: ".concat(err.getField().concat(" ").concat(err.getDefaultMessage()
	 * ))); });
	 * 
	 * mod.addAttribute("error", errores); return "formularios/form"; }
	 * 
	 * mod.addAttribute("usuario", usuario);
	 * 
	 * return "formularios/resultado";
	 * 
	 * }
	 */
	
	@PostMapping("/form")
	public String procesarform(@Valid Usuario usuario, BindingResult result, Model mod) {

		mod.addAttribute("titulo", "Resultado datos enviados desde el formulario");

		if (result.hasErrors()) {

			/*
			 * Map<String, String> errores = new HashMap<>();
			 * result.getFieldErrors().forEach(err -> {
			 * 
			 * errores.put(err.getField(),
			 * "El campo: ".concat(err.getField().concat(" ").concat(err.getDefaultMessage()
			 * ))); });
			 * 
			 * mod.addAttribute("error", errores);
			 */
			
			
			return "formularios/form";
		}

		mod.addAttribute("usuario", usuario);

		return "formularios/resultado";

	}

}
