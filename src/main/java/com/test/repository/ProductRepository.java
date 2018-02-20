package com.test.repository;

import com.test.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findById(Long id);

    Collection<Product> findAll();

}
