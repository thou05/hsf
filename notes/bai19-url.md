Created: 202507132229

Tags: 

- resubmit hầu hết xảy ra ở `post`

- với hàm post - bản chất vẫn là get nhưng gửi kèm nhiều data khi `get`. Khi hàm `post` trả về 1 trang kết quả qua lệnh return "tên trang" thì url `post` vẫn giữ nguyên, thân trình duyệt có data đc trả về - trang trả về
	- F5 với post: thì vẫn trả về trang kết quả như bth, nhưng lại gửi lại đống data => RESUBMITSION, giống như nhấn lại nút bấm (vì nhấn nút gọi url này)
	- cực kì nguy hiểm với tính năng create, F5 màn hình KQ sẽ tương đương việc gửi lại data, chạy lại xử lý => DUPLICATE DATA
	- CHỐT: với post, ta cần ĐỔI URL tránh submit lại khi f5
		- url get, f5, get lại
		- url post, f5, post lại -> nguy hiểm => fix: url post xử lý xong, return trang và đổi url luôn, lỡ f5 lại, ko còn url post để re-submit form  => REDIRECT METHOD - định hướng lại url, gọi lại 1 url mới nhưng vẫn cùng kết quả trả về trang

> QUAN TRỌNG: XỬ LÝ POST XONG, THÌ NHỚ ĐỔI URL KẾT QUẢ, TRÁNH F5 LẠI CÁI POST. ĐỔI URL VÀ F5 LÀ F5 KẾT QUẢ, KO PHẢI F5 POST
	
- hiện tượng `get` y chang: url vẫn giữ nguyên, trong khi đó thân trình duyệt có data được trả về - trang trả về
	- F5 với get: thì trả về kết quả như bth
	
- ý nghĩa việc giữ nguyên url: gọi hàm thì trả về kết quả ở dưới, tên hàm vẫn ở trên

- 1 URL, 1 HÀM TƯƠNG ỨNG, 1 THÙNG MODEL MỚI TINH ĐỂ TA BỎ ĐỒ VÀO TRƯỚC KHI RENDER TRANG
- MỖI HÀM 1 MODEL RIÊNG, 1 THÙNG RIÊNG

- Kĩ thuật chuyển data từ model kia sang model này ở câu lệnh REDIRECT. Tại sao làm vậy: redirect là gọi url mới, url mới chơi thùng mới
- trước khi REDIRECT gửi ké thêm data từ model cũ sang model mới, từ model của thằng post ké sang model này thằng get này

- request mới - new mới -> update: session

- STATELESS: phi trang thai -> li do phai dung session
- flash attribute: quên nhanh mỗi lần request/reponse

- trong html: attribute trong tag bi sai -> tag mat luon

-----
## References
1.
