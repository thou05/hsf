package com.thou.superapp.repo;

import com.thou.superapp.entity.Student;
import com.thou.superapp.infra.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepo {
    /*
    CLASS NAY CHUA CAC HAM CRUD TRUC TIEP TABLE STUDENT
    REPO: NHA KHO DU LIEU

    MUON CRUD TABLE THI PHAI NHO VA ONG ENTITY-MANAGER DUOC CUNG CAP TU JpaUtil SINGLETON

    FLOW: UI --- SERVICE --- REPO (HERE) --- JPAUTIL (ENTITY-MANAGER VA FACTORY) --- TABLE

    CAC HAM CRUD O DAY THUONG DAT TEN NGAN GON, HUONG HANH DONG
    GIONG NHU LENH SQL CHUAN (INSERT, UPDATE, DELETE)
    TEN HAM GOI Y: save(), update(), remove(), find(), findAll(), findById()


    TUY HAM, NHUNG NEU CO THAY DOI TRONG TABLE (INSERT, UPDATE, DELETE)
    THI HAM SE NHAN VAO OBJECT (INSERT, UPDATE) HOAC KEY (DELETE)
            DELETE DUA OBJECT VAN DC VI VAO TRONG OBJECT, GET FIELD KEY DE XOA


    NHO DUNG TRANSACTION KHI THAY DOI DATA TRONG TABLE(INSERT, UPDATE, DELETE)
    SELECT THI KHONG CAN, VI KHONG THAY DOI DATA

     */

    //HAM INSERT XUONG TABLE
    public void save(Student obj) {
        //goi EM (Entity Manager) nho giup, kem transaction - co thay doi data
        EntityManager em = JpaUtil.getEntityManager();
        //doan lenh troi noi static{} chay duy nhat 1 lan, khoi dong heavy connection
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        //try catch khi save bi loi -- tu tu sau
        em.close();
    }

    //HAM LAY TAT CA SINH VIEN - JPQL SELECT s FROM Student s
    public List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("FROM Student", Student.class).getResultList();
    }

    //SUA THONG TIN SINH VIEN - CAP NHAT
    public void update(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(obj);
        /*
        merge() nghia la tich hop object dua vao trong EM
        EM no se do ngang, copy ngang obj vao TRONG obj dung voi dong trong table
        neu co tinh dua obj ma key khong ton tai trong table, se insert moi
         */
        em.getTransaction().commit();
    }
    public void delete(Student obj) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
    }
    public void delete(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        Student x = em.find(Student.class, id);
        //tim sv co id = id dua vao, goi la x
        //va remove x, remove obj giong tren
        em.remove(x);

        //em.remove(em.find(Student.class, obj));  => viet gop
        em.getTransaction().commit();
    }

    //todo at home: lam them ham where theo cot nao do, findById tra ve 1 student

    public Student findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        return em.find(Student.class, id);
    }
}
