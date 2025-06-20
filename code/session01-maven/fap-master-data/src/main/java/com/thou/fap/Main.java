package com.thou.fap;

//import com.thou.fap.entity.Student;
//import com.thou.fap.entity.Subject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thou.fap.entity.*;

import java.lang.runtime.ObjectMethods;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        //tạo mới môn học
        Subject swt = new Subject("SWT301", "software testing", 3, 45.0);
        Subject hsf = new Subject("HSF302", "hibernate & spring framework", 3, 45.0);

        //show info 2 mon
        System.out.println("SWT INFO: " + swt.toString());
        System.out.println("HSF INFO: " + hsf);

        //tạo mới hồ sơ sv
        Student  thao = new Student("SE1", "THAO LE", 2005, 9.0);
        Student thach = new Student("BI2", "THACH PHAM", 1994, 9.5);
        System.out.println("THAO INFO: " + thao.toString());
        System.out.println("THACH INFO: " + thach);

        //CHOI VOI JSON, TU OBJECT THANH JSON VA NGUOC LAI
        //CAN TAO OBJECT QUAN LY JSON TU THU VIEN JACKSON
        //nguyen tac choi voi oop la can co object
        //BE GUI FE, TAO SERVER MOC TU DB LEN CHO CHUOI JSON
        ObjectMapper mapper = new ObjectMapper();
        String thaoJson = mapper.writeValueAsString(thao);
        System.out.println("Lan dau tien chuyen ay, json tu object ma ra: " + thaoJson);

        //TU JSON THANH OBJECT
        //FE GUI BE, TAO CO FORM NHAP, USER SUBMIT INFO, TAO GUI MAY BE JSON, MAY LO THANH OBJECT DI DE XUONG DB

        //String thachJson = "{\"id\":\"SE1\",\"name\":\"THAO LE\",\"yob\":2005,\"gpa\":9.0}"
        String thanhJson = """
                {"id":"SE1","name":"THANH LE","yob":1992,"gpa":8.0}""";
        //jdk 15, rawstring co sao luu vay, co ki tu dac biet giu nguyen, thay bang dau nhay 3 """

        Student thanh = mapper.readValue(thanhJson, Student.class);
        System.out.println("thanh tu json ma ra: " + thanh.toString());
    }
}

/*JSON: JavaScript Object Notation
  kĩ thuật biểu diễn thông tin của 1 object theo cú phát ngôn ngữ javascript

  C#, JAVA: object có dạng như sau
    new Subject("SWT301", "software testing", 3, 45.0);
    new Student("SE1", "THAO LE", 2005, 9.0);
  code trên là 1 code cụ thể, nhưng nhìn text không dễ hiểu, không tự mô tả - self explanation

  JAVASCRIPT THÌ MORE SELF EXPLANATION, NHIN HIEU LIEN
  {
    "code": "SWT301",
    "name": "software testing",
    "credits": 3,
    "hours": 45.0
  }
  {
    "id": "SE1",
    "name": "THAO LE",
    "yob": 2005,
    "gpa": 9.0
  }
  -> TRO THANH CHUAN TRUYEN THONG TIN
     NHIEU DAY DA HIEU, KO CAN GIAI THICH THEM
     DAC BIET UA THICH TRONG WEB API TRONG MO HINH LAM WEB APP FE BE
     FRONT END ----- JSON ----- BACK END
                 AXIOS (REACT)

     TRONG CODE THI TOAN OBJECT
     RA NGOAI TREN MANG, HTTP THI TOAN JSON
     CAN 1 THU VIEN DE GIUP CONVERT QUA LAI JSON - OBJECT
     -> JACKSON, GSON XUAT HIEN


 */