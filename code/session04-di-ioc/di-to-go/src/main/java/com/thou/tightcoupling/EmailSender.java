package com.thou.tightcoupling;

public class EmailSender {
    //TUI, GA RAT GIOI, CHUYEN GUI EMAIL, KO DINH DANG GI DEN SMS, WHATSAPP
    //TUI THOA NGUYEN LI S/SRP TRONG SOLID
    //TUI CHỈ CHỨA HÀM, NHIỀU HÀM CHUYÊN LIÊN QUAN EMAIL - 1 CHỦ THỂ
    //SAU NÀY NÂNG CẤP CODE, CŨNG CHỈ LÀ XOAY QUANH EMAIL, 1 LÍ DO/CHỦ THỂ SỬA ĐỔI MÀ THOI
    //       to:         nội dung mail
    //ham nay gui mail toi nguoi dki account, thong tin email nhap tu man hinh dki, di qua Controller den Service den day
    //email cua user dang ki nam trong Account entity (don gian), nam trong AccountDto (ban cat bot field tu Entity)
    public void sendEmail(String recipient, String message){
        //todo: logic xu li gui email: setup account de dong vai nguoi gui (from- minh gui, app gui)
        //todo: format email cho pro...

        //thong bao thanh cong
        System.out.println("Mail was sent to: " + recipient + " successfully!!!");
    }
}
