package com.thou.loosecoupling.di.v3finalfantasy;


public class MainV3 {
    public static void main(String[] args) {
        //gui mail confirm khi dki
        EmailSender emailSender = new EmailSender();

        //DUNG SERVICE
        UserService service = new UserService(emailSender);  //TIEM QUA CTOR

        service.registerAccount("thaole@gmail.com", "OTP via email...");

        //tui muon gui qua sms
        SmsSender smsSender = new SmsSender();
        //chich vao service tren qua set, ko new service moi
        service.setNoti(smsSender);
        service.registerAccount("0986.666.789", "confirm OTP 8386 pls");

        WhatsAppSender whatsAppSender = new WhatsAppSender();
        //ko them sua service, choi voi tuong lai
        //CLOSE FOR MODIFICATION
        service.setNoti(whatsAppSender);  //choi voi tuong lai, ko sua code cu service, hard-code la toang, phai sua code nhieu noi
        service.registerAccount("+1-225-555-1002","OTP: 2204");

        //GUI TIN NHAN QUA TELEGRAM, DISCORD!!
        //LE THUONG: CODE THEM CLAS SLE - CONCRETE CLASS VA IMPLEMENTS NOTI-SERVICE
        //PRO: CLASS ON THE GO, TAKE AWAY, ANONYMOUS CLASS
        //NEW LUON INTERFACE, AN DON
        // IMPLEMENTS NGAY CODE NGAY LUC NEW!!

        NotiService tele = new NotiService() {
            @Override
            public void sendNoti(String to, String message) {
                System.out.println("ANONYMOUS CLASS, DI, OCP | To: " + to + "; Message: " + message );
            }
        };  //VIP DUNG QUEN CHAM PHAY
        service.setNoti(tele);
        service.registerAccount("thaole", "DI, INTERFACE MAI DINH MAI DINH");
    }

}
