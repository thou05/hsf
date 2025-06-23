Created: 202506222210

Tags: 

- GIẢI NGỐ VỀ DI - DEPENDENCY INJECTION
	- DEPENDENCY
	- DEPENDENCY INJECTION (TIÊM, CHÍCH - ĐƯA THỨ BÊN NGOÀI VÀO TRONG)
	- TIGHT COUPLING, LOOSE COUPLING
	- S, O, D (SOLID)
	- IoC (Inversion of Control)
	- IoC Container
	- ...
	
	 => kĩ năng, kiến thức ở trên phi ngôn ngữ, nó có thể áp dụng chung cho mọi ngôn ngữ lập trình, áp dụng cho việc thiết kế app, chia code thành các thành phần để dễ kiểm soát, bảo trì, nâng cấp, mở rộng
	 
	 => dùng để đi trả lời phỏng vấn

## DEPENDENCY LÀ GÌ?
- Nếu class A khai báo biến thuộc class B, cần B để giúp cviec gì đó mà B chuyên trách, B giỏi, thì B gọi là dependency của A. Nói cách khác A phụ thuộc vào B, thì B là dependency của A

```java
public class A{
	B objB;  
	//objB là obj, thuộc, đc clone từ class B
	//B đgl dependency của A, A phụ thuộc vào B để làm việc gì đó
}

public class B{    //giỏi việc nào đó, chuyên việc nào đó
	//...
	void doSomething(){}
}
```

- Dependency còn là các thư viện lập trình (chẳng qua gồm bên trong nhiều class làm việc gì đó rất giỏi), ta có jdbc dependency, junit dependency, lombok dependency, hibernate, jpa dependency

- A phụ thuộc vào B, B là dependency của A, tức là 2 class có gắn kết, cần nhau (A cần B đúng hơn) gọi là coupling
	- gắn kết chặt chẽ hay lỏng lẻo?

## TIGHT COUPLING, LOOSE COUPLING
- CHẮC CHẮN PHẢI DÍNH DÁNG DEPENDENCY, CLASS NÀY CẦN CLASS KIA

### TIGHT COUPLING - GẮN KẾT, PHỤ THUỘC CHẶT CHẼ
- Class A cần class B, quản lí luôn vòng đời object class B (tạo, hủy) trong lòng class A

```java

public static void main(){
	A objA = new A();
	//khi new A đã có ngay B bên trong lòng
	//có A là đã có B
}

public class A{
	B objB = new B()  //tight coupling;  
	
}

public class B{  
	//...
	void doSomething(){}
}
```

- VẤN ĐỀ CỦA TIGHT COUPLING
	- A chỉ chơi với B mà thôi
	- Khi B chưa code xong, thì khó có thể run A
	- Nếu muốn thay thế B bằng B' tương đương về khả năng giải quyết vấn đề (thay hibernate bằng eclipselink), thì chắc chắn phải cửa code của A
- VD DEMO
	- ta cần làm app, trong đó có chức năng đki member- register an account/sign up
	- UI (form đki)
		- gõ username/pass/re-pass, email, phone, whatsapp id
		- nhấn nút đki
	- .... (qua nhiều lớp khác)   `|||||||||||`
	- UserService (Business Logic Layer - BLL)
		```
		hàm/method registerAccount(Accoung obj){
			- //obj: chữa user, pass, email, phone, whatsappid...
			- code phải gọi UserRepository - chuyên giỏi CRUD table Account - dependency
			- gửi mail confirm hoặc gửi sms confirm hoặc gửi noti đến whatsapp
		}
			|||||          ||||
					TÁCH CODE RIÊNG RA KHỎI UserService
					thành Service riêng lo SMS, Mail, WhátApp
		```
	- UserRepository (Data Access Layer - DAL)
		- hàm CRUD table Account, dùng JPA/Hibernate/JpaUtil -> Spring JPA
	- NOTE: làm app có liên quan gửi mail thì phải tạo account riêng, đừng dùng mail cá nhân hay mail trường, vì vấn đề về bảo mật
	-                   `|||||||||||||`
	-                   TABLE ACCOUNT
	- USER SERVICE CÓ 2 DEPENDENCY
		- 1. UserRepository - chuyên lo CRUD
		- 2. Noti sender - gã chyên lo sms, mail, whatsapp

- class A khai báo biến obj của class B và new luôn B() trong class A. A kiểm soát obj B 
	- => TIGHT COUPLING, FULL CONTROL OBJECT B, HARD-CODED DÊPNDENCY TRONG LÒNG A, CODE A CÓ CỨNG SẴN OBJECT B
	- DIRECT CONTROL, A TRỰC TIẾP KIỂM SOÁT B
