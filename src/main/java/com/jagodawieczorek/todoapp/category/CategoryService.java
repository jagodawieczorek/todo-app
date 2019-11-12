package com.jagodawieczorek.todoapp.category;


import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Category findById(String id);
}