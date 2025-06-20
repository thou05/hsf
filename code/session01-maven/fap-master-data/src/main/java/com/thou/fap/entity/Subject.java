package com.thou.fap.entity;

//class nay dung luu thong tin mon hoc
public class Subject {
    private String code; //ma mon hoc
    private String name; //ten mon hoc
    private int credits; //so tin chi
    private double hours; //so gio hoc

    /* KHI CHOI VOI TABLE
          - CLASS SE MAP THANH CAU TRUC TABLE
          - NEW SUBJECT("SWT301" "Software Testing", 3, 45.0);
          tuong ung voi tung dong trong table ~ insert into
          CLASS -------- TABLE (den tu ERD)
          NEW   -------- INSERT INTO

      BAT BUOC CLASS PHAI CO NHUNG THU SAU KHI CHOI VOI CSDL
          - CONSTRUCTOR rong (EMPTY CONSTRUCTOR - CTOR) - khong tham so, khong cau lenh
          - CTOR full tham so (do toan bo info vao object)
          - getter/setter
          - toString() - de in ra thong tin cua object (co the co hoac khong)

          PHAI CHUOI, GENERATE... -> CHON MUC TUONG UNG
            (ALT + INSERT)
     */


    /* toàn bộ đoạn code này rất quan trọng vì giúp ta tạo ra object
       1 cách linh hoạt (tạo - new, chỉnh sửa - set, hỏi info - get, show info - toString)

       nhưng nhàm chán, ko thèm tư duy gì thêm
       đoạn code nhàm chán, nhưng vẫn phải làm, ko thể thiếu
       => gọi là BOILER PLATE

     */
    public Subject() {
    }
    public Subject(String code, String name, int credits, double hours) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.hours = hours;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", hours=" + hours +
                '}';
    }
}
