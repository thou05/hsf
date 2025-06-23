package com.thou.loosecoupling.di.v2setter;

public class EmailSender {
    public void sendEmail(String recipient, String message){
        //todo: logic xu li gui email: setup account de dong vai nguoi gui (from- minh gui, app gui)
        //todo: format email cho pro...

        //thong bao thanh cong
        System.out.println("(DI V2 - Setter): Mail was sent to: " + recipient + " successfully!!!\nEmail contents: " + message);
    }
}
