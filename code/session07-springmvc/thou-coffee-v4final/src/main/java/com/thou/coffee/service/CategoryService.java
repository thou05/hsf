package com.thou.coffee.service;

import com.thou.coffee.entity.Category;
import com.thou.coffee.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
public class CategoryService {
    //GUI/CONTROLLER --- SERVICE --- REPO --- SPRING JPA/HIBERNATE --- JDBC DRIVER --- TABLE

    //tiem repo co 3 cach
    @Autowired  //co 1 dong ham tu sinh cho CRUD Cate roi nhe - chi can dung hoi - query method trong bien categoryRepo
    private CategoryRepo categoryRepo;

    //tiem qua constructor
    //ko can @Autowired neu class chi co 1 ctor co tham so, tiem ngay luc new chi co 1 duong new
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    //CRUD truyen thong, goi ham derived query methods tu sinh cua thang repo dc tiem vao tu dong
    public void saveCategory(Category o){
        categoryRepo.save(o); //ham tu sinh
    }
    //ham xoa, sua, search: sau tu lam

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();  //ham tu sinh, cau JPQL: SELECT c FROM Category c -> ngam se la SELECT * FROM Category
    } //dung cho combobox


    //CAC HAM KHAC: send noti(), voucher()...
}
