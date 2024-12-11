/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ksolis.apirest.apirest.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ksolis.apirest.apirest.entitites.Product;


/**
 *
 * @author Limon
 */
public interface  ProductRepository extends CrudRepository<Product, Long>{
    
}
