package com.thou.tightcoupling;


//CLASS CHINH LA DAYYY, LO XU LI DATA TRONG RAM
//GUI --- CONTROLLER --- SERVICE --- REPO (JPAUTIL) --- --- TABLE
public class UserService {
    //CO IT NHAT 2 DEPENDENCY SERVICE NO CAN
    //1. USER-REPO GIUP CRUD TABLE ACCOUNG
    //2. GUI EMAIL/SMS/WHATSAPP CONFIRM

    private UserRepo userRepo = new UserRepo();  //dependency, tight coupling, chu dong quan li object dependency

    private EmailSender emailSender = new EmailSender(); //dependency, tight coupling, chu dong tao object trong long
    //new Service, co 2 chu nay dc new luon
    //hard-coded dependency, cung dependency vao day
    //full-control, direct-control dependency: tu khai bao, tu new
    //van de: sau nay thay = sms, whatsapp phai sua code class chinh nay

    //CO NHIEU HAM LIEN QUAN DEN TABLE USER:
    //getAllAccounts()   findByEmail()   findByPhone()   updateAccount()
    //...

    //nhan vao full info Account tu web form dki, hoac nhan vao Dto
    //chua email, phone,whatsapp id ben trong trich ra
    public void registerUser(Account acc) {
        //todo: goi repo de xuong table!! DUNG DEPENDENCY 1

        //gui email confirm - DUNG DEPENDENCY 2
        //                 dung ra phai dung acc.email
        emailSender.sendEmail("lethao@gmail.com", "... Pls input the OTP...");
    }
}


//CLASS A: class Service, dung class B, chu dong new luon -> tight coupling
//class B: class EmailSender - dependency cua A