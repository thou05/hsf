Created: 202507161642

Tags: 

- lay data tu trang web gui len qua 2 cach : @RequestParam, @ModelAttribute

- http: giao thức theo style stateless, ko nhớ nhau lâu, request/response xong quên luôn ai đã gọi
	- -> cần có kĩ thuật để lưu lại dấu vết của 1 user: request lần trước, lần này là của cùng 1 người
	- vd: 
		- setting ngôn ngữ của web app: user Thảo: setting language -> en dùng  chung cho nhiều trang
		- giỏ hàng qua nhiều trang khác nhau
	- -> `session`: cơ chế lưu trữ giá trị dùng chung cho nhiều trang của 1 user đc lưu trong 1 vùng ram
	
- `session` là cái thùng dành cho từng user khác nhau, chứa nhiều món đồ, dùng chung cho các page luôn  -> f5 của mỗi page, vùng session này ko mất -> thông tin login, role hay cất ở đây
	> ???  vậy thì bao giờ hết 1 session đấy
	
- todo: phân quyền: http://localhost:6969/products cũng ko cho xem luôn nếu ko login -> bảo mật
- 

-----
## References
1.
