package com.thou.coffee.controller.api;

import com.thou.coffee.entity.Coffee;
import org.springframework.web.bind.annotation.*;

@RestController
//phuc vu cac url ma muon lay data tho, tra ve JSON, hoac nhan JSON tu trang web gui len

//thuong thay url api tach han so voi url web
//http:.../api/v1/...
//http:.../api/v2/...

@RequestMapping("/api/v1")
public class CoffeeApiController {
    @GetMapping("/cup")  //localhost:6969/api/v1/cup
    public Coffee getACup(){
        return new Coffee("JCC", "JAVA COFFEE EHEHEHE", 30_000);  //lay tu DB len qua Service/Repository/JPA-HIBERNATE/JDBC/TABLE
    } //goi Jackson convert tu object thanh JSON ben trinh duyet

    //data thoi - web api: goi ham qua url tra ve JSON
    //Swagger UI: help, document chua url de dung thu API

    //gui data len server, JSON gui len
    @PostMapping("/add") //localhost:6969/api/v1/add
    public Coffee addACup(@RequestBody Coffee cup){
        //sua obj da nhan, xong tra ve de biet minh da nhan tu client, va minh chinh it info
        String oldName = cup.getName();
        String newName = oldName + " | oi gioi oi ";
        cup.setName(newName);
        return cup;   //da chinh info
    }

    //curl -X POST "http://localhost:6969/api/v1/add" -H "Content-Type: application/json" -d "{\"id\":1,\"name\":\"Cafe Java chủ nhật\",\"price\":29000}"
}