### LOOSE COUPLING
- A THẢ LỎNG B RA, KHÔNG KIỂM SOÁT B CHẶT CHẼ NỮA, DEPENDENCY LỘ DIỆN RA NGOÀI THẢ LỎNG RA, THẬM CHÍ KHÔNG NEW B TRONG A
- XEM THÊM: DEPENDENCY INJECTION, IOC, CONTAINER
## S TRONG SOLID - SRP - SINGLE REPONSIBILITY PRINCIPLE
- Mỗi class được thiết kế ra chỉ nên giải quyết 1 công việc nào đó, chuyên biệt để làm 1 việc gì đó nó giỏi. Nó sẽ cung cấp dịch vụ cho bên khác dùng
- Internet: 1 class khi cần chỉnh sửa, thì chỉ có 1 lí do (chủ thể) để chỉnh sửa, 1 chỗ/chủ thể để chỉnh sửa
- vd
	```
	ta có class public class NotiSender{
		- code gửi SMS
		- code gửi Email
		- code gửi WhatsApp
	}
	```
	-  ĐANG VI PHẠM SRP, vì có đến 3 chỗ khác nhau để sửa khi cần nâng cấp code, mở rộng code, fix code, vd
		- sửa sms để support cho tổng đài viettel, mobi, vina
		- sửa sms để support cho gmail, ms mail,...
		- sửa whatsapp
	```
	public class NotiSender{
		- code gửi SMS
		=> đạt SRP vì chỉ có sửa SMS mà hoi
	}
	```

- KHÔNG nhầm lẫn rằng SRP nghĩa là class chỉ có 1 hàm. Mà phải hiểu là 
	- CLASS CÓ NHIỀU HÀM, CÁC HÀM XOAY QUANH 1 CHỦ THỂ, VẬT NÀO ĐÓ, ENTITY NÀO ĐÓ, OBJ NÀO ĐÓ CẦN ĐC XỬ LÍ 
	- Class USER-REPO có 4 hàm CRUD nhưng chỉ xoay quanh user/account table!!! 1 CHỦ THỂ
	- NẾU CÓ NHIỀU CHỦ THỂ CẦN XỬ LÍ TRONG 1 CLASS, VI PHẠM SRP. `NotiSender` chứa cả sms, mail, whatsapp, 3 chủ thể -> vi phạm roài

## DEPENDENCY INJECTION 
- TIÊM/CHÍCH DEPENDENCY VÀO CLASS CHÍNH - CLASS CHÍNH KO CHỦ ĐỘNG KIỂM SOÁT DEPENDENCY NỮA
- CODE CŨ/TIGHT COUPLING, FULL CONTROL, DIRECT CONTROL, HARD-CODE DEPENDENCY `new A();` có sẵn B đc new bên trong, ta nhìn bên ngoài A, ko biết đc rằng trong A có B

- CODE MỚI: KO FULL CONTROL NỮA, THẢ LỎNG RA, B LỘ MẶT, lộ mặt rồi có khả năng bị thay thế -> mở rộng cho tương lai
	
	`newA();` và phải `new B()` ngoài A ,chích/tiêm/truyền/inject `new B()` vào A 
	
	=> LOOSE COUPLING, tao A có, chưa chắc đã có B, dùng B phụ thuộc vào A. 
	
	Tui cần anh, nhưng chưa chắc đã có anh khi có tôi. 
	
	Tui cần anh, anh phải có mặt cho tui nhé


- LỢI ÍCH CỦA VIỆC HẢ LỎNG DEPENDENCY


- Ta class A, class SERVICE đã ko full control, việc tạo object B, mà để việc tạo, việc `new B()` new dependency ở chỗ khác, rồi chích/tiêm vào, ta đã chuyển giao, đảo quyền/giảm quyền kiểm soát dependency  
	
	==> IoC INVERSION OF CONTROL, ĐẢO QUYỀN KIỂM SOÁT VIỆC NEW DEPENDENCY

## IOC
- IoC là 1 nguyên lí thiết kế class phụ thuộc nhau, nó là ý tưởng, là lí tưởng, lí thuyết, lời kêu gọi, chứ nó ko nói cụ thể làm thế nào, nó abstract
- Dependency Injection là phiên bản cụ thể, implement cho IoC
- Ngoài dependency inject, còn 1 vài cách khác để đạt đc IoC, đảm bảo việc class chính ko ôm đồm full control mọi việc, cần thì gọi dịch vụ bên ngoài


