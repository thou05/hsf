package com.thou.spring.ioc.v1scan;


//class nay la noi ta khai bao cac obj dependency cua rieng ra
//va gui cho spring container no giu
//cung la noi khai bao cac thong tin ve cac dependency khac ma ta ko tu tao, IoC han cho Spring lo gium

//TOM LAI: class nay la noi luu giu cac thong tin ve cac dependency ma ta nho Spring quan li giup

//cac obj dependency new PdfGenerator(), new ContractService(), new Repository() se dc khai bao, va dc quan li o class nay
//va sau do chuyen giao cho spring

//nhung obj dependency ke tu nay ve sau goi la cac BEAN - HAT DAU THAN

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration   //@SpringBootApplicaiton khi choi SpringBoot
@ComponentScan("com.thou.spring.ioc.v1scan")
//@ComponentScan( basePackages = {"com.thou.spring.ioc.v1scan", "com.thou.spring.noioc"})

//scan tat ca cac package nay, coi class nao co @Componet, @Service, @Repository, @Controller, @RestController...
//thi new chung no - goi chung la bean
public class AppConfig {

}
