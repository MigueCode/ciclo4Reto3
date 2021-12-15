package com.reto3.backend.repository.crud;

import com.reto3.backend.model.CleaningProd;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleaningProdCrud extends MongoRepository<CleaningProd, Integer> {
}
