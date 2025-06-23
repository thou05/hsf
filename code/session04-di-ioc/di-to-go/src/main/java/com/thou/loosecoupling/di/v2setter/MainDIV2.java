package com.thou.loosecoupling.di.v2setter;

public class MainDIV2 {
    public static void main(String[] args) {
        //dependency da lo dien ra ngoai qua setter, nha minh can bac tho o noi khac den giup, tiem chich dependency vao qua setter
        EmailSender sender = new EmailSender();  //ta co ham gui mail roi
        //IoC


        //viec chinh, la cua class userservice
        UserService service = new UserService();
        //chua moi bac tho, vi ko dung constructor, ma di qua set
        service.setSender(sender);   //TIEM DEPENDENCY VAO ROI
        service.registerAccount(new Account());
    }
}


/*
HAM MAIN() HAY CLASS MAIN NAY LA NOI CHUA OBJ DEPENDENCY, VI NO CHU DONG NEW EMAIL-SENDER() LA DEPENDENCY

NOI CHUA CAC OBJ DEPENDENCY (DC NEW) THI GOI LA CONTAINER
VA CODE CHINH CUA TA KO NEW OBJ DEPENDENCY NGAM, MA CHU DONG DE NOI KHAC NEW, NOI KHAC TIEM CHICH VAO, TA DA DAO NGUOC (INVERT) TIEN TRINH QUAN LI OBJ

TA KO THAM LAM KIEM SOAT HET VIEC TAO OBJ DEPENDENCY, MA CHIA BOT RA CHO DUA KHAC TAO, ROI TIEM CHICH VAO, CHUYEN QUYEN KIEM SOAT TAO OBJ CHO NGUOI KHAC, MINH TAP TRUNG DUNG, GOI LA IoC, Inversion of Control


IOC: LA LOI KHUYEN, PRINCIPLE,NOI THOI VE Y TUONG BOT KIEM SOAT LAI MOI CHUYEN
DI: LA CACH LAM CU THE, IPLEMENT
IOC CONTAINER, CONTAINER: NOI CHUA OBJ DEPENDENCY
SPRING: CHINH LA IOC CONTAINER, THAY CHO MAIN, NHUNG CHAC CHAN KHUNG HON
 */
