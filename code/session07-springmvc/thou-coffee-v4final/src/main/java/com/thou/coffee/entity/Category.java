package com.thou.coffee.entity;

import jakarta.persistence.*;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;  //key tu tang phai la Long wrapper (long)

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;   //id va name danh cho drop-down, combobox xo xuong

    @Column(name = "Description", columnDefinition = "NVARCHAR(155)")
    private String description;  //gay nhieu

    //MAPPING MOI QUAN HE 1 - N
    //1 CATE ---< PRODUCT - List<Product>
    @OneToMany(mappedBy = "cate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

    //cac ham de bo sung san pham vao cate, hay cho san pham ra khoi cate
    //list product cua cate ban dau la rong, tu tu vao/ra

    public void addProduct(Product o) {
        productList.add(o);  //o ban vao danh sach cua cate to
        //ve nguoc lai, ban o cung phai flex rang da get to, thuoc ve doi to
        o.setCate(this);
    }

    public void removeProduct(Product o) {
        productList.remove(o);
        o.setCate(null);
    }


    public Category() {
    }

    //key tu tang phai loai thanh key ra khoi ctor
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    @Override
    public String toString() {
        return "Category{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
