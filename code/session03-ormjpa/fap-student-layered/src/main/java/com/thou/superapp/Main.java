package com.thou.superapp;

import com.thou.superapp.entity.Student;
import com.thou.superapp.service.StudentService;

public class Main {
    public static void main(String[] args) {
        //FLOW: UI (HERE) --- SERVICE --- REPO --- JPAUTIL (ENTITY-MANAGER VA FACTORY) --- TABLE

        StudentService studentService = new StudentService();
        //1. TAO MOI HO SO SV
//        Student an = new Student("SE10", "AN NGUYEN", 2005, 8.6);
//        studentService.createStudent(an);
//        studentService.createStudent(new Student("SE11", "BINH LE", 2005, 8.7));

        //2. SHOW ALL
        System.out.println("The list students");
        studentService.getAllStudents().forEach(x -> System.out.println(x));

        //3. UPDATE 1 HO SO SV
//        Student an = new Student("SE10", "AN NGUYEN VAN", 2005, 9.2);
//        studentService.updateStudent(an);
//        System.out.println("The list student after updating");
//        studentService.getAllStudents().forEach(x -> System.out.println(x));


        //4. REMOVE 1 HO SO SV
        studentService.deleteStudent("SE11");
        System.out.println("The list student after deleting");
        studentService.getAllStudents().forEach(x -> System.out.println(x));

    }
}