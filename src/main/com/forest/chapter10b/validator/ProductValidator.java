package com.forest.chapter10b.validator;

import com.forest.chapter10b.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

    public boolean supports(Class<?> klass) {
        return Product.class.isAssignableFrom(klass);
    }
    public void validate(Object target, Errors errors) {
        System.out.println("============== validating product");
        Product product = (Product) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "productname.required");
        Float price = product.getPrice();
        if (price != null && price < 0) {
            errors.rejectValue("price", "price.negative");
        }
    }
}
