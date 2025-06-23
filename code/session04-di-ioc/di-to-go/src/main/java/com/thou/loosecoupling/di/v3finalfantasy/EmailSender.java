package com.thou.loosecoupling.di.v3finalfantasy;


//TUI RAT GIOI GUI EMAIL, 1 CHUYEN NAY MA THOI
//NGUYEN LI SRP - SINGLE RESPONSIBILITY
//DON TRACH NHIEM, 1 CLASS CHI TAP TRUNG VAO 1 CHU THE: EMAIL
//OM THEM SMS, WHATSAPP, VI PHAM SRP


//TUI GIA NHAP HOI NOTI, VAY TUI PHAI THEO QUY TAC HOI, THEO HOP DONG CAM KET TUAN THU QUY TAC, CODE CHO HAM ABSTRACT SENDNOTI()
//va may man thay, tui email-sender la thanh vien noti-service, nay tui dc dung, va dung dc o class service, vi service chi choi voi noti-service
public class EmailSender implements NotiService {
    public void sendEmail(String recipient, String message){
        //1. todo: logic xu li gui email:
        //2. thong bao cau thanh cong khi gui mail

        System.out.println("(DI V3 - OCP): Mail was sent to: " + recipient + " successfully!!!\nEmail contents: " + message);
    }

    @Override
    public void sendNoti(String to, String message) {
        sendEmail(to, message);
    }
}
