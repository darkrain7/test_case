package com.test.service;

import com.test.model.Category;

public interface CategoryService {

    Boolean insertRowIntoDB(Category category);

    Boolean createCategories();

    Category findByName(String name);

}
