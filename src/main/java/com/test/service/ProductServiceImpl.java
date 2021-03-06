package com.test.service;

import com.test.model.Category;
import com.test.model.Product;
import com.test.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;
    private final ProductRepository productRepository;

    private static final String categoryTV = "TV";
    private static final String categoryFridge = "Fridge";
    private static final String categoryWasher = "Washer";

    @Autowired
    public ProductServiceImpl(CategoryService categoryService, ProductRepository productRepository) {
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    @Override
    public Boolean insertRowIntoDB(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            log.error("Ошибка при записи бд(product)");
            return false;
        }
    }

    @Override
    public Boolean createProducts() {
        try {

            Category category = categoryService.findByName(categoryTV);

            insertRowIntoDB(Product.builder()
                    .name("T19C350EX")
                    .brand_name("Samsung")
                    .count(100L)
                    .price(8999L)
                    .category(category)
                    .build());

            insertRowIntoDB(Product.builder()
                    .name("T22C350EX")
                    .brand_name("Samsung")
                    .count(150L)
                    .price(10999L)
                    .category(category)
                    .build());

            insertRowIntoDB(Product.builder()
                    .name("43UJ634V")
                    .brand_name("LG")
                    .count(200L)
                    .price(33990L)
                    .category(category)
                    .build());

            category = categoryService.findByName(categoryFridge);

            insertRowIntoDB(Product.builder()
                    .name("RF50K5920S8")
                    .brand_name("Samsung")
                    .count(200L)
                    .price(129990L)
                    .category(category)
                    .build());

            insertRowIntoDB(Product.builder()
                    .name("DFE 4200 W")
                    .brand_name("Indesit")
                    .count(77L)
                    .price(22490L)
                    .category(category)
                    .build());

            insertRowIntoDB(Product.builder()
                    .name("A2F635CWMV")
                    .brand_name("Haier")
                    .count(55L)
                    .price(44990L)
                    .category(category)
                    .build());

            category = categoryService.findByName(categoryWasher);

            insertRowIntoDB(Product.builder()
                    .name("F12U1HBS2")
                    .brand_name("LG")
                    .count(123L)
                    .price(29990L)
                    .category(category)
                    .build());

            insertRowIntoDB(Product.builder()
                    .name("MVB 59001 M")
                    .brand_name("Beko")
                    .count(156L)
                    .price(12490L)
                    .category(category)
                    .build());

            insertRowIntoDB(Product.builder()
                    .name("MV65FZ23/S")
                    .brand_name("Gorenje")
                    .count(174L)
                    .price(17490L)
                    .category(category)
                    .build());

            return true;
        } catch (Exception e) {
            log.error("Ошибка записей в бд(product)");
            return false;
        }
    }

    @Override
    public Collection<Product> findAll() {

        if (productRepository.findAll() == null) {
            log.error("Продуктов не найдено");
            return null;
        } else {
            return productRepository.findAll();
        }
    }

    @Override
    public Product findById(Long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            log.error("Продукт не найден");
        }
        return product;
    }

    @Override
    public Boolean updateProduct(Long id, Long count, Long price) {

        try {
            Product product = productRepository.findById(id);

            if (count > 0) {
                if (price >= 0) {

                    product.setCount(count);
                    product.setPrice(price);
                    productRepository.save(product);
                    return true;

                } else {
                    log.error("Операция невозмомжна(количество не может быть отрицательным)");
                    return false;
                }
            } else {
                log.error("Операция невозмомжна(цена не может быть отрицательной)");
                return false;
            }
        } catch (Exception e) {
            log.error("Ошибка редактирования данных(Product)");
            return false;
        }
    }
}



