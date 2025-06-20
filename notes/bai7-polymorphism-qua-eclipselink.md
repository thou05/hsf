Created: 202506191426

Tags: 

- `EntityManager` là ông sếp quản lí các Entity ~ chính là các class có `@Entity` và quản lí các object tạo từ class Entity: sếp có thể thêm `persit()`; xóa `remove()`; cập nhật `merge()`; tìm theo PK `find()`: lí do có hàm tìm theo key vì ta luôn có nhu cầu thao tác trên 1 dòng/row/record cụ thể trong table
	- môn swp admin, có màn hình quản lí user, phân loại, show table có nhiều dòng, phân trang, filter, cuối dòng có cột Action: Update | Delete => xử lí đúng 1 dòng select => theo PK
	- ngoài ra có hàm `createQuery()` tìm linh hoạt theo điều kiện nào đó
- Khi làm các hành động xóa, sửa, thêm ảnh hưởng và thay đổi hiện trạng DB, ta phải nhét nó vào transaction để theo dõi: hoặc tất cả hoặc không gì cả
	- nguyên lí do all or nothing: `ACID`

-----
## References
1.
