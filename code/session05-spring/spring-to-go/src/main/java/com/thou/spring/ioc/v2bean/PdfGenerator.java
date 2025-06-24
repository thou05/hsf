package com.thou.spring.ioc.v2bean;

import org.springframework.stereotype.Component;

//@Component  //de may dc tu new boi Spring IoC Container
public class PdfGenerator {
    public void generateFile(String fileName) {
        //todo: logic xi li gen ra file pdf...
        System.out.println("V2 -> The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }
}
