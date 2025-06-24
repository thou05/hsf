package com.thou.spring.ioc.v2bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        PdfGenerator gen1 = context.getBean("pdfGenerator", PdfGenerator.class);
//        gen1.generateFile("16:38");

        PdfGenerator gen2 = context.getBean("thaole", PdfGenerator.class);
        gen2.generateFile("16:46");
    }

}
