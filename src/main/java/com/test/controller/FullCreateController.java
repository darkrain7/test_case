package com.test.controller;

import com.test.service.AttributeService;
import com.test.service.AttributeValueService;
import com.test.service.CategoryService;
import com.test.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/create")
public class FullCreateController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final AttributeService attributeService;
    private final AttributeValueService attributeValueService;

    @Autowired
    public FullCreateController(CategoryService categoryService, ProductService productService, AttributeService attributeService, AttributeValueService attributeValueService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.attributeService = attributeService;
        this.attributeValueService = attributeValueService;
    }

    @RequestMapping(value = "/new/all", method = RequestMethod.GET)
    Boolean createFullData() {
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
