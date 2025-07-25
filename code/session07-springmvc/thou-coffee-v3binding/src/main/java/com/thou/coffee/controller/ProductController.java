package com.thou.coffee.controller;

//class nay se lo cac xu ly lien quan den Product gom:
// crud product, nhung o goc do xu ly REQUEST/RESPONSE
//no phu trach cac url dinh dang den crud product,
//nhung lat hoi no se chuyen dan cho service, repo
//class nay lang nghe cac url, va xem url nao phu hop voi ham trongg class nay thi goi ham do - METHOD MAPPING VOI URL

//2 VIEC: NO PHAI LANG NGHE URL, NGHE XONG, GOI DUNG HAM UNG VOI URL
//VIEC 0: no phai la 1 bean dc new tu dong, vao ram va nghe
//VIEC 1: nghe - may la @Controller: bean va lang nghe
//VIEC 2: ham nao ung voi url nao, tra ve html

//QUAN TRONG: 1 URL GET -> UNG VOI 1 HAM RETURN "TEN TRANG (HTML) NAO DO"
//                                   HAM PHAI NAM TRONG 1 CLASS @Controller
//                      -> get CO NGHIA LA MUON LAY 1 TRANG THONG TIN

import com.thou.coffee.entity.Category;
import com.thou.coffee.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller  //@RestController neu tra ve JSON, @Controller neu tra ve HTML
public class ProductController {

    @GetMapping("/products/create")
    public String create(Model model) {

        //gui obj rong va cates cho man hinh tao moi
        model.addAttribute("ariana", new Product());
        model.addAttribute("cates", getCategories());

        return "product-form";
    }



    //chuan bi danh sach cac category, tra ve cho trang product-form de show danh sach chon loai san pham
    //code chuan: phai o ben CategoryService, CategoryRepo

    //hardcode danh sach
    public List<Category> getCategories(){
        List<Category> categories = List.of(
            new Category(100L, "Tra sua", "..."),
            new Category(200L, "Cafe", "..."),
            new Category(300L, "Nuoc ep", "..."),
            new Category(400L, "Nuoc ngot", "...")
        );
        return categories;
    }


    @GetMapping("/msg")
    public String showMessage(Model model) {
        //làm sao kay dc name sp cua ben post

        //model o day, ngoai data cua chinh chu ham nay, con nhan them tu ben post gui sang

        return "result";
    }



    @PostMapping("/products/save")
    //@RequestParam: gui tung o nhap o form len server, map vao bien hung trong ham
    //ten bien hung khong can giong bien trong form
    //nhung @RequestParam("ten bien o form html thuoc tinh name cua o nhap)
    public String save(Model model, @ModelAttribute("ariana") Product product, RedirectAttributes redirectAttributes) {

        //goi service/repo   ->  save(product) -> save vao database   : 3 layer

        model.addAttribute("msg", "Update product success - mock message");
        model.addAttribute("pname", product.getName());
        //thung gom 2 mon: cau thogn bao va ten san pham da edit
        //2 CAU LENH NAY SE VO DUNG NEU CHOI REDIRECT VI BEN REDIRECT XAI THUNG MODEL KHASC


        //return "result";   //hien tuong resubmission xuat hien

        //gui ke sang ben model/thung cua ham /msg - moi shipper 1 thung rieng
        redirectAttributes.addFlashAttribute("formMsg", "Update/Create product success - mock message");
        redirectAttributes.addFlashAttribute("pname", product.getName());
        return "redirect:/products";  //goi url /products de show toan bo sp
    }
    /*
    voi ham post (ban chat van la get - nhung gui kem nhieu data khi "get')
    khi ham post tra ve 1 trang ket qua qua lenh return "ten trang" thi url van giu nguyen
     */



