package com.thou.coffee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "Id",columnDefinition = "CHAR(36)")
    @NotBlank(message = "Id is required")
    @Size(min = 2, max = 36, message = "Id length must be between 2 and thanh hoa characters")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)  //database generate table
    @NotBlank(message = "Name is required")  //validation tu form nhap dua len
    @Size(min = 5, max = 50, message = "Name length must be between 5 and 50 characters")
    @Pattern(
            regexp = "^(\\p{Lu}\\p{Ll}+)(\\s\\p{Lu}\\p{Ll}+)*$",
            message = "Mỗi từ phải bắt đầu hoa, chỉ chứa chữ (Unicode), không số/ký tự đặc biệt, không khoảng trắng thừa"
    )
    private String name;

    @Column(name = "Quantity", nullable = false)
    @NotNull(message = "Quantity is required")
    @Min(value = 5, message = "Quantity must be between 5 and 1000")
    @Max(value = 1000, message = "Quantity must be between 5 and 1000")
    private int quantity;

    @Column(name = "Price", nullable = false)
    @NotNull(message = "Price is required")
    @Min(value = 10_000, message = "Price must be between 10K and 10M")
    @Max(value = 10_000_000, message = "Price must be between 10K and 10M")
    private double price;

    //MAPPING MOI QUAN HE GIUA CATEGORY  ---< PRODUCT
    //1, N PRODUCT BAT KI PHAI THUOC VE 1 CATEGORY
    @ManyToOne
    @JoinColumn(name = "CateId")  //goc nhin DB: cot FK tro sang table cate
    private Category cate; //goc nhin OOP: bien nay link sang Cate nao do

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    public Product() {
    }

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
