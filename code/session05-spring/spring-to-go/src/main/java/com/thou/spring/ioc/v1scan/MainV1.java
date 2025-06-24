package com.thou.spring.ioc.v1scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV1 {
    public static void main(String[] args) {
        //KHOI TAO CONTAIN, THUNG CHUA OBJECT, THUNG CHUA BEAN, VAO SPRING ROI DO
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //context thuoc class ApplicationContext la TRUM CUOI quan li cac obj - bean, quan li luon viec tiem vao cac obj khac
        //DUA NAO MUON DC TIEM VAO, DUA DO CUNG PHAI LA BEAN LUON

        //trum cuoi CONTEXT - choi trong ram
        //trum cuoi nay giong ENTITY-MANAGER-FACTORY da hoc - choi DB

        //lay bean ra dung
        PdfGenerator gen1 = (PdfGenerator) context.getBean("pdfGenerator");  //ten bien tham chieu cua ten class theo con lac da
        gen1.generateFile("0130");

        PdfGenerator gen2 = context.getBean("pdfGenerator",PdfGenerator.class);
        gen2.generateFile("0136");

        PdfGenerator gen3 = context.getBean(PdfGenerator.class);
        gen3.generateFile("0137");
    }
}
