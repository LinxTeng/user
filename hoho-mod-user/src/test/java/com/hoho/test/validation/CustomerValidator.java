package com.hoho.test.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Customer.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "名字不能为空");
    Customer c = (Customer) target;
    if (c.getAge() < 0) {
      errors.rejectValue("age", "年龄不能为负");
    }
  }

}
