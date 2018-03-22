package com.test.service;

import com.test.model.Attribute;
import com.test.model.AttributeValue;
import com.test.model.Category;
import com.test.model.Product;
import com.test.repository.AttributeRepository;
import com.test.repository.AttributeValueRepository;
import com.test.repository.CategoryRepository;
import com.test.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AttributeValueServiceImpl implements AttributeValueService {

    private final AttributeValueRepository attributeValueRepository;
    private final AttributeRepository attributeRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final String categoryTV = "TV";
    private final String categoryFridge = "Fridge";
    private final String categoryWasher = "Washer";

    private Map<String, List<String>> attributes = new HashMap<>();

    @Autowired
    public AttributeValueServiceImpl(AttributeValueRepository attributeValueRepository, AttributeRepository attributeRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.attributeValueRepository = attributeValueRepository;
        this.attributeRepository = attributeRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void AttrList() {
        ArrayList<String> tvAttr = new ArrayList<>();
        ArrayList<String> fridgeAttr = new ArrayList<>();
        ArrayList<String> washerAttr = new ArrayList<>();

        tvAttr.add("Diagonal");
        tvAttr.add("Depth");
        tvAttr.add("Type of TV");
        this.attributes.put(categoryTV, tvAttr);

        fridgeAttr.add("Freezer");
        this.attributes.put(categoryFridge, fridgeAttr);

        washerAttr.add("Width");
        washerAttr.add("Depth");
        washerAttr.add("Height");
        washerAttr.add("Type of download");
        this.attributes.put(categoryWasher, washerAttr);

    }

    @Override
    public Boolean insertRowIntoDB(AttributeValue attributeValue) {
        try {
            attributeValueRepository.save(attributeValue);
            return true;
        } catch (Exception e) {
            log.error("Ошибка записи в бд(attribute_value)");
            return false;
        }
    }

    @Override
    public Boolean createAttributeValues() {
        try {

            Category category = categoryRepository.findByName(categoryTV);

            Product product = productRepository.findById(1L);

            Map<Attribute, String> value = new HashMap<>();

            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(0)), "18.5");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(1)), "150");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(2)), "LED");
            addAttributeValues(category, product, value);
            value.clear();

            product = productRepository.findById(2L);
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(0)), "21.5");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(1)), "147");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(2)), "LED");
            addAttributeValues(category, product, value);
            value.clear();

            product = productRepository.findById(3L);
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(0)), "43");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(1)), "800");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryTV).get(2)), "UHD");
            addAttributeValues(category, product, value);
            value.clear();

            category = categoryRepository.findByName(categoryFridge);

            product = productRepository.findById(4L);
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryFridge).get(0)), "2pcs");
            addAttributeValues(category, product, value);
            value.clear();

            product = productRepository.findById(5L);
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryFridge).get(0)), "1pcs");
            addAttributeValues(category, product, value);
            value.clear();

            product = productRepository.findById(6L);
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryFridge).get(0)), "1pcs");
            addAttributeValues(category, product, value);
            value.clear();

            category = categoryRepository.findByName(categoryWasher);

            product = productRepository.findById(7L);
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(3)), "vertical");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(2)), "84");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(1)), "35");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(0)), "60");
            addAttributeValues(category, product, value);
            value.clear();

            product = productRepository.findById(8L);
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(0)), "60");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(1)), "35");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(2)), "84");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(3)), "vertical");
            addAttributeValues(category, product, value);
            value.clear();

            product = productRepository.findById(9L);
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(3)), "vertical");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(2)), "85");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(1)), "44");
            value.put(attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(categoryWasher).get(0)), "60");
            addAttributeValues(category, product, value);
            value.clear();

            return true;
        } catch (Exception e) {
            log.error("Ошбика записи в бд(attribute_value)");
            return false;
        }
    }

    private void buildAttributeValues(Attribute attribute, Product product, String value) {
        try {

            insertRowIntoDB(AttributeValue.builder()
                    .value(value)
                    .attribute(attribute)
                    .product(product)
                    .build());
        } catch (Exception e) {
            log.error("Ошибка записи в бд(attribute_value)");
        }
    }

    private void addAttributeValues(Category category, Product product, Map<Attribute, String> values) {

        Attribute attribute;
        if (values.size() == attributeRepository.countByCategory_Id(category.getId())) {
            for (int i = 0; i < values.size(); i++) {
                attribute = attributeRepository.findByCategory_IdAndName(category.getId(), attributes.get(category.getName()).get(i));
                buildAttributeValues(attribute, product, values.get(attribute));
            }
        } else log.error("Кол-во атрибутов не совпадает(" + category.getName() + ")");
    }

}