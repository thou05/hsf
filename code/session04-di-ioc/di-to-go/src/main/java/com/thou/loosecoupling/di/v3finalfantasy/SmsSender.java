package com.thou.loosecoupling.di.v3finalfantasy;

//TUI RAT GIOI GUI SMS, NGUYEN LY SRP
public class SmsSender implements NotiService{
    public void sendSms(String phone, String message){
        //1. todo: logic xu li gui email:
        //2. thong bao cau thanh cong khi gui mail

        System.out.println("(DI V3 - OCP): SMS was sent to: " + phone + " successfully!!!\nSMS contents: " + message);
    }

    @Override
    public void sendNoti(String to, String message) {
        sendSms(to, message);
    }
}

//EXTENSION, CODE MOI THEM, TRUOC DO CHUA CO, CO NGON KO SUA CLASS SERVICE
