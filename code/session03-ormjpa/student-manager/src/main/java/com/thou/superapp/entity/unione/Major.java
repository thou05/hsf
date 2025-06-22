package com.thou.superapp.entity.unione;

import jakarta.persistence.*;

import java.util.*;

//@Entity
//@Table(name = "Major")
public class Major {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    //THIEU COLUMNDEF SE THANH VARCHAR(255)
    private String id; //ma chuyen nganh

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    //HONG DUNG @Nationalized nua, de doc lap Hibernate, de dang chuyen sang choi voi ORM JPA Driver khac
    private String name; //ten chuyen nganh


    //CAU TRONG CSDL, CAU TRONG DOI THUONG: 1 MAJOR CO NHIEU SINH VIEN
    //MUON LUU NHIEU INFO, LIST/ARRAYLIST THANG TIEN, OBJECT NAY THAM CHIEU THONG QUA OBJECT KIA

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  //nho cau nay thi bang/table student xuat hien, va no se doi FK/Join Column
    @JoinColumn(name = "MajorId")  //tu tao ben table Many Student 1 cot FK ten la MajorId
    private List<Student> students = new ArrayList<>();
    //de co cu the sv nao, ta goi students.add(1 ban sv dc new dau do), students.add(new Student("SE1", "AN"...));
    //add 1 phan tu vao trong arraylist


    //HAM ADD STUDENT VAO LIST, PUBLIC
    public void addStudent(Student obj) {
        //if else logic kiem soat info ben ngoai di vao trong object
        students.add(obj);
    }

    public Major() {
    }

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
