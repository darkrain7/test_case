package com.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by User on 20.02.2018.
 */
@Slf4j
@Service
public class CreateServiceImpl implements CreateService {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final AttributeService attributeService;
    private final AttributeValueService attributeValueService;

    @Autowired
    public CreateServiceImpl(CategoryService categoryService, ProductService productService, AttributeService attributeService, AttributeValueService attributeValueService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.attributeService = attributeService;
        this.attributeValueService = attributeValueService;
    }

    @Override
    public Boolean createFullData() {
        try {

            categoryService.createData();
            productService.createData();
            attributeService.createData();
            attributeValueService.createData();

            return true;
        } catch (Exception e) {
            log.error("Ошибка записи (full)");
            return false;
        }
    }
}
