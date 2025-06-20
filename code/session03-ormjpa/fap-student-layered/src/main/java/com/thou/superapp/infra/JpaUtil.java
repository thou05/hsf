package com.thou.superapp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    /*
    CLASS NAY CHIU TRACH NHIEM KET NOI CSDL THONG QUA DOI TUONG ENTITY-MANAGER-FACTORY,
    HAO RAM, PERFORMANCE TON THOI GIAN DE TAP KENH KET NOI VOI SQL SERVER/MYSQL -> HEAVY CLASS

    NO NEN DUOC KHOI TAO SOM, 1 LAN, 1 INSTANCE, 1 VUNG RAM, 1 OBJECT, SINGLETON

    CHUA KE MOI LAN NO DC TAO RA, CO KHI NO SE TAO MOI TABLE LUON (OPTION CREATE TRONG .XML)
    HOAC NO SCAN LAI CAU TRUC TABLE CO THAY DOI GI KHONG DE CAP NHAT (OPTION UPDATE TRONG .XML)

    KI THUAT VIET CODE MA KHIEN CHO CLASS KO NEW DUOC LAN THU 2, KO DC NEW NHIEU OBJECT
    LO MA GOI NHIEU LAN CAI CLASS NAY, CUNG CHI CO 1 VUNG NEW DC TAO RA
    => STATIC + PRIVATE CONSTRUCTOR

    1 CLASS KHONG CO CONSTRUCTOR -> JVM SE TAO 1 CAI CTOR RONG, VAN NEW DC OKIE

    CAM TAO OBJECT TU MOI CONSTRUCTOR: CLASS KO CO CTOR, VA CTOR RONG MINH PHE LUON
     */

    private static final EntityManagerFactory emf;
    //duy tri ket noi toi csdl, doc file persistence.xml de tao dung/update table
    //heavy load nam o bien nay!!


    static{
        try {
            emf = Persistence.createEntityManagerFactory("com.thou.superapp-PU");
            //load thong tin server tu file persistence .xml
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //CAM NEW CLASS NAY
    //bien emf Factory chi co 1 con duong dc khoi tao, khoi tao 1 lan duy nhat qua doan lenh troi noi static{} o tren
    //KI THUAT SINGLETON DA XONG - 1 OBJECT HEAVY ENTITY-MANAGER-FACTORY TRONG RAM

    private JpaUtil() {
    }

    //CO ONG NHA XUONG FACTORY ROI, DI MOI CAC ONG MANAGER VE QUAN LI CAC @ENTITY
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    //HAM NAY THI NHOM REPOSITORY SE GOI DEN DE NHO VA XUONG TABLE
    //VI NO LA STATIC NEN CHAM XAI LUON
    //JpaUtil.getEntityManager();


    //DONG CUA NHA MAY, KHONG CAN CHOI VOI CSDL NUA
    //KHONG DUY TRI KET NOI NUA KHI APP SHUTDOWN
    public static void shutdown() {
        emf.close();
    }
}
