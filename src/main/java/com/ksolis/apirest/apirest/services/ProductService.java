/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ksolis.apirest.apirest.services;

import java.util.List;
import java.util.Optional;

import com.ksolis.apirest.apirest.entitites.Product;

/**
 *
 * @author Limon
 */
public interface  ProductService {
    List<Product> findAll();

    Optional<Product>  findById(Long id);

    Product save(Product product);

    Optional<Product> update(Long id, Product product);

    Optional<Product> delete(Long id);
}
