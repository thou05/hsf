package com.thou.spring.ioc.v1scan;

import org.springframework.stereotype.Component;

@Component  //nghia la: day la 1 obj, 1 bean se dc tu dong new boi thu vien Spring, Spring Context
//@Service, @Repository cung dc, 2 thang nay la con cua @Component
public class PdfGenerator {
    public void generateFile(String fileName) {
        //todo: logic xi li gen ra file pdf...
        System.out.println("V1 -> The pdf file " + fileName + ".pdf has been generated successfully!!!");
    }
}
