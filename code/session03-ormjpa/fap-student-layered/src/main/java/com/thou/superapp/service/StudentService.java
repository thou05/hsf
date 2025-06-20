package com.thou.superapp.service;

import com.thou.superapp.entity.Student;
import com.thou.superapp.repo.StudentRepo;

import java.util.List;

public class StudentService {
    /*
    CLASS NAY DUNG GIUA, HUNG INFO TU USER, TAO OBJECT, DAY XUONG CHO REPO LO GIUP
    NO CUNG NHO REPO LAY OBJECT TU TABLE, DAY NGUOC LEN UI CHO USER XEM

    CHAC CHAN NO PHAI KHAI BAO BIEN REPO DE REPO GIUP
    CHI CAN 1 BIEN REPO DUNG CHUNG CHO CAC HAM, DO MINH GOI BEN TRONG REPO
    .save  .findAll() ...

    CLASS NAY PHAI CHUAN BI OBJECT DE DUA XUONG REPO

    TEN HAM CLASS NAY DAT THUONG GAN GUI VOI USER HON, DO GAN USER GAN HON DB
    MINH LA SERVICE CUNG CAP DATA CHO USER, NHAN THAU DATA TU USER

    TEN HAM GOI Y:
        createStudent()   getAllStudent()   updateStudent
        deleteStudent() ...

    //FLOW: UI --- SERVICE (HERE) --- REPO --- JPAUTIL (ENTITY-MANAGER VA FACTORY) --- TABLE

     */

    private StudentRepo studentRepo = new StudentRepo();
    public void createStudent(Student obj) {
        //can repo, dung rieng hay chung deu okie
        //TODO: CHECK TRUNG KEY, EMAIL, VALIDATE...
        //TODO: BAT TRY-CATCH THONG BAO...

        studentRepo.save(obj);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    //todo: ques ? MINH CO THE TAO SINGLETON CHO REPO VA SERVICE HAY KHONG

    public void updateStudent(Student obj) {
        studentRepo.update(obj);
    }
    public void deleteStudent(Student obj) {
        studentRepo.delete(obj);
    }
    public void deleteStudent(String id) {
        studentRepo.delete(id);
    }
}
