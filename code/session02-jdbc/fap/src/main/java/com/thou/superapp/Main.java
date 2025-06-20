package com.thou.superapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        //Ta se dung cac class duoc cung cap san boi jdk co trong thu vien jdbc
        //jdbc nay se tu dong ket noi voi sgl server jdbc driver
        //cua hang ms giup dieu khien ga vo dien sgl server hau truong

        //tuong tu cho mysql, ta can them driver
        Connection conn = null;
        try {

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=HSF302;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String pass = "thou";
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //jdbc hien nay tu dong di tim sql server driver hoac mysql driver thong qua dau hieu tron g url o tren
            conn = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Connect to DB successfully");

            //ket noi thanh cong thang vo dien - server hau truong thi bat dau
            //moc noi table qua cau sql

            //tao class preparedstatement dung quan ly cau sql (where. tham so)
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Subject");
            ResultSet rs = stm.executeQuery(); //thuc thi cau sql va tra ve resultset
            /*na na giong arraylist, chua nhieu dong/record, moi dong la info cua mon hoc
                code | Name | Desc | Credits | StudyHours
              CHOI JDBC THI PHAI NHO TEN COT, MANG HOI HUONG DB FIRST, DB ORIENTED
              VONG LAP LAY CAC DONG, MOI DONG CHU DONG NHO TEN COT TABLE, LAY COT
              => NHUOC DIEM CUA JDBC THUAN
             */

            while (rs.next()) {
                //ten cot la gi, data type cua ten cot la gi, phai nho moi lay dc
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                String desc = rs.getString("Description");
                int credits = rs.getInt("Credits");
                int hours = rs.getInt("StudyHours");

                //System.out.println(code + " | " + name + " | " + credits + " | " + hours);

                System.out.printf("|%10s|%-40s|%2d|%4d|\n", code, name, credits, hours);
            }
            conn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}