package com.thou.loosecoupling.di.v3finalfantasy;

import com.thou.loosecoupling.di.v1contructor.EmailSender;

public class UserService {
    //private SmsSender smsSender;
    //private EmailSender emailSender;

    private UserRepo repo;
    //Khai bao SmsSender, EmailSender dang goi la khai bao cung cai dependency
    //ko tot cho tuong lai khi ta can gui qua whatsapp
    //KO NEN PHU THUOC VAO CAI CU THE NHU O TREN, TA NEN PHU THUOC VAO CAI CHUNG CHUNG DE SAU NAY CON DE BO SUNG CAC HINH THUC GUI KHAC MA KO THEM SUA CODE CUA CHINH CLASS NAY SERVICE

    private NotiService noti;
    //noi chung chung la phu thuoc vao cai dam gui info nhung ko noi dua nao, sms hay email hay...
    //NHUNG CHAC DC 1 DIEU, obj noti CHAC CHAN CO HAM sendNoti()
    //code the nao, tu tu tinh


    //chich vao hoi, qua field, constructor, va setter tuy chon
    //nhung ctor la okie nhat

    public UserService(NotiService noti, UserRepo repo) {
        this.noti = noti;
        this.repo = repo;
    }

    public UserService(NotiService noti) {
        this.noti = noti;
    }
    //BAI NAY TAP TRUNG VAO NOTI
    //TIEM TU NGOAI VAO


    //chic theo setter, doi lieu chich khac - obj co quyen doi tro
    public void setNoti(NotiService noti) {
        this.noti = noti;
    }


    //GUI NOTI HOI, KO DAM NOI GUI MAIL HAY SMS HAY WHATSAPP
    public void registerAccount(Account acc){
        //LOGIC CODE GOI REPO DE CRUD TABLE ACCOUNT

        //gui noti
        //noti.sendNoti(to???, message??);
    }


    //MOCK LAM GIA VIEC CO THONG TIN GUI TOI AI: TO...
    //           GUI NOI DUNG GI: MESSAGE
    //2 THU NAY SE DC TRICH TU ACCOUNT OBJ LAY TU FORM NHAP, FORM DKI O WEB, CO DU O NHAP GOM FULLNAME, ADDRESS, PHONE, EMAIL...
    public void registerAccount(String to, String message){
        //LOGIC CODE GOI REPO DE CRUD TABLE ACCOUNT

        //gui noti KO BIET CHINH XAC LA DICH VU NAO GUI: SMS, MAIL, WHATSAPP
        noti.sendNoti(to, message);
    }
}