    @GetMapping("/products/edit/{id}")
    //tach url thanh 2 phan, 1 phan co dinh va 1 phan thay doi
    //phan thay doi dgl path variable
    public String showProductForm(Model model, @PathVariable("id") String id) {

        //da trich dc id muon xem chi tiet tu click hyperlink cua user
        //todo: dung service goi repo de where trong table product ra san pham co id vua click, lam sau

        //tam thoi mock, hardcode
        //Product selectedProduct =   //lay tu database

        Product selectedProduct = null;
        if(id.equalsIgnoreCase("TC1")){
            selectedProduct = new Product("TC1", "Cafe den", 35_000);
        }else if(id.equalsIgnoreCase("TC2")){
            selectedProduct = new Product("TC2", "Cafe sua", 40_000);
        }else if(id.equalsIgnoreCase("TC3")){
            selectedProduct = new Product("TC3", "Cafe java", 50_000);
        }

        //quan trong: nem vao thung cho trang render!!
        model.addAttribute("ariana", selectedProduct);

        //gui them danh sach category
        model.addAttribute("cates", getCategories());

        return "product-form";  //.html ma khong can ghi ra
        //lenh return trang luon dinh kem theo 1 thung giao hang, gui do theo style key-value
        //thymeleaf engine dung chia khoa de mo vao thung, lay do ra mix tron -> html thuan va tra ve cho tomcat -> browser
    }




    //@RequestMapping("/products")   //url map voi ham nay localhost:6969/products, co the khong trung ten
    //cach nay nguy hiem 1 chut: url nay danh cho ca GET/POST/PUT/DELETE, mien match url
    //ta can phan tach: ham nao danh cho GET, ham nao danh cho POST

    //CACH VIET CHUAN, PHAN BIET HAM NAO DANH CHO GET, POST, PUT, DELETE
    //@RequestMapping(path = {"/products", "/thou"}, method = RequestMethod.GET)   //cach viet chuan de co nhieu url

    //CACH VIET NGAN HON
    //HAM NHAN REQUEST THUOC NHOM GET, lat hoi con nhom POST, PUT..
    //@GetMapping(path = {"/products", "/thou"})    //co bao nhieu url dc map toi ham nay
    @GetMapping("/products")
    public String list(Model model) {
        //list nghia la show danh sach cac san pham nam trong trang products.html
        //ten ham dat la gi cung duoc: showList, showProduct...

        //gui do cho view, bo vao hoc tu, thung chua do
        model.addAttribute("msg", "Helo admin");

        //chuan bi 1 danh sach san pham de show ra trang web products.html
        //hardcode ariana thu, thu te goi Service, Repo... sau, tiem chich tu dong khong can new
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("TC1", "Cafe den", 35_000));
        productList.add(new Product("TC2", "Cafe sua", 40_000));
        productList.add(new Product("TC3", "Cafe java", 50_000));

        //gui danh sach san pham trong thung do, lay lai do qua key products
        model.addAttribute("products", productList);
        return "products";
        //return ten trang - view, ko can .html
        // tu thymeleaf dependency lo gan ten
    }
    /*Khi controller tim thay ham xu li url tuong ung, no se goi ham nay
      Nhung truoc khi goi, no gui cho ham 1 thung chua do rong goi la model

      minh nhet data vao thung chua do nay, thung do model duoc new tu dong va chich vao ham xu ly url


      khi thuc thi lenh return cho url get... thi spring no se dinh kem cai thung do vao cung trang tra ve
      va dua ten trang + thung do cho thymeleaf mix, tron, render

      thymeleaf se lay do trong thung, trong voi cac tag html, tron xong, tra cho tomcat trang web html ngon
      -> day ve trung duyet user

      CAU HOI: LAM SAO NHET DO - DATA VAO THUNG, VA LAY RA - thung chua dc nhieu do...
              controller la nhet do vao thung
              html/thymeleaf la lay do ra khoi thung va mix

       tuong tuong tu gui do, quay gui tui/gio o sieu thi va tttm
       bo do vao hoc tu, lay chia khoa, manh giay
            chia khoa, manh giay goi la key
            mon do goi la value
       co chia, manh giay -> lay dc value/mon do

       GUI DO VAO THUNG (TRONG CONTROLLER)
       model.addAtribute(key-manh-giay, value)
                   key: chuoi khong trung - ten bien
                   value: obj bat ki

       VIEW, LAY DO, DUNG KEY
            ${ten-key}   -> tra ve obj mon do
     */


}
