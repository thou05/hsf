package com.thou.superapp.entity.bidirectional;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.*;

@Entity
@Table(name = "Major")
public class Major {
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(5)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    //1 CHUYEN NGANH CO NHIEU STUDENT, TUC LA MAJOR PHAI CHUA 1 ARRAYLIST STUDENT
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "major")
    //mapBy giup ket noi nguoc voi ban Student, de biet cai major ban ay dang giu co cai major.id khop voi id dang dung hay khong
    //Major noi voi Student qua dac diem Major major ben Student
    //object quan he voi nhau, dung chuan OOP: chi obj ma thoi
    private List<Student> stuList = new ArrayList<Student>();
    //stuList.add(dua 1 sv vao Major)
    //stuList.remove(1 sv doi chuyen nganh)

    //VIET CODE O DAU VOI 2 LENH NAY??
    //NGUYEN LI S TRONG S.O.L.I.D
    //SINGLE RESPONSIBILITY PRINCIPLE
    //THEM XOA SV KHOI CHUYEN NGANH, LA VIEC CUA MAJOR, THI PHAI MAJOR
    //VI CHUYEN NGANH CO NHIEU SV, VIEC SV VAO RA LA VIEC CUA MAJOR
    //2 HAM XOA, NHAP SV THUOC CLASS NAY
    public void addStudent(Student obj){
        stuList.add(obj);
        //nhung chua noi dc sv obj dang co thuc su tro ve, luu info chuyen nganh hay khong, info major cua sv chua dc set gia tri
        //chuyen nganh co ban, nhung ban chua co thong tin chuyen nganh

        //ta can 2 cau: major co sv gia nhap -> done qua stuList.add(obj)
        //student thuoc ve major nay (this) -> done
        obj.setMajor(this);
        //sv obj tro thanh vao major dang dung ne ne this, co du info id, name cua Major
        //chua this gan voi vung new, moi 1 this co 1 new tuong ung
    }

    public void removeStudent(Student obj){
        stuList.remove(obj);
        //1 sv doi nganh
        //chuyen nganh nao chua biet nma k con o list nay
        obj.setMajor(null);
        //tam thoi sv ko con nganh trc do, gio la null chua nganh nao
    }

    //CO CAU QUERY TRONG DB: CHUYEN NGANH SE CO BAO NHIEU STUDENT
    //DB: SELECT * FROM STUDENT WHERE MAJORID = 'SE'
    //OOP: MAJOR NAY DANG CO LIST STUDENT, MINH RETURN LA XONG => HAM GET() TRUYEN THONG

    public List<Student> getStudentList(){
        return stuList;
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
        return String.format("|%3s|%-40s|", id, name);
    }
}

