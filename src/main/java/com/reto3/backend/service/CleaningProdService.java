package com.reto3.backend.service;

import com.reto3.backend.model.CleaningProd;
import com.reto3.backend.repository.CleaningProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningProdService {

    @Autowired
    private CleaningProdRepo cleaningProdRepo;

    public List<CleaningProd> getAll() {
        return cleaningProdRepo.getAll();
    }

    public Optional<CleaningProd> getCleaningProd(Integer id) {
        return cleaningProdRepo.getCleaningProd(id);
    }

    public CleaningProd create(CleaningProd cleaningProd) {
        if (cleaningProd.getId() == null) {
            return cleaningProd;
        } else {
            return cleaningProdRepo.create(cleaningProd);
        }
    }

    public CleaningProd update(CleaningProd cleaningProd) {

        if (cleaningProd.getId() != null) {
            Optional<CleaningProd> dbCleaningProd = cleaningProdRepo.getCleaningProd(cleaningProd.getId());
            if (!dbCleaningProd.isEmpty()) {

                if (cleaningProd.getBrand()!= null) {
                    dbCleaningProd.get().setBrand(cleaningProd.getBrand());
                }

                if (cleaningProd.getCategory() != null) {
                    dbCleaningProd.get().setCategory(cleaningProd.getCategory());
                }

                if (cleaningProd.getName() != null) {
                    dbCleaningProd.get().setName(cleaningProd.getName());
                }

                if (cleaningProd.getDescription() != null) {
                    dbCleaningProd.get().setDescription(cleaningProd.getDescription());
                }

                if (cleaningProd.getPrice() != 0.0) {
                    dbCleaningProd.get().setPrice(cleaningProd.getPrice());
                }

                if (cleaningProd.getQuantity() != 0) {
                    dbCleaningProd.get().setQuantity(cleaningProd.getQuantity());
                }

                if (cleaningProd.getPhotography() != null) {
                    dbCleaningProd.get().setPhotography(cleaningProd.getPhotography());
                }

                dbCleaningProd.get().setAvailability(cleaningProd.isAvailability());
                cleaningProdRepo.update(dbCleaningProd.get());
                return dbCleaningProd.get();
            } else {
                return cleaningProd;
            }
        } else {
            return cleaningProd;
        }
    }

    public boolean delete(Integer reference) {
        Boolean aBoolean = getCleaningProd(reference).map(gadget -> {
            cleaningProdRepo.delete(gadget);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
