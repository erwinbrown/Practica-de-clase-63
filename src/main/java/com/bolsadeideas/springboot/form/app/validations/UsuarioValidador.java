package com.bolsadeideas.springboot.form.app.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		// Usuario usuario = (Usuario)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre");
		
		/*if(usuario.getNombre().isEmpty()) {
			
			errors.rejectValue("nombre", "NotEmpty.usuario.nombre");
		}*/
		
		/*if(usuario.getIndentificador().matches("[0-9]{1}[-][\\d]{3}[-][\\d]{3}") == false) {
		
			errors.rejectValue("indentificador", "pattern.usuario.identificador");
		}*/
		
	}

}
