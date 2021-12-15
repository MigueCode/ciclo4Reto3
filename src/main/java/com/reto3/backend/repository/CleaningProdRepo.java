package com.reto3.backend.repository;

import com.reto3.backend.model.CleaningProd;
import com.reto3.backend.repository.crud.CleaningProdCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CleaningProdRepo {

    @Autowired
    private CleaningProdCrud cleaningProdCrud;

    public List<CleaningProd> getAll() {
        return cleaningProdCrud.findAll();
    }

    public Optional<CleaningProd> getCleaningProd(Integer id) {
        return cleaningProdCrud.findById(id);
    }

    public CleaningProd create(CleaningProd cleaningProd) {
        return cleaningProdCrud.save(cleaningProd);
    }

    public void update(CleaningProd cleaningProd) {
        cleaningProdCrud.save(cleaningProd);
    }

    public void delete(CleaningProd cleaningProd) {
        cleaningProdCrud.delete(cleaningProd);
    }

}
