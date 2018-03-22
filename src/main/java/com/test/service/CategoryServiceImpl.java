package com.test.service;

import com.test.model.Category;
import com.test.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Boolean insertRowIntoDB(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            log.error("Ошибка при записи в бд(category)");
            return false;
        }
    }

    @Override
    public Boolean createCategories() {
        try {
            insertRowIntoDB(Category.builder().name("TV").build());
            insertRowIntoDB(Category.builder().name("Fridge").build());
            insertRowIntoDB(Category.builder().name("Washer").build());
            return true;
        } catch (Exception e){
            log.error("Ошибка при добавлении записей в бд(category)");
            return false;
        }
    }

    @Override
    public Category findByName(String name) {
        try {
            return categoryRepository.findByName(name);
        } catch (Exception e) {
            log.error("Категория с именем " + name + " не найдена");
            return null;
        }
    }
}
