package br.com.jornada.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.jornada.models.Evento;

public class EventoValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Evento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "organizador", "field.required");
	}

}
