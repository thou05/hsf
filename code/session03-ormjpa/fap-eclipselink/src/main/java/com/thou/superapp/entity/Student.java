package com.thou.superapp.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.persistence.*;
//import org.hibernate.annotations.Nationalized;

//CLASS NAY SE DUOC KHAI BAO DE
//ANH XA/MAP THANH TABLE TUONG UNG
@Entity
@Table(name = "Student")  //neu khong co khai bao nay thi mac dinh lay ten class thanh ten table

public class Student {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)") //neu khong co khai bao nay, thi mac dinh lay ten field lam ten cot
    //columnDefinition = "CHAR(8)" de chi dinh kieu du lieu cua cot trong DB, neu khong co thi mac dinh la VARCHAR

    private String id; //id tu nhap

    @Column(name = "Name", nullable = false, length = 50, columnDefinition = "NVARCHAR(50)")
    //@Nationalized
    /*thieu khai bao nay thi string -> varchar, khong co unicode. de string -> nvarchar thi can them khai bao nay

     TA DÙNG @NATIONALIZED se mat di tinh khả chuyeern khi code nay khong the choi duoc voi eclipselink
      => ĐỘ VARCHAR CHOI VOI NHIEU NHA CUNG CAP ORM/JPA QUA COLUMNDEFINITION

     */
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    //BAT BUOC PHAI CO CONTRUCTOR RONG, CONTRUCTOR FULL PARAMETER
    //GET/SET/TOSTRING()
    //BOILER-PLATE, LOMBOK
    //THEM DEPENDENCY LOMBOK VAO POM.XML SAU


    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                '}';
    }
}
