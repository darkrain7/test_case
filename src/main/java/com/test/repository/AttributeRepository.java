package com.test.repository;

import com.test.model.Attribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends CrudRepository<Attribute, Long> {

    Attribute findByCategory_IdAndName(Long category, String name);

    int countByCategory_Id(Long id);

}
