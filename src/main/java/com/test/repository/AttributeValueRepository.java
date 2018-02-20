package com.test.repository;

import com.test.model.AttributeValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValueRepository extends CrudRepository<AttributeValue, Long> {

}