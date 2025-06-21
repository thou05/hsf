package com.thou.superapp.entity.unione;

import com.thou.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniOne {
    //NHO VA JPAUTIL, CO HAM DOC FILE PERSISTENCE.XML
    //DE KET NOI DUNG CSDL, DUNG DRIVER VA GIUP TAO RA ONG QUAN LY ENTITY ENTITY-MANAGER
    public static void main(String[] args) {
        createMajorStudents();
    }

    public static void createMajorStudents(){
        //ta tao chuyen nganh SE, va 2 sv cua nganh nay
        Major seMajor = new Major("SE", "SOFTWARE ENGINEERING");

        Student s1 = new Student("SE1", "THAO LE", 2005, 3.7);
        Student s2 = new Student("SE2", "NGOC LE", 2005, 3.5);

        //seMajor can phai add 2 student s1 s2 vao cai List students
        seMajor.addStudent(s1);
        seMajor.addStudent(s2);
        //OOP DA XONG VE RELATIONSHIP
        //TIEP THEO: XUONG TABLE, DO DOMINO - CASCADE 1 MAJOR, N STUDENT XUONG LUON THEO
        //                                    ONE DI XUONG, MANY DI THEO

        //NHO JPAUTIL CHUAN BI NHA XUONG FACTORY, MOI GIAM DOC VE QUAN LI ENTITY ENTITYMANAGER
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(seMajor);   //Major di xuong 2 Students theo sau
        em.getTransaction().commit();
        em.close();
    }

}
