package eu.codingschool.black.homeautomation.validator;

import eu.codingschool.black.homeautomation.entities.Person;
import eu.codingschool.black.homeautomation.services.PersonService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Autowired
    private PersonService personService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personname", "NotEmpty");


        if (person.getPersonname().length() < 6 || person.getPersonname().length() > 32) {
            errors.rejectValue("username", "Size");
        }
        if (personService.findByPersonname(person.getPersonname()) != null) {
            errors.rejectValue("username", "Duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (person.getPassword().length() < 8 || person.getPassword().length() > 32) {
            errors.rejectValue("password", "Size");
        }
    }
}