package com.jagodawieczorek.todoapp.category;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, String> {
    public List<Category> findAll();
}