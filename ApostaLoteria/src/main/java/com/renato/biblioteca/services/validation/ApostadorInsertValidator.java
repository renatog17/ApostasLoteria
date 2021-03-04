package com.renato.biblioteca.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.renato.biblioteca.dto.ApostadorNewDTO;
import com.renato.biblioteca.resources.exceptions.FieldMessage;
import com.renato.biblioteca.services.validation.utils.CPF;

public class ApostadorInsertValidator implements ConstraintValidator<ApostadorInsert, ApostadorNewDTO> {
	@Override
	public void initialize(ApostadorInsert ann) {
	}

	@Override
	public boolean isValid(ApostadorNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		if(!CPF.isValidCPF(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "CPF inválido"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}