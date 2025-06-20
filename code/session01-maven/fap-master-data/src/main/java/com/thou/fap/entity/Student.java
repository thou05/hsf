package com.thou.fap.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// tất cả thay bằng @Data là đủ


public class Student {
    private String id;
    private String name;
    private int yob;
    private double gpa;

    //ĐOẠN CODE BOULER PLATE NHÀM CHÁN: 2 CTOR, GET/SET, toString
    /*
    ta không thèm làm theo cách truyền thống, nhưng vẫn phải làm theo cách nào đó
    -> ta dùng thêm thư viện trên mạng giúp ta genarate đám này tự động
    -> LOMBOK DEPENDENCY

    LOMBOK là hàng ae mạng, ko phải chính hãng jdk
    trong c# có hàng chính hãng -> kĩ thuật property có sẵn trong .net sdk

    ta đi tải thư viện lombok qua file pom.xml
    thư việntự đc add vào project, ta chỉ việc dùng các class có trong thư viện tải về
    -> lên kho tổng mvnrepository.com -> tìm kiếm lombok, tìm hồ sơ, add vào pom.xml
    -> click ctrl + shift + o để tải và add
     */
}
