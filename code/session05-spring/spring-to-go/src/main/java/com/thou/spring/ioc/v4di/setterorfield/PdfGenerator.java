package com.thou.spring.ioc.v4di.setterorfield;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {
    public void generateFile(String fileName) {
        //todo: logic xi li gen ra file pdf...
        System.out.println("V4 DI IOC MLEM (SETTER|FIELD)-> The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }
}
