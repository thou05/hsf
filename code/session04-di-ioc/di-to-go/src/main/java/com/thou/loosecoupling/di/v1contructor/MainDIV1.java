package com.thou.loosecoupling.di.v1contructor;

public class MainDIV1 {
    public static void main(String[] args) {
        //muon co service, can co email-sender truyen vao
        EmailSender emailSender = new EmailSender();  //DEPENDENCY CHU DONG LO MAT, NEW
        UserService userService = new UserService(emailSender); //CHICH TIEM OBJ BEN NGOAI VAO TRONG SERVICE
        userService.registerAccount(new Account());

        //MAIN CLASS CHU DONG TAO OBJ CLASS B, DEPENDENCY, DUA VAO CLASS CHINH
        //THANH CHUA, TAO CAC DEPENDENCY DUOC GOI LA CONTAINER
        //CHU DONG TAO DEPENDENCY, DUA VAO TRONG SERVICE CLASS CHINH A
        //THI KI THUAT NAY CODE O TREN GOI LA IoC, DAO NGUOC VIEC KIEM SOAT TAO OBJECT
        //SERVICE MAT BOT QUYEN, TRAO QUYEN, DAO QUYEN KIEM SOAT DEPENDENCY
        //Inversion of Control

        //BUA SAU, SPRING, SPRING BOOT THAY MAIN, TAO, KIEM SOAT, TIEM CHICH DEPENDENCY CHO CLASS CHINH
        // 2 THANH SPRING, SPRING BOOT GOI LA IOC CONTAINER
    }
}
