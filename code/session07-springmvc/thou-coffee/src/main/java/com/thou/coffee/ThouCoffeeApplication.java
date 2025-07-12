package com.thou.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//class nay la class trung tam, noi chua nhung khai bao ve cac loai bean co trong app nay:
// bean la nhung object dependency duoc IoC Container tu new, hay minh tu new va gui cho Container giu giup

//Dependency object la nhung class co @Component, @Service, @Repository, @Controller, @RestController

//@SpringBootApplication gop san 3 @ khacL @Configuration, @ComponentScan, @EnableAutoConfiguration:
// khoi dong Tomcat, JPA/Hibernate, MVC - dieu khien request/response
public class ThouCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThouCoffeeApplication.class, args);
	}

}
