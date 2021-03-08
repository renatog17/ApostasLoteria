package com.renato.biblioteca.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.renato.biblioteca.domain.Apostador;
import com.renato.biblioteca.dto.ApostadorDTO;
import com.renato.biblioteca.repositories.ApostadorRepository;
import com.renato.biblioteca.resources.exceptions.FieldMessage;
import com.renato.biblioteca.services.validation.utils.CPF;

public class ApostadorUpdateValidator implements ConstraintValidator<ApostadorUpdate, ApostadorDTO> {
	
	@Autowired
	ApostadorRepository apostadorRepository;
	
	@Override
	public void initialize(ApostadorUpdate ann) {
	}

	@Override
	public boolean isValid(ApostadorDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		Apostador aux = apostadorRepository.findByEmail(objDto.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}