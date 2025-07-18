package com.thou.coffee.controller;

import com.thou.coffee.entity.Product;
import com.thou.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
//1.chiu trach nhiem hung cac url tu trinh duyet (get, post, etc.), hung data gui len cho server,
//2.goi ham xu li
//3. return lai trang web, hoac 1 url khac (redirect)
public class ProductController {

    //tiem productservice qua nhieu cach: field, ctor, setter
    @Autowired
    private ProductService productService;  //tu IOC CONTAINER cua Spring new, tiem

    @GetMapping("/products")   //controller
    public String showList(Model model) {   //model, thung chua info se gui cho trang truoc khi render

        model.addAttribute("products", productService.getAllProducts());
        //gui danh sach sp doc tu table, vao thung cho view dung


        return "products";  //view
        //kem cai thung chua data, nho thymeleaf engine tron, mix, merger, render dua cho tomcat ban hoan chinh thuan html
    }

    @GetMapping("/products/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("selectedOne", productService.getProductById(id));

        return "product-form";
    }

    @GetMapping("/products/new")
    public String create(Model model) {
        //tao moi van phai gui 1 selected obj chinh la 1 obj product ben trong default, chuoi ko gi ca, so la 0, boolean la false
        model.addAttribute("selectedOne", new Product());

        return "product-form";
    }


}
