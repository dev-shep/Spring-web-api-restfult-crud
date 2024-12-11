/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ksolis.apirest.apirest;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ksolis.apirest.apirest.entitites.Product;

/**
 *
 * @author Limon
 */
@Component
public class ProductValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz); 
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product =(Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null,"es requerido¡");

        if (product.getDescription() == null || product.getDescription().isBlank()) {
            errors.rejectValue("description", null,"es requerido, por favor¡");
        }
        //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotBlank.product.description");
        if (product.getPrice() == null) {
            errors.rejectValue("price", null,"no puede ser nulo ok¡");
        }else if(product.getPrice() < 500){
            errors.rejectValue("price", null,"debe ser un valor numerico mayor o igual que 500");
        }
        //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotNull.product.price");

    }

}
