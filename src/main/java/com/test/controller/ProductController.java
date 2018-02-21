package com.test.controller;

import com.test.model.Product;
import com.test.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
@Slf4j
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Product findById(@RequestParam(value = "id") Long id) {
        return productService.findById(id);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public Collection<Product> findAll() {
        return productService.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    Boolean updateProduct(@RequestParam(value = "id") Long id,
                          @RequestParam(value = "count", required = false, defaultValue = "-1") Long count,
                          @RequestParam(value = "price", required = false, defaultValue = "-1") Long price) {

        return productService.updateProduct(id, count, price);
    }
}
