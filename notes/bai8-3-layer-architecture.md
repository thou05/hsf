Created: 202506192200

Tags: 

## 3-Layer Architecture and repository pattern

- UI (Presentation) -> Service (Business Logic) -> Repository (Data Access) -> Database
	- nguyên tắc thiết kế layer là ko chơi trò nhảy dù nha, phải từng tầng 1
- cấu trúc code
	```
	src/
		- com.thou.superapp
			- entity      -> Lớp Student (Entity JPA)
			- repository  -> StudentRepository (truy vấn db)
			- service     -> StudentService (logic nghiệp vụ)
			- infra       -> JpaUtil (hạ tầng EMF)
			- ui          -> Main (giao diện console)
	```

|         |                                      |                                                                                         |
| ------- | ------------------------------------ | --------------------------------------------------------------------------------------- |
| LAYER 1 | UI, Web, View, Controller, Main.java | Presentation Layer<br>Giao tiếp với người dùng (hiển thị dữ liệu, nhận input)           |
| LAYER 2 | service package                      | Business Logic Layer<br>Xử lý logic nghiệp vụ (Business Logic), điều phối luồng dữ liệu |
| LAYER 3 | repository package                   | Data Access Layer<br>Giao tiếp với database (CRUD, Query)<br>                           |

- 3-Layer
	- LAYER 1
		```
		Main.java{
			private StudentService _service = new ...
		}
		```
	- LAYER 2
		```
		StudentService.java{
			private StudentRepository _repo = new ...

			getAllStudent()   getStudentById(?)
			insertStudent(?)  updateStudent(?)
			deleteStudent(?)  processSomething()
		}
		```
	- LAYER 3
		```
		StudentRepository.java{
			findAll()  findById(?)
			save(?)    update(?)     delete(?)
			//biến EntityManager em = JpaUtil.getEntityManager();
			dùng trong các method
		}
		```
	---
	- entity package
	- util/infra package  
		- Infrastructure
		- Cung cấp công cụ/hạ tầng kĩ thuật: kết nối db, quản lý EntityManager, gửi email, ghi log, gửi notification
		```
		JpaUtil.java{
			private static final EntityManagerFactory emf;
		}
		//SINGLETON PATTERN
		```

> ques ? MINH CO THE TAO SINGLETON CHO REPO VA SERVICE HAY KHONG
-----
## References
1.
