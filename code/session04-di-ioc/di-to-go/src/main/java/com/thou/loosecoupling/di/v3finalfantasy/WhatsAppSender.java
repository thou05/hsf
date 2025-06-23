package com.thou.loosecoupling.di.v3finalfantasy;

//MO CHO THEM MOI - OPEN FOR EXTENSION, MOI HOAN TOAN
public class WhatsAppSender implements NotiService{
    @Override
    public void sendNoti(String to, String message) {
        System.out.println("(DI V3 - OCP): Instance WhatsApp message was sent to: " + to + " successfully!!!\nMessage contents: " + message);
    }
}
