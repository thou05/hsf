package com.thou.superapp.entity.unimany;

public class MainUniMany {
    public static void main(String[] args) {

    }

    public static void createMajorStudents(){
        Major se = new Major("SE", "SOFTWARE ENGINEERING");

        Student thao = new Student("SE1", "THAO LE", 2005, 8.6);
        Student ngoc = new Student("SE2", "NGOC LE", 2005, 8.9);

        //XUONG DB THI PHAI NHO JPAUTIL, CAN CO NHA XUONG FACTORY (KET NOI SQL SERVER)
        //TIEP: MUON ONG GIAM DOC GIAM SAT CAC ENTITY ENTITYMANAGER, CHUYEN XU LI DAM @ENTITY
        //THEM XOA SUA DB THI PHAI NHO CO TRANSACTION

    }

}
