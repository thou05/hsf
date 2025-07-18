package com.thou.coffee.service;

import com.thou.coffee.entity.Product;
import com.thou.coffee.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    //gui-controller --- service --- repo --- spring jpa/hibernate -- jdbc --- table
    //class trung tam

    //crud table product
    //can tiem repo vao, dung ham tu sinh

    @Autowired
    private ProductRepo productRepo;

    //phuc vu cho viec show toan bo san pham trong trang products.html
    public List<Product> getAllProducts() {
        return productRepo.findAll();  //ham tu sinh
    }

    //phuc vu cho nut save san pham khi tao moi va edit
    //dung chung ham: JPA check id new la moi thi la insert, cu thi la update
    public void saveProduct(Product o) {
        productRepo.save(o);  //ham tu sinh
    }

    //link edit 1 san pham, ta phai get duoc sp nay day ve model cua product-form
    public Product getProductById(String id) {
        return productRepo.findById(id).get();
    }


    //link xoa san pham
    public void deleteProduct(Product o) {
        productRepo.delete(o);  //ham tu sinh
    }

    //search ....


    //ham khac...
}
