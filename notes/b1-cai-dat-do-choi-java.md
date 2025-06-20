Created: 202506082357
Tags: 

```
outline
chap1. jpa, jpa mapping
chap2. introduction to spring framework
chap3. spring boot concepts
chap4. spring data jpa
chap5. spring mvc
chap6. spring web development with thymeleaf
chap7. build a simple application with data access using spring and spring jdbc, spring orm
chap8. introduction to javaFX
chap9. build application with javafx
```

```
0. Đồ chơi và công cụ môn học HSF (hibernate, spring, framework)
	- ide: intellij ultimate
	- jdk: 21 trở lên
	*cài jdk trước, ide sau

1. thiết lập biến môi trường - enviroment variables
	*Biến là gì?
	- toán: biến là tên gọi cho 1 giá trị
	- lập trình: biến là tên gọi cho 1 vùng ram để lưu giá trị để các hàm dùng
	- hdh: 
		biến môi trường là tên gọi cho 1 vùng ram của hdh và để lưu giá trị - chuỗi
		biến môi trường của hdh là biến lưu chuỗi
		biến này lưu thông tin, chuỗi kí tự chia sẻ cho các app cùng dùng
		biến môi trường lưu chuỗi kí tự dùng chung cho các app
		.
		có 2 loại biến môi trường trong os
			- biến có sẵn khi cài hdh: để các app của hdh dùng
				String PATH = "CHUỖI ABC; DEF; XYZ;..."
							  "đường dẫn đến các thư mục BIN, nơi chứa .exe"
				
				app powershell, cmd, terminal, khi ta gõ lệnh (NPM, GIT, JAVA, MVN)(.exe)
				cmd tự mò biến path,xem các chuỗi đường dẫn có đứa nào có lệnh này không
				nếu có thì run app
				không có thì báo lỗi không thấy
				
				cập nhật thêm biến path những đường dẫn tới thư mục bin của các tool
				để đảm bảo rằng khi gõ lệnh thì terminal biết đường tìm tool ở bin mà chạy
			
			- biến ta tự tạo: để các app nói chung dùng
				khi các app có nhu cầu dùng chung thông tin nào đó quan trọng
				ta đẩy info đó vào trong biến môi trường tự tạo
				và loan báo cho các app khác, lấy info ở biến môi trường quy ước trc
				
				jdk là 1 app quan trọng, dùng để làm nền cho các app java khác sd
				vậy jdk phải cài vào máy đầu tiên
				nhưng cài ở đâu là tùy dân dev: c:\  d:\  e:\ ... 
				jdk cài ở đâu không quan trọng
				thông tin cài sẽ đặt ở biến môi trường tên là JAVA_HOME
				
				String JAVA_HOME = "C:\PROGRAM FILES\JAVA\JDK-24"
				
				intellij, eclipse, netbeans đều cần jdk để dùng
				chỉ cần hỏi windows cho biết JAVA_HOME mang giá trị gì
				mò đến đó, đi vào bin lấy máy ảo, thư viện...


	- check: echo %JAVA_HOME%  ~ cout << javahome;

	- phải thêm \bin vào trong path, vì cmd ngu chỉ lấy những giá trị có trong path
	- add trong path: %JAVA_HOME%\BIN  => chỉ cần thay đổi 1 chỗ trong sys 
	=> sau này muốn chuyển đổi giữa các jdk để dùng chỉ cần thay đổi values của JAVA_HOME


	=>> chốt hạ cho env sys khi cài tool lập trình
		- biến _HOME trỏ đến nơi cài
		- biến PATH trở đến thư mục bin để run lệnh
		
		"HOME NƠI CÀI, BIN NƠI CHẠY!!"


	CATALINE_HOME -> TRỎ ĐẾN NƠI CÀI TOMCAT
	CATALINA_HOME\BIN -> trỏ con mèo tom nó nằm, phục phụ request/response

	M2_HOME -> trỏ dến nơi cài maven
	M2_HOME\BIN -> trỏ đến nơi có tool MVN để đóng gói app java

	github, nodejs, python cũng y chang
```

```
2. CÀI IDE : intellij, eclipse, netbeans, vs code, cursor ai
	- có option hỏi cập nhật bin của intellij vào env var path không
		-> chơi trò mở intellij qua cml, vì mày là .exe

```

```
CI/CD
```
-----
## References
1.
