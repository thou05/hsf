package com.thou.coffee.controller.web;

import com.thou.coffee.entity.Coffee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//1 bean dc tu new tu dau boi Container, chuyen tra loi cac http request den tu url cua user
//co nhieu url khac nhau thi ung voi nhieu ham trong class nay

//class nay tra ve html, trang web lung linh lap lanh
public class CoffeeWebController {

    @GetMapping("/")   //user go localhost:6969/ nghia la nhay de ham nay
    public String home(Model model){
        model.addAttribute("coffee", "trinh la gi?");
        model.addAttribute("coffee2", new Coffee("JC", "Java Cafe he he he", 29_000));
        return "index";  //tra ve ten trang cho trinh duyet
    }

}
