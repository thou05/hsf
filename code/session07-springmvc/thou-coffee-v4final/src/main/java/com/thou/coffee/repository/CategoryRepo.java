package com.thou.coffee.repository;

import com.thou.coffee.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//chinh thuc vao the gioi Spring Data > Spring JPA/Hibernate
public interface CategoryRepo extends JpaRepository<Category, Long> {
    public List<Category> findCategoriesByNameContainingIgnoreCase(String name);  //where Name like "%ng%"


}
