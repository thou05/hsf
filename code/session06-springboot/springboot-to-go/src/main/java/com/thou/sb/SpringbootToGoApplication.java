package com.thou.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication   //mang nhieu y nghia
//gop ben trong gom @Configuration va @ComponentScan()...

//class AppConfig ben phien ban pure Spring vua lam
public class SpringbootToGoApplication {

    public static void main(String[] args) {
        //tao ra Context, tao ra IoC Container chua cac @Bean
        //cau lenh nay xong la cac bean da xong
        ApplicationContext ctx = SpringApplication.run(SpringbootToGoApplication.class, args);

        //dc quyen xai bean sau lenh nay, quay tro lai bai Spring vua roi
        ExcelGenerator excelGenerator = (ExcelGenerator) ctx.getBean("thaoLe");
        excelGenerator.generateFile("2025.06.25.15:44");
    }

    //tao @bean cho nay
    @Bean("thaoLe")
    public ExcelGenerator excelGenerator(){
        return new ExcelGenerator();
    }


}
