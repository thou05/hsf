package com.thou.tiny.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping({"/", "/login"})  //localhost:6969/ or localhost:6969/login
    public String showLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping({ "/do-login"})
    public String doLogin(@RequestParam("username") String username, HttpSession session) {

        //todo: PHAI LAY ROLE TU DATABASE
        if(username.equalsIgnoreCase("admin")){
            session.setAttribute("role", 1);
                                // key       value
        }else{
           session.setAttribute("role", 2);
        }
        return "redirect:/products";

    }


//    @PostMapping({ "/do-login"})  //lay data tu trang web gui len qua 2 cach : @RequestParam, @ModelAttribute
//    public String doLogin(@RequestParam("username") String username, Model model, RedirectAttributes redirectAttributes) {
//
//        //todo: PHAI LAY ROLE TU DATABASE
//        if(username.equalsIgnoreCase("admin")){
//            //model.addAttribute("role", "1");
//            redirectAttributes.addFlashAttribute("role", "1");  //gui le role sang model cua thang /products o duoi
//        }else{
//            //model.addAttribute("role", "2");
//            redirectAttributes.addFlashAttribute("role", "2");
//        }
//        return "redirect:/products";  //bat trinh duyet goi lai url moi ung voi trang can tra ve
//
//        //return "products";
//    }

    @GetMapping({"/products"})
    public String showProducts(@RequestParam(name = "keyword", required = false) String keyword, Model model, HttpSession session) {

        //CHAN NGAY TU DAU HAM, KO CAM USER GO URL
        //SERVER VA CODE MINH SE BLOCK
        //neu chua login thi vong ve login, doi url luon
        Integer role = (Integer) session.getAttribute("role");
        if(role == null) {
            return "redirect:/login";
        }

        //XAI KEYWORD DE WHERE TRONG DATABASE, NEU DI CON DUONG SEARCH DI TU LOGIN SANG THI KO CO FIELD KEYWORD LUON


        model.addAttribute("role", session.getAttribute("role"));   //lay dc 1 hoac 2
        return "products";  //products.html
    }
    //phan gui ke tu login se bi mat neu f5 vi f5 la goi lai ham
    //goi ham co thung moi, thung nay ko ai gui ke o lan f5 -> role = null

}
