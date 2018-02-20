package com.test.service;

import com.test.model.Product;

import java.util.Collection;

/**
 * Created by User on 13.02.2018.
 */
public interface ProductService {

    Boolean create(Product product);

    Boolean createData();

    Collection<Product> findAll();

    Product findById(Long id);

    Product updateProduct(Long id, Long count, Long price);

}
