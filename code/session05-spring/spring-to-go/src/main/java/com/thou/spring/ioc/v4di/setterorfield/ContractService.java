package com.thou.spring.ioc.v4di.setterorfield;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("thaoLe")  //nhu la new chu dong trong AppConfig classs - dc quyen chu dong ten, tham so cua ctor
public class ContractService {
    @Autowired     //Spring choi tro Reflection, tiem chich vao field
    //ko nen dung cach nay
    private PdfGenerator pdfGenerator;  //ko new cho tiem chich

    //ko lam ctor thi se co rong/empty tu dong


    //ham set()
    //TIEM CHICH VAO

    //co can @Autowired??
    //CHOI SETTER BAT BUOC PHAI CO @Autowired VI SET() LA HAM BINH THUONG, KHONG BI EP PHAI GOI NGAY LUC TAO OBJ
    //DO DO KHIEN THANG DEPENDENCY BI NULL

    //GIANG HO HAY CHON: TIEM CHICH QUA CTOR, KHOI TAO NGAY LUC TAO OBJ, SET() MANG Y NGHIA CHINH SUA SAU NAY

    //@Autowired
    public void setPdfGenerator(PdfGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }
    //null problem maybe neu thieu @Autowired

    public void processContract(){
        //todo: logic xu li contract

        pdfGenerator.generateFile("00:14");  //co nguy co bi null do chua set() ma ko di qua ctor
    }
}
