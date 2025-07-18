Created: 202507172254

Tags: 

- todo
	- tạo 1 prj spring boot mvc (5 option cần chọn)
	- móc nối vào database - dùng spring data: spring jpa/hibernate
	- code first, tạo table schema, tạo data sẵn cho table khi run app - CẤM tuyệt đối vào sql server management studio tạo table, insert data trực tiếp. Mọi thức phải qua CODE
	- 3-layer: xây dựng các class xử lý data từ table, từ object xuống table
	- hiển thị trang web với data lấy từ table
	- ...

- môn swp: dùng springweb restapi + react -> client side rendering. 
- môn này ko làm web api mà làm mvc -> server side: mọi thứ trên server kể cả trang web để trả về -> giống môn prj

- config: tự động hóa thông số cấu hình khởi tạo ban đầu
- controller: xử lý các url, gọi các trang ng dùng về
- entity/model: 
- repository: chơi trực tiếp với table với entity
- service: gọi repo

- note `spring.jpa.hibernate.ddl-auto=create` : create chi lam tren moi truong dev, con di lam sau thi nho phai de update

- `extends JpaRepository<Category, Long>`
	- JpaRepository interface này cần 2 thông số
		- tên entity class, tương lai là table nào
		- cột key có kiểu data type nào đó
	- nhờ 2 thông số này, Jpa/Hibernate phía hậu trường nó generate ra các hàm CRUD table Category
	- và hơn thế nữa: nó tự generate ra 1 loạt các hàm ứng với 1 loạt các câu sql hay dùng trên 1 table
	- về cơ bản, hầu như không cần viết thêm các hàm để CRUD table ứng với các where riêng, Spring JPA lo đc luôn các hàm này 
	- để tận dụng cơ chế tự sinh hàm, cần viết tên hàm theo chuẩn Spring JPA quy ước trước, tự Spring lo nốt câu JPQL/SQL cho -> Kĩ thuật tự sinh hàm và câu query chỉ từ cách đặt tên hàm theo chuẩn -> gọi là: `DERIVED QUERY METHODS, QUERY METHODS`
	- KEYWORD: query methods in spring data jpa
	- nhưng vẫn có thể độ câu query riêng (JPQL, SQL NATIVE) được luôn

> GUI/CONTROLLER --- SERVICE --- REPO --- SPRING JPA/HIBERNATE --- JDBC DRIVER --- TABLE

- SERVICE
	- Service lo CRUD table trong ram, lo logic xử lý với entit/dto, vd: tính voucer, khuyến mãi, gọi cổng thanh toán, gửi mail noti...
	- Nếu lo việc crud table thì phải nhờ repo, bản chất là phải khai báo repo, new repo(), gọi hàm repo
	- Nhưng repo hiện nay đang là interface, và là bean -> nên ta sẽ nhờ IoC Container chích tiêm vào service
	- Vật service được tiêm repo vào, vậy service cũng phải là bean
	- `@Component, @Service, @Repository, @Controller, @RestControler`
	- TIÊM REPO CÓ 3 CÁCH

-----
## References
1.
