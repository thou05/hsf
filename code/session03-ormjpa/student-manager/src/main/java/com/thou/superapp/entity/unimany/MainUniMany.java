package com.thou.superapp.entity.unimany;

import com.thou.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

public class MainUniMany {
    public static void main(String[] args) {
        createMajorStudents();

    }

    public static void createMajorStudents(){
        Major se = new Major("SE", "SOFTWARE ENGINEERING");

        Student thao = new Student("SE1", "THAO LE", 2005, 8.6);
        Student ngoc = new Student("SE2", "NGOC LE", 2005, 8.9);
        thao.setMajor(se);
        ngoc.setMajor(se);
        //set 2 ku vao chuyen nganh, neu khong 2 cta ko thuoc ve major


        //XUONG DB THI PHAI NHO JPAUTIL, CAN CO NHA XUONG FACTORY (KET NOI SQL SERVER)
        //TIEP: MUON ONG GIAM DOC GIAM SAT CAC ENTITY ENTITYMANAGER, CHUYEN XU LI DAM @ENTITY
        //THEM XOA SUA DB THI PHAI NHO CO TRANSACTION
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        //LUUW MAJOR TRUOC
        //LUU STUDENT SAU, KHONG DO DOMINO DC
        //DOMINO: 1->N, ap dung cho 1 dam bi anh huong..., 1 major app dung chung cho 1 nhom student
        em.persist(se);
        em.persist(thao);
        em.persist(ngoc);
        em.getTransaction().commit();
        em.close();
    }

}
