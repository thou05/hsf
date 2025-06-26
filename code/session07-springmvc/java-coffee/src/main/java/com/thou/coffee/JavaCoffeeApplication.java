package com.thou.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//bao: @Configuration, @ComponentScan() scan ngay nhung class trong .coffee fouler/package
// ma co chua @Component, @Service, @Repository, @RestController, @Controller
//new nhung dua nay, chich/tiem chung vao nhung class tuong ung
//@EnableAutoConfiguration: tu new, tu cau hinh: JPA/Hibernate, Tomcat, MVC...
public class JavaCoffeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCoffeeApplication.class, args);
    }

    //@Bean o day de chu dong new rieng nhung dependency, new xong gui cho IoC Container quan ly giup

}
