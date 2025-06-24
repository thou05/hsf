package com.thou.spring.ioc.v3di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class ContractService {
    //TUI XU LI HOP DONG LA VIEC CHINH, THEM GENERATE PDF, EXCEL

    //CAN 2 DEPENDENCY: REPO, GENERATOR (DOCUMENT GEN)

    private PdfGenerator pdfGenerator;
    //cho tiem tu dong luon


    public ContractService() {
    }
    //ctor rong, default, explicit-ctor

    //tiem chich vao, new o dau ko can biet - new tu IoC Container
    @Autowired   //tiem chich vao 1 bean khac qua constructor
    //bo autowired van chay vi class chi co 1 ctor
    //neu them 1 ctor khac thi loi ngay
    public ContractService(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }
    //NEU CLASS CO NHIEU CTOR THI BAT BUOC PHAI CO @AUTOWIRED DE DUNG CTOR CO THAM SO DE TIEM VAO

    //dung dependency dc chich vao
    public void processContract(){
        //todo: xu li logic hop dong, repo xuong db

        //gen file
        pdfGenerator.generateFile("202506242343mlem");
    }



}
