package com.thou.spring.ioc.v3di.constructor;

import org.springframework.stereotype.Component;

@Component   //tu new di, vi khong trang thai
public class PdfGenerator {
    public void generateFile(String fileName) {
        //todo: logic xi li gen ra file pdf...
        System.out.println("V3 DI IOC MLEM -> The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }
}
