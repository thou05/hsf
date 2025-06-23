package com.thou.spring.noioc;

public class PdfGenerator {
    //class nay chuyen lo viec generate ra pdf - thoa SRP trong SOLID
    //lam gia cai ham generateFile(), ko lam that vi ton thoi gian, ngoai scope
    //gia nhung chay dc => goi la MOCK
    public void generateFile(String fileName) {
        //todo: logic xi li gen ra file pdf...
        System.out.println("The pdf file " + fileName + " has been generated successfully!!!");
    }
}
