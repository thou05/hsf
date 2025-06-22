package com.thou.superapp.entity.bidirectional;

import com.thou.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MainBiOneMany {
    public static void main(String[] args) {
        //createMajorStudents();
        getAll();
    }

    //LAY DANH SACH SV, DS CHUYEN NGANH
    //EM ENTITYMANAGER CO HAM LOI HAI
    // find(ten class, key) -> tra ve duy nhat 1 dong theo key
    // .createQuery(cau JPQL) -> tra ve 1 list, list 1 dong hay nhieu dong tuy cau where

    //vi oop 2 chieu, nen khi lay dc 1 major se, ko can where gi nua
    // vao thang list cua se la lay full student cua se
    // ta lay qua object major ma lai co list cua student, vi major co nhieu sv
    //thay vi choi truc tiep table student

    public static void getAll(){
        EntityManager em = JpaUtil.getEntityManager();
        Major se = em.find(Major.class, "SE");
        System.out.println("SE major info: " + se);

        List<Student> stuList = se.getStudentList();  //khong lazy nua

        //in bang bieu thuc lambda
        System.out.println("the se students");
        stuList.forEach(x -> System.out.println(x));
    }

    public static void createMajorStudents(){
        Major se = new Major("SE", "SOFTWARE ENGINEERING");
        Major gd = new Major("GD", "GRAPHICS DESIGN");

        Student thao = new Student("SE1", "THAO LE", 2005, 8.6);
        Student ngoc = new Student("SE2", "NGOC LE", 2005, 8.7);
        Student duong = new Student("GD1", "DUONG NGUYEN", 2005, 8.6);
        Student linh = new Student("GD2", "LINH NGUYEN", 2005, 8.7);

        //ket noi chuyen nganh style object
        se.addStudent(thao);
        se.addStudent(ngoc);
        gd.addStudent(duong);
        gd.addStudent(linh);

        //moi giam doc entitymanager ve quan li dam @entity
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(se);  //do domino
        em.persist(gd);
        em.getTransaction().commit();
        em.close();
    }
}
