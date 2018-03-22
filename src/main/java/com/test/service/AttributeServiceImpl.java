package com.test.service;

import com.test.model.Attribute;
import com.test.model.Category;
import com.test.repository.AttributeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AttributeServiceImpl implements AttributeService {

    private final CategoryService categoryService;
    private final AttributeRepository attributeRepository;

    private final String categoryTV = "TV";
    private final String categoryFridge = "Fridge";
    private final String categoryWasher = "Washer";


    @Autowired
    public AttributeServiceImpl(CategoryService categoryService, AttributeRepository attributeRepository) {
        this.categoryService = categoryService;
        this.attributeRepository = attributeRepository;
    }


    @Override
    public Boolean insertRowIntoDB(Attribute attribute) {

        try {
            attributeRepository.save(attribute);
            return true;
        } catch (Exception e) {
            log.error("Ошибка при записи в бд(attribute)");
            return false;
        }
    }


    @Override
    public Boolean createAttributes() {
        try {

            Category category = categoryService.findByName(categoryTV);

            insertRowIntoDB(Attribute.builder()
                    .name("Diagonal")
                    .category(category)
                    .build());

            insertRowIntoDB(Attribute.builder()
                    .name("Depth")
                    .category(category)
                    .build());

            insertRowIntoDB(Attribute.builder()
                    .name("Type of categoryTV")
                    .category(category)
                    .build());

            category = categoryService.findByName(categoryFridge);

            insertRowIntoDB(Attribute.builder()
                    .name("Freezer")
                    .category(category)
                    .build());

            category = categoryService.findByName(categoryWasher);

            insertRowIntoDB(Attribute.builder()
                    .name("Width")
                    .category(category)
                    .build());

            insertRowIntoDB(Attribute.builder()
                    .name("Depth")
                    .category(category)
                    .build());

            insertRowIntoDB(Attribute.builder()
                    .name("Height")
                    .category(category)
                    .build());

            insertRowIntoDB(Attribute.builder()
                    .name("Type of download")
                    .category(category)
                    .build());

            return true;
        } catch (Exception e) {
            log.error("Ошибка записей в бд(attribute)");
            return false;
        }
    }
}
