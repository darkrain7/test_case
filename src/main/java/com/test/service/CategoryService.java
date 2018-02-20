package com.test.service;

import com.test.model.Category;

public interface CategoryService {

    Boolean create(Category category);

    Boolean createData();

    Category findByName(String name);

}
