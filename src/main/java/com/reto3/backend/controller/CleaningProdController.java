package com.reto3.backend.controller;

import com.reto3.backend.model.CleaningProd;
import com.reto3.backend.service.CleaningProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaningprod/")
@CrossOrigin("*")
public class CleaningProdController {

    @Autowired
    private CleaningProdService cleaningProdService;

    @GetMapping("/all")
    public List<CleaningProd> getAll() {
        return cleaningProdService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProd> getClothe(@PathVariable("id") Integer id) {
        return cleaningProdService.getCleaningProd(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProd create(@RequestBody CleaningProd cleaningProd) {
        return cleaningProdService.create(cleaningProd);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProd update(@RequestBody CleaningProd cleaningProd) {
        return cleaningProdService.update(cleaningProd);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cleaningProdService.delete(id);
    }
}
