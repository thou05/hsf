package com.thou.coffee.repository;

import com.thou.coffee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
    //ko can viet cac ham CRUD table Product vi ta dung derived query methods
}
