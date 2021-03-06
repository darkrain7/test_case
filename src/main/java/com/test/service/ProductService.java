package com.test.service;

import com.test.model.Product;

import java.util.Collection;

/**
 * Created by User on 13.02.2018.
 */
public interface ProductService {

    Boolean insertRowIntoDB(Product product);

    Boolean createProducts();

    Collection<Product> findAll();

    Product findById(Long id);

    Boolean updateProduct(Long id, Long count, Long price);

}
