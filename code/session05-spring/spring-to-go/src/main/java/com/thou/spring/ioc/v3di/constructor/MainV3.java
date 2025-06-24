package com.thou.spring.ioc.v3di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV3 {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //2 bean: service va generator

        ContractService service = context.getBean("contractService", ContractService.class);
        service.processContract();
    }
}
