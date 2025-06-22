package com.thou.loosecoupling.di.v1contructor;

public class UserService {
    //SRP: TO GIOI VU CRUD TABLE ACCOUNT, TRONG RAM
    //TO CAN 2 DEPENDENCY, MOI THANG LO 1 VIEC
    //USER-REPO VA EMAIL-SENDER
    private UserRepo userRepo;
    //co new hay khong, co la tight-coupling
    //long ra, do la DI @Autowire NGHIA LA DI, NGHIA LA KO FULL CONTROL

    //private EmailSender emailSender = new EmailSender();  full control, ko DI control, ko DI
    //@Autowire - ai do khac new va tiem chich object vao cho minh service
    //spring/springboot lam giup viec new, chich/tiem
    private EmailSender emailSender;  //KO NEW THI PHAI DC DUA VAO

    /*
    CO NHIEU CACH DUA OBJ TU BEN NGOAI VAO TRONG 1 CLASS
    1. TRUC TIEP QUA FIELD, BIEN emailSender thanh public- nguy hiem vi pham encapsulation, van muon qua field ma private - dung ki thuat nang cao REFLECTION
        FIELD INJECTION (DUNG REFLECTION, IOC FRAMEWORK)

    2. TRUYEN VAO QUA CONTRUCTOR!!! MLEM NHAT
    TAO OBJECT CHINH MINH QUA CONSTRUCTOR VA NHAN THEM DO QUA THAM SO CONSTRUCTOR
    OBJECT DEPENDENCY DI QUA, DUA QUA CONSTRUCTOR

    3. SETTER - TRUYEN QUA HAM SET()
    NHUNG NEU LUOI KO GOI SET() THIDEPEPENDENCY BI NULL

    4. DUNG FRAMEWORK/THU VIEN BEN NGOAI TU KIEM SOAT VIEC TAO OBJ DEPENDENCY VA TIEM CHICH VAO: SPRING/SPRINGBOOT!
     */

    //chich/tiem 2 thang dependency tu ngoai vao trong minh service qua constructor
    // y chang truyen uob, gpa -> 2 thang nay primitve, value thuan
    public UserService(UserRepo userRepo, EmailSender emailSender) {
        this.userRepo = userRepo;
        this.emailSender = emailSender;
    }

    public UserService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void registerAccount(Account obj){
        //todo: dung repo xuong table

        //gui mail hoiii
        emailSender.sendEmail("thaolethi@gmail.com", "...Pls input the OTP...");
    }
}
