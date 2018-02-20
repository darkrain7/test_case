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

    private final String TV = "TV";
    private final String Fridge = "Fridge";
    private final String Washer = "Washer";


    @Autowired
    public AttributeServiceImpl(CategoryService categoryService, AttributeRepository attributeRepository) {
        this.categoryService = categoryService;
        this.attributeRepository = attributeRepository;
    }


    @Override
    public Boolean create(Attribute attribute) {

        try {
            attributeRepository.save(attribute);
            return true;
        } catch (Exception e) {
            log.error("Ошибка при записи в бд(attribute)");
            return false;
        }
    }


    @Override
    public Boolean createData() {
        try {

            Category category = categoryService.findByName(TV);

            create(Attribute.builder()
                    .name("Diagonal")
                    .category(category)
                    .build());

            create(Attribute.builder()
                    .name("Depth")
                    .category(category)
                    .build());

            create(Attribute.builder()
                    .name("Type of TV")
                    .category(category)
                    .build());

            category = categoryService.findByName(Fridge);

            create(Attribute.builder()
                    .name("Freezer")
                    .category(category)
                    .build());

            category = categoryService.findByName(Washer);

            create(Attribute.builder()
                    .name("Width")
                    .category(category)
                    .build());

            create(Attribute.builder()
                    .name("Depth")
                    .category(category)
                    .build());

            create(Attribute.builder()
                    .name("Height")
                    .category(category)
                    .build());

            create(Attribute.builder()
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
