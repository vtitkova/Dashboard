package com.dmma.dashboard.app.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dmma.dashboard.app.models.RegistrationModel;

public class RegistrationValidator  implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(RegistrationModel.class);
	}

	@Override
	public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "midasofficeid",  "registration.error.required", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "midasbrokerid",  "registration.error.required", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",          "registration.error.required", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password1",      "registration.error.required", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2",      "registration.error.required", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jcaptcha",       "registration.error.required", "required");
	}

}
