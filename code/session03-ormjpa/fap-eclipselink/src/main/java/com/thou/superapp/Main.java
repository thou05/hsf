package com.thou.superapp;

import com.thou.superapp.entity.Lecturer;
import com.thou.superapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thou.superapp.eclipselink-PU");
    //=> CHI CHAY 1 LAN DUY NHAT
    
    public static void main(String[] args) {
        //insertStudent(); //tao bang, chen data qua oop, CODE FIRST
        //insertLecturers();
        getAllStudents(); //select * from style oop, code first

        getAllLecturers();
        //searchLecturers();

        //remove();
        //update();
        //findById();
    }

    public static void update(){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //tim theo key chi tra ra 1 dong
        Lecturer x = em.find(Lecturer.class, 2);//gia tri pk muon tim
        Student y = em.find(Student.class, "SE1"); //id la chuoi
        x.setSalary(25000000); //25M
        y.setGpa(9.2);
        em.getTransaction().commit(); //khoa so 2 hanh dong
        System.out.println("Delete successfully!");
    }
    //KHI LAM CAC HANH DONG XOA, SUA, THEM, ANH HUONG VA THAY DOI HIEN TRANG BD
    //TA PHAI NHET NO VAO TRANSACTION DE THEO DOI: HOAC TAT CA HOAC KHONG GI CA
    //ACID
    public static void remove(){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //tim theo key chi tra ra 1 dong
        Lecturer x = em.find(Lecturer.class, 1);//gia tri pk muon tim
        Student y = em.find(Student.class, "SE3"); //id la chuoi
        em.remove(x);
        em.remove(y);
        em.getTransaction().commit(); //khoa so 2 hanh dong
        System.out.println("Delete successfully!");
    }


    /*
    EntityManager la ong sep quan li cac Entity - chinh la cac class co @Entity quan li cac object tao tu class Entity
        sep co the them persit(); xoa remove(); cap nhat merge(); tim theo PK find(): li do co ham tim theo key vi ta luon co nhu cau thao tac tren 1 dong/row/record cu the trong table
        ngoai ra con co createQuery()
     */
    public static void findById(){
        EntityManager em = emf.createEntityManager();

        //tim theo key chi tra ra 1 dong
        Lecturer x = em.find(Lecturer.class, 2);//gia tri pk muon tim
        Student y = em.find(Student.class, "SE1"); //id la chuoi

        System.out.println("Lecturer info: " + x); //goi tham ten em toString()
        System.out.println("Student info: " + y);

    }



    /*
    HOC THEM VE JPQL: JAVA PERSISTENCE QUERY LANGUAGE
    LA PHIEN BAN DO TU SQL NHUNG DANH CHO THE GIOI OOP, OBJECT
    HIBERNATE CUNG CO PHIEN BAN RIENG CUA NO GOI LA HQL

    SQL: SELECT * FROM Lecturer;

    JPQL: FROM Lecturer;
          SELECT lec FROM Lecturer lec;
              voi moi dong/record lay tu table Lecturer ta new no trong ram
              new Lecturer() va goi vung new nay la lec
              tuc lec = new Lecturer();
              va lap lai cho toan bo record trong table Lecturer
      ADD KET QUA DOC TU TABLE VAO KET QUA CUOI CUNG DUNG LENH SELECT lec
            => SELECT lec tuc la lay tung object lec duoc new tu tung dong trong table Lecturer

     WHERE
     SQL: SELECT * FROM Lecturer WHERE salary > 20_000_000;  //ten cot trong table
     JPQL: FROM Lecturer x WHERE x.salary > 20_000_000; //ten field trong class
            => x la bien object!! khong phai cot trong table

       QUERY ĐỘNG THAM SO WHERE: TRUYEN TU WEB PAGE/FORM -> DEN DAY CO 1 VALUE NAO DO
       JPQL: SELECT x FROM Lecturer x WHERE x.salary = :pSalary
       CO QUYEN DUNG THEM AND, OR NHU SQL CHUAN
       CO QUYEN DUNG TOAN TU LIKE SO SANH GAN DUNG GIA TRI CHUOI
            SQL CHUAN: SELECT * FROM Lecturer WHERE Name Like '%AN%'  -- ten chua chu an
            PSQL: SELECT lec FROM Lecturer lec WHERE lec.name LIKE :pName AND...).setParameter("pName", "%AN%").setParameter(..)
     */
    public static void searchLecturers(){
        EntityManager em = emf.createEntityManager();
//        List<Lecturer> result = em.createQuery("SELECT x FROM Lecturer x WHERE x.salary = :pSalary", Lecturer.class).setParameter("pSalary", 20000000).getResultList();
        //neu ham tra ve object ta co quyen cham tiep thay vi khai bao 1 bien de hung sau do bien cham tiep

        List<Lecturer> result = em.createQuery("SELECT x FROM Lecturer x WHERE x.yob = :pYob", Lecturer.class).setParameter("pYob", 1990).getResultList();

        System.out.println("List of Lecturers (" + result.size() + " records):");

        for (Lecturer x : result) {
            System.out.println(x);
        }
    }
    public static void getAllLecturers(){
       EntityManager em = emf.createEntityManager();
       //luon can co nguoi quan ly cac entity

        //viet cau sql style object, goi la JPQL, HQL
        //kha giong sql truyen thong, nhung la lam viec, select, thao tac tren object, tren class entity chu khong quan tam ten cot trong table nhu jdbc da hoc

        List<Lecturer> result = em.createQuery("SELECT x FROM Lecturer x WHERE x.salary = 20000000", Lecturer.class).getResultList();
        //Lecturer la class, tu do sinh ra object
        //class Lecturer da duoc map thanh table Lecturer o ben khai bao @Entity

        System.out.println("List of Lecturers (" + result.size() + " records):");

        for (Lecturer x : result) {
            System.out.println(x);
        }

        /*
        BIEU THUC LAMBDA - LAMBDA EXPRESSION
        DINH DANG CUC KI CHAT CHE VOI STREAM API , CO CHE XU LY NHIEU DU LIEU O TRONG RAM
        LAMBDA EXPRESSION LA HAM VO DANH, HAM AN DANH, HAM KHONG CO TEN

        DINH DEN KHAI NIEM LAP TRINH HAM - FUNCTIONAL PROGRAMMING
        ham duoc xem la 1 data, va ham la tham so de truyen vao ham khac
         */
        System.out.println("List of Lecturers (using Lambda):");
        result.forEach(x -> {
            System.out.println(x);
        });

        //lam dieu nham nhi voi lambda
//        result.forEach(x ->{
//            System.out.println("The list from 1 to 100");
//            for (int i = 1; i <= 100; i++) {
//                System.out.print(i + " ");
//            }
//        });


        em.close();
        emf.close(); //sau getAll ma khong lam gi nua thi close luon connection
    }

    public static void insertLecturers(){
        Lecturer an = new Lecturer("AN NGUYỄN", 1990, 15_000_000);
        Lecturer binh = new Lecturer("BINH LÊ", 1992, 20_000_000);

        //lôi cổ ông sep quan ly cac entity ra de tao table, chen data vao table Lecturer - option .xml create, hay update deu dc
        //ĐI LAM THAT, CẤM CREATE TREN MAY KHACH HANG NEU TA FIX BUG, UPDATE VI TOANG HET DATA
        EntityManager em = emf.createEntityManager();
        /*
        vi co thay doi tren csdl(table, data) nen can theo doi chat che cac cau lenh
        => dung kai niem TRANSACTION: DO ALL OR NOTHING
        => NGUYEN LY ACID CUA TRANSACTION
         */
        em.getTransaction().begin();  //bat dau theo doi
        em.persist(an);
        em.persist(binh);
        em.getTransaction().commit(); //KHOA SO, HOAC 2 OBJ XUONG DB, KHONG KHONG AI
        em.close();
    }

    //INSERT TAO MOI STUDENT
    public static void insertStudent() {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thou.superapp-PU"); //gui thong so cau hinh server, nha thau jpa, nha thau jdbc cho jpa class lo de tao ket noi toi DB cu the sql server
        //THAY BANG KHOI TAO BIEN STATIC

        EntityManager em = emf.createEntityManager();
        //tao ra 1 object de quan ly cac entity class ~ map ngang sang   table. Class student chiu su quan li cua em/EntityManager
        //em/EntityManager se lo CRUD tren 1 table nao do
        //qua may ham huyen thoai: persist, merge, remove, find
        //TOAN CHOI OBJECT, DANG SAU LA TABLE BI ANH HUONG
        //TU SINH SQL NGAM, VA NO CHO MINH THAY CAU SQL NAY LUON KHI MINH CHAM CAC HAM O TREN .persist(), .merge(), .remove(), .find()

        //chuan bi data student - object - oop
        Student thao = new Student("SE1", "THAO LE", 2005, 8.7);
        Student ngoc = new Student("SE2", "NGOC LE", 2005, 9.0);
        Student thanh = new Student("SE3", "THANH LE", 2005, 9.5);

        //goi sep EntityManager giup CRUD
        em.getTransaction().begin(); //BAT BUOC PHAI CO TRANSACTION KHI CO SU THAY DOI TRONG DB
        em.persist(thao);    //CRATE TABLE DIEN RA NGAM
        em.persist(ngoc);    //GOI LA CODE FIRST, CODE RA TABLE, DATA
        em.persist(thanh);   //INSERT INTO VALUES
        em.getTransaction().commit(); //hoac ca 3 insert thanh cong, hoac khong co thay doi nao
        //select ko can, vi ko thay doi trang thai table
        em.close(); //sa thai ong sep vi da xong

        //emf.close(); //ngat ket noi db vi da xong
        //=>DONG LUON CHA KET NOI NAY, CHI DONG Khi shutdown VI KHONG CON MO CONG TRONG NAY NUA
    }

    //SELECT * DE LAY HET DATA
    public static void getAllStudents() {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.thou.superapp-PU");

        EntityManager em = emf.createEntityManager();
        List<Student> result = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        //HAU TRUONG LA SELECT * FROM Student - SE IN XEM NEU KHAI BAO CAU HINH TRONG FILE .XML

        //QUERY NAY CU PHAP GAN GIONG SQL, NHUNG THEO STYLE OOP, CO OBJECT VA DAU CHAM
        //GOI LA JPQL, HQL


        System.out.println("List of Students:");
        for (Student x : result) {
            System.out.println(x);
        }
        //co the dung bieu thuc lambda de in cung duoc

        em.close();
        //emf.close();
    }
}