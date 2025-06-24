package com.thou.spring.ioc.v2bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //bao trum cuoi ApplicationContext vao day tim info de new cac bean, quan li chung, tiem chung
//@ComponentScan("com.thou.spring.ioc.v2bean")    //ko quet luon
public class AppConfig {
    //thi phai new bean o day
    //@Bean  //obj dc return tu ham nay, di vao Container ngay
    //chi dong new la minh, chu dong dat ten obj, nhung dua obj cho Container

    //TEN HAM PHA CHUAN VERB-OBJ TRUYEN THONG MA MANG Y NGHIA TEN BIEN OBJ, DE DC DUNG NGAM TRONG CONTAINER

    @Bean("thaole")    //ki thuat dat theo theo cach minh muon ma k pha ten ham
    public PdfGenerator pdfGenerator() {
        return new PdfGenerator();
        //neu bean/class goc co constructor co tham so, DUNG BEAN TU NEW, TU TRUYEN DC THAM SO VAO CONSTRUCTOR
        //SPRING SE THUA KHI KO BIET DUA THAM SO THE NAO
    }
    //PdfGen x = getPdfGen();  = pdfGen = new PdfGen()

//    @Bean
//    public DocumentGenerator pdfGenerator(){
//        return new PdfGenerator();
//    }
//
//    @Bean
//    public DocumentGenerator excelGenerator(){
//        return new ExelGenerator
//    }
}

//TODO: dieu gi xay ra neu ta co 2 obj cua cung class
//vd: PdfGen va ExelGen deu la (implement) interface DocumentGenerator, xung dot 2 obj cung kieu cha
//@Primary, @Qualifier khi co nhieu @Bean cung kieu
