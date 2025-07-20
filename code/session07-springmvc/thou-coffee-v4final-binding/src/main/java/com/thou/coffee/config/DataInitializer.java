package com.thou.coffee.config;

//tu chay 1 lan duy nhat khi tomcat duoc chay, la ioc container chay, dung de tao table, tao san data trong table

import com.thou.coffee.entity.Category;
import com.thou.coffee.entity.Product;
import com.thou.coffee.service.CategoryService;
import com.thou.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  //may phai la bean moi duoc goi
public class DataInitializer implements CommandLineRunner {

    //nho 3 service giup tao table, chen san data
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        //tao object nho service day xuong
        //tao table 1 truoc, n sau (do khoa ngoai tham chieu khoa chinh)
        Category cate1 = new Category("Tra sua", "tra sua tran trau duong den he he");
        Category cate2 = new Category("Cafe", "cafe sua nong, cafe sua da, cafe den, cafe sua ong lao");
        Category cate3 = new Category("Nuoc ep", "nuoc ep trai cay, nuoc ep rau cu qua");
        Category cate4 = new Category("Do an", "banh mi, banh bao, banh kem, banh ngot, banh trung thu");

        //tao du lieu table product, product thi pai thuoc ve cate nao do
        Product p1c1 = new Product("TS01", "Tra Sua Tran Trau", 79, 39_000);
        Product p2c1 = new Product("TS02", "Tra Sua Matcha", 79, 68_000);
        cate1.addProduct(p1c1);
        cate1.addProduct(p2c1);
        Product p1c2 = new Product("CF01", "Cafe Sua Nong", 35, 25_000);
        Product p2c2 = new Product("CF02", "Cafe Sua Da", 55, 30_000);
        Product p3c2 = new Product("CF03", "Cafe Đen", 789, 25_000);
        cate2.addProduct(p1c2);
        cate2.addProduct(p2c2);
        cate2.addProduct(p3c2);
        Product p1c3 = new Product("NE01", "Nuoc Ep Cam", 83, 20_000);
        Product p2c3 = new Product("NE02", "Nuoc Ep Tao", 86, 25_000);
        cate3.addProduct(p1c3);
        cate3.addProduct(p2c3);
        Product p1c4 = new Product("BA01", "Banh Mi Thit", 24, 15_000);
        Product p2c4 = new Product("BA02", "Banh Bao", 25, 18_000);
        cate4.addProduct(p1c4);
        cate4.addProduct(p2c4);


        //xuong table thoi khi tomcat chat
        //CASCADE ALL: KHI TABLE 1 DI XUONG THI TABLE N XUONG LUON
        categoryService.saveCategory(cate1);  //list tra sua xuong table luon
        categoryService.saveCategory(cate2);
        categoryService.saveCategory(cate3);
        categoryService.saveCategory(cate4);
    }
}
