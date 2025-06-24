package com.thou.spring.noioc;

public class MainNoIoC {
    //noi tao ra obj, tao ra dependency, tiem chich vao trong obj chinh
    //ioc container - inversion of control container
    //em kiem soat nhung dua phu thuoc, em tiem chich chung vao cho anh
    //IOC HANDMADE TU TRONG, CHUA PHAI HANG XIN DEN TU SPRING
    public static void main(String[] args) {
        PdfGenerator gen = new PdfGenerator();

        //ContractService service = new ContractService(new PdfGenerator());
        ContractService service = new ContractService(gen);
        service.processContract();
    }
}
