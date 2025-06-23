package com.thou.loosecoupling.di.v2setter;

//GUI --- CONTROLLER --- SERVICE --- REPO (JPA/HIBERNATE CRUD) --- TABLE
public class UserService {
    //chuyen xu li data ve user/account trong ram, sau do goi repo de xuong table
    //ta can tro giup tu ngoai 2 viec/2 dependency: repo, sender gui confirm
    //ta ko tu new, ko nuoi 2 thang nay, ben ngoai tiem chich vao, goi dich vu
    //c1: field
    //c2: constructor da lam
    //c3: setter
    //c4: framework
    private UserRepo repo; //ko new cho tiem
    private EmailSender sender; //ko new cho tiem

    //setter tu generate hoac tu go code - y chang nhu yob, gpa dc setter vao

    public void setRepo(UserRepo repo) {
        this.repo = repo;
    }
    public void setSender(EmailSender sender) {
        this.sender = sender;
    }
    //CACH NAY DE HIEU, NHUNG CAI GIA PHAI TRA: NULL CHO DEPENDENCY NEU KO GOI SET()
    //NEU QUA CONSTRUCTOR, BAN KO DUA VAO CTOR, THI KO NEW DC, VI CTOR YEU CAU PHAI DUA THAM SO VAO THI MOI TRON VEN VIEC GOI HAM

    //THUONG UU TIEN DUNG CONSTRUCTOR INJECTION, DE KO BI NULL CAI DEPENDENCY


    //ve logic, cho nay thay Account bang AccountDto - data tranfer object
    //1 class/obj co nguon goc tu Account entity, nhung it cot hon
    public void registerAccount(Account acc){
        //trong acc co info email... minh tu gui mail theo email nay
        //todo: logic code goi CRUD cua repo

        //confirmed email
        sender.sendEmail("thaolethi@gmail.com", "...Pls check OTP...");
    }
}
