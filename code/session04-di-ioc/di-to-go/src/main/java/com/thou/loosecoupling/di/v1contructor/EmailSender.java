package com.thou.loosecoupling.di.v1contructor;

public class EmailSender {
    //TO EMAIL-SENDER RAT GIOI VU GUI MAIL
    //SRP THỎA!!
    public void sendEmail(String recipient, String message){
        //todo: logic xu li gui email: setup account de dong vai nguoi gui (from- minh gui, app gui)
        //todo: format email cho pro...

        //thong bao thanh cong
        System.out.println("(DI): Mail was sent to: " + recipient + " successfully!!!");
    }
}
