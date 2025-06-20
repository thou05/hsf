package com.thou.superapp.entity;

import jakarta.persistence.*;

@Entity //map class thanh 1 table tuong ung so cot trong field
@Table(name = "Lecturer") // table co the khac ten voi class

public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tu gen key la con so tu tang tu 1
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)",length = 50, nullable = false) //NVARCHAR NOT NULL
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Salary", nullable = false)
    private double salary;

    /*
    Co the dung lonbok de loai bo boilerplate code
    nhung bat buoc phai co:
        constructor rong
        constructor full parameter
        getter/setter
        toString()
     */

    public Lecturer() {
    }

    //FULL THAM SO, BOT DI COT TU TANG, VAN LA FULL
    //cai nay nhieu khi lombok k xu li dc nen phai viet han ra
    public Lecturer(String name, int yob, double salary) {
        this.name = name;
        this.yob = yob;
        this.salary = salary;

    }
    //=> khong co id vi tu tang


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", salary=" + salary +
                '}';
    }
}