```
  rảnh đọc thửu cuốn DESIGN PATTERNS CỦA GoF (Gang of Four)
	 - cứ gặp bài toán X, thì áp dụng cách thiết kế Y trong cuốn này, gồm nhiều class và interface giúp bài toán chúng ta đẹp, mlem ở góc độ dễ bảo trì, nâng cấp, mở rộng mà ko khiến code cũ bị ảnh hưởn quá nhiều
	 - 23 mẫu thiết kế class nổi tiếng áp dụng cho những bài toán đặc trưng, phổ biến
	 - áp dụng triệt để SOLID
	 -> tiệm cận nghề kiến trúc sư phần mềm, SOFTWARE ARCHITECT/SOLUTION ARCHITECT - 4.500$ UP/MONTH ở VN 
```


## NGUYÊN LÍ CHỮ O TRONG SOLID - OCP
- OPEN/CLOSED PRINCIPLE - OCP
- open for extension, closed for modification
- cởi mở cho việc mở rộng code - thêm code cho điều chưa có trước đó
	
	đóng lại cho việc chỉnh sửa code đã có, tránh sửa code cũ nếu có thể
	
	"NẾU CÓ NHU CẦU THÊM TÍNH NĂNG, THÊM MỚI CODE, CỐ GẮNG KO ĐỤNG CODE CŨ, MÀ CHƠI ĐC CODE MỚI"
	
	"THÊM CODE MỚI, KO SỬA CODE CŨ, MÀ CHẠY NGON VỚI CÁI MỚI"

- Thêm tính năng gửi sms, gửi whatsapp, mà thằng userservice ko cần chỉnh code, mà vẫn chơi đc với 2 thằng, thậm chí là nhiều thằng mới hơn trong tương lai
- HOW DO THEY DO THAT? làm sao làm đc OPC?
- GIẢI PHÁP: thay vì phụ thuộc vào cái cụ thể, ta phụ thuộc vào cái chung chung
- trong oop, có 2 cái chung chung ko cụ thể
	- abstract class
	- interface - là 1 dạng class cha, class chứa hàm ko có code (sau này có hàm có code nhưng mang ý nghĩa khác)
- 1 class khi viết code, muốn nó thích ứng đc với sự mở rộng trong tương lai, thì nó đừng hard-coded, phụ thuộc cứng vào 1 class cụ thể khác, mà nó nên phụ thuộc vào 1 cái interface

```java
public class A{
	private InterfaceB bObj; //dependency

	//Chích qua constructor, setter, field (reflection tránh vi phạm encapsulation)
	public A(InterfaceB bObj){  //thằng này trỏ new nào?
		this.bObj = bObj;
	}
}

/*bObj = new 1 class nào đó có code, InterfaceB chứa hàm ko có code à nhe
PHẢI CÓ 1 VÀI CLASS NÀO ĐÓ VIẾT CODE CỤ THỂ CHO CÁI INTERFACEB, implements InterfaceB

CÓ VÔ SỐ CLASS THỎA InterfaceB thì đều chơi đc với A

A nay có thể chơi với bất kì class nào, miễn mày là xuát thân từ InterfaceB
cứ thêm class thuộc họ InterfaceB, là ko cần sửa A, mà A chơi láng với các class từ InterfaceB

mở thoải mái các class thuộc họ InterfaceB, đóng với việc chỉnh code class A

CLASS A NAY CHƠI VỚI BẤT KÌ CLASS NÀO TRONG TƯƠNG LAI, MIỄN LÀ THUỘC HỌ INTERFACE-B
*/
```
## ÔN NHANH 
DEPENDENCY INJECTION
- Cách tight-coupling: nhà ta có sẵn các bác thợ sửa, thợ dịch vụ cần là có, nhưng phụ thuộc chặt chẽ, new obj class B trong lòng class A
- Loose coupling: nhà ta ko có sẵn, mà ta sẽ gọi điện thoại các bác chạy đến giúp, dependency injection, các bác ghé nhà em
	- ta ko new obj class B trong lòng class A, chỉ note lại điện thoại - biến tham chiếu
	- chờ bác ghé - tiêm chích vào. CÓ 4 CÁCH CHỜ BÁC GHÉ
		```java
		public class A{
			private B bObj;
			//ko có new, ko gắn chặt
		}
		```
		- cách 1: gán `bObj = new B()` qua reflection (kĩ thuật nâng cao)
		- cách 2: gán `bObj = new B()` qua constructor - tiêm chích qua constructor => cach mlem nhat
		- cách 3: gán bObj = new B() qua hàm set() hàm setter()
		- cách 4: DUNG FRAMEWORK/THU VIEN BEN NGOAI TU KIEM SOAT VIEC TAO OBJ DEPENDENCY VA TIEM CHICH VAO: SPRING/SPRINGBOOT!

-----
## References
1.
