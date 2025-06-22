package com.thou.tightcoupling;

public class MainTightCoupling {
    public static void main(String[] args) {
        //class main nay dong vai ui, controller, goi, dieu khien nhung class o tang duoi: service, repo, jpautil...
        //sau nay thay bang web page, gui...
        UserService userService = new UserService();  //new Service co san trong long 2 dependency: Repo va EmailSender
        userService.registerUser(new Account());
    }
}
