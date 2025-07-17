package com.thou.tiny.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/products/edit")
    public String edit() {
        return "product-form";
    }

    @GetMapping("/products/new")
    public String create() {
        return "product-form";
    }

    @GetMapping({"/products"})
    public String showProducts(@RequestParam(name = "keyword", required = false) String keyword, Model model, HttpSession session) {

        //CHAN NGAY TU DAU HAM, KO CAM USER GO URL
        //SERVER VA CODE MINH SE BLOCK
        //neu chua login thi vong ve login, doi url luon
        Integer role = (Integer) session.getAttribute("role");
        if(role == null) {
            return "redirect:/login";
        }

        //XAI KEYWORD DE WHERE TRONG DATABASE
        //NEU DI CON DUONG SEARCH -> luc nay show it hon
        if(keyword != null && !keyword.isEmpty()) {
            //todo: goi service/repo de where data, tra ve table
            model.addAttribute("result", keyword + " done");
        }else{
            //DI TU LOGIN SANG THI KO CO FIELD KEYWORD LUON
            //di con duong login, show full
            //todo: show tu database
            model.addAttribute("result", " show all products");
        }


        model.addAttribute("role", session.getAttribute("role"));   //lay dc 1 hoac 2
        return "products";  //products.html
    }
    //phan gui ke tu login se bi mat neu f5 vi f5 la goi lai ham
    //goi ham co thung moi, thung nay ko ai gui ke o lan f5 -> role = null


}
