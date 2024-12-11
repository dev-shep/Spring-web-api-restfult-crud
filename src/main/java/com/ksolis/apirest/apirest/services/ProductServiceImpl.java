/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ksolis.apirest.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksolis.apirest.apirest.entitites.Product;
import com.ksolis.apirest.apirest.repositories.ProductRepository;

import jakarta.transaction.Transactional;

/**
 *
 * @author Limon
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Transactional()
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }
    
    @Transactional()
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
    
    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
    
    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = repository.findById(id);
        if(productOptional.isPresent()){
            Product productDd = productOptional.orElseThrow();
            productDd.setName(product.getName());
            productDd.setDescription(product.getDescription());
            productDd.setPrice(product.getPrice());
            return Optional.of(repository.save(productDd));
        }
       return productOptional;
    }
    
    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOptional = repository.findById(id);
        productOptional.ifPresent(productDd->{
            repository.delete(productDd);
        });
       return productOptional;
    }

  

}
