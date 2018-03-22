package com.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataServiceImpl implements DataService {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final AttributeService attributeService;
    private final AttributeValueService attributeValueService;

    @Autowired
    public DataServiceImpl(CategoryService categoryService, ProductService productService, AttributeService attributeService, AttributeValueService attributeValueService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.attributeService = attributeService;
        this.attributeValueService = attributeValueService;
    }

    @Override
    public Boolean createData() {
        try {

            categoryService.createCategories();
            productService.createProducts();
            attributeService.createAttributes();
            attributeValueService.createAttributeValues();

            return true;
        } catch (Exception e) {
            log.error("Ошибка записи (full)");
            return false;
        }
    }
}
