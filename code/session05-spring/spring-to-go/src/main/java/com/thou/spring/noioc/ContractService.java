package com.thou.spring.noioc;

public class ContractService {
    //code chinh cua minh, va minh lo CRUD table Contract qua Repo
    //sau do minh se generate pdf. Nho PdfGenerator giup, vay PdfGenerator la Dependency va phai tu new o day, hoac truyen vao - tiem chich vao
    private PdfGenerator gen;

    //tiem chich dependency qua constructor
    public ContractService(PdfGenerator gen) {
        this.gen = gen;
    }

    //todo:tiem chich qua setter
    public void setGen(PdfGenerator gen) {
        this.gen = gen;
    }

    public void processContract(){
        //todo: logic xu li hop dong...

        //generate pdf
        gen.generateFile("202506240043"); //hard-coded
    }
}
