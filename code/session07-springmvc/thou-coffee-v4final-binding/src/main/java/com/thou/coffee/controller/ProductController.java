package com.thou.coffee.controller;

import com.thou.coffee.entity.Product;
import com.thou.coffee.service.CategoryService;
import com.thou.coffee.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//1.chiu trach nhiem hung cac url tu trinh duyet (get, post, etc.), hung data gui len cho server,
//2.goi ham xu li
//3. return lai trang web, hoac 1 url khac (redirect)
public class ProductController {

    //tiem productservice qua nhieu cach: field, ctor, setter
    @Autowired
    private ProductService productService;  //tu IOC CONTAINER cua Spring new, tiem

    //tiem them CateService de lay danh sach cate, show trong man hinh product-form
    //ta dung full data cua bang 1 trong mqh 1-N, de show ra drop-down
    @Autowired
    private CategoryService categoryService;  //tu ioc

    @GetMapping("/products")   //controller
    public String showList(Model model) {   //model, thung chua info se gui cho trang truoc khi render

        model.addAttribute("products", productService.getAllProducts());
        //gui danh sach sp doc tu table, vao thung cho view dung


        return "products";  //view
        //kem cai thung chua data, nho thymeleaf engine tron, mix, merger, render dua cho tomcat ban hoan chinh thuan html
    }

    @GetMapping("/products/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {

        //Product selectedOne = productService.getProductById(id);
        model.addAttribute("selectedOne", productService.getProductById(id));

        //gui them danh sach cate de xo danh sach treo dau de lay thit heo, show cate name nhung lay id
        //vi ta can FK value cho table product

        //List<Category> cates = categoryService.getAllCategories();
        model.addAttribute("cates", categoryService.getAllCategories());

        return "product-form";
    }

    @GetMapping("/products/new")
    public String create(Model model) {
        //tao moi van phai gui 1 selected obj chinh la 1 obj product ben trong default, chuoi ko gi ca, so la 0, boolean la false
        model.addAttribute("selectedOne", new Product());
        model.addAttribute("cates", categoryService.getAllCategories());

        return "product-form";
    }

    //link save
    @PostMapping("/products/save")
    //PHAI LAY DATA TU DUOI MAN HINH FORM GUI LEN: id, name...
    //2 cach lay
    //CACH 1: @RequestParam("id") String id,  @RequestParam("name") String name, ...  => chi nen dung neu it field

    //CACH 2: OBJECT BINDING, toan bo form thanh 1 obj day len day, tren nay chi 1 tham so product gom...
    //         Dung @ModelAttribute("???") Product product
    //         ???: DI XUONG LA GI, DI LEN LA DO - BIEN SELECTEDONE NAM O TAG <FORM>

    //THAY VI CACH 1 GUI LE TUNG PHAN CUA OBJ, CACH 2 GUI SI, 1 OBJ CHUA CAC THANH PHAN

    //CHAN DAU CHAN DUOI QUA TRINH BINDING DU LIEU DUOI FORM LEN OBJ
    public String save(@Valid @ModelAttribute("selectedOne") Product product, BindingResult result, Model model) {
        //save xong tra ve trang products, show danh sach co san pham moi, hoac san pham cu da duoc cap nhat

        //neu co loi nhap trong qua trinh biding, thi vong lai man hinh nhap
        if(result.hasErrors()){

            //gui them cates khi o man hinh show error
            model.addAttribute("cates", categoryService.getAllCategories());

            return "product-form";  //da gui kem bien ban result sang form
        }

        //nho Service save: key moi thi la insert, key cu thi la update, tu Hibernate no tinh chp minh qua thanh repo
        //todo: key trung khi tao moi...
        productService.saveProduct(product);

        return "redirect:/products";  //goi lai ham showList() ơ tren
        //redirect: bat trinh duyet goi url khac
        // /save bi thay the bang /products, F5 ko so

    }

    //link delete
    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable("id") String id) {
       productService.deleteProduct(id);

        return "redirect:/products";
    }

    //link search


}
