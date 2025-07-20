Created: 202507201617

Tags: 

- todo
	- 1. Validation: 
		- áp dụng cho tạo mới sản phẩm
		- áp dụng cho edit sản phẩm
	- 2. Mode của màn hình product-form.html: flag/cờ trạng thái edit/new để
		- hiển thị đúng title trang web, lock/hóa ô nhập id hay không
		- kiểm soát nút bấm save: save do update, save do tạo mới -> trùng key hay không
	- 3. search

- Các method đang có trong ProductController
	- `@GetMapping("/products")` : show full sản phẩm, được gọi từ login
	- `@GetMapping("/products/edit/{}id")`  : click link edit 1 sản phẩm cùng mở product-form.html: selectedOne, cates
	- `@GetMapping("/products/new")`: click link tạo mới 1 sản phẩm cùng mở product-form.html: selectedOne, cates
	- `@PostMapping("/products/save")` : click save button trên form, save bất chaaos edit và new
	- `@GetMapping("/products/delete/{id}")`: click link xóa 1 sản phẩm

- Kĩ thuật bean validation chỉ được sử dụng nếu dùng cơ chế binding obj từ dưới form html lên controller. Nếu dùng `@RequestParam..` thì ko dùng đc kĩ thuật này
- `@Valid @ModelAttribute("selectedOne") Product product, BindingResult result`
	- chặn đầu `@Valid` chặn đuôi `BindingResult result` quá trình binding dữ liệu từ dưới form lên obj
	- chặn đầu qua `@Valid` để kích hoạt việc kiểm soát từng field được gán giá trị có bị lỗi hay không 
	- nếu phát hiện có lỗi, thì ghi biên bản qua `BindingResult`
	- Biên bản vi phạm `result` tự được add vào thùng model gửi trở lại form, nếu mình quy định có lỗi nhập thì trở lại form

- `@NotBlank` : đảm bảo không trống ô nhập chuỗi
- `@NotNull` : dành cho số

```
STRING VALIDATION - KIỂM TRA TÍNH HỢP LỆ CỦA 1 CHUỖI DÙNG REGEX ***************************************************************************** 
* CHUỖI NHẬP TỪ BÀN PHÍM
- MỖI TỪ PHẢI BẮT ĐẦU BẰNG CHỮ HOA, 
- CHỈ CHỨA CHỮ CÁI
- KHÔNG CHỨA SỐ/KÝ TỰ ĐẶC BIỆT
- KHÔNG THỪA KHOẢNG TRẮNG


***********************************************************
>>>>> STRING VALIDATION CHO CHUỖI TIẾNG ANH - NGLISH STRING

@NotBlank(message = "Tên không được để trống")
@Size(min = 5, max = 100, message = "Tên phải dài từ 5 đến 100 ký tự")
@Pattern(
            regexp = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)*$",
            message = "Tên không hợp lệ – mỗi từ phải bắt đầu hoa, chỉ chữ cái, không số/ký tự đặc biệt, không thừa khoảng trắng"
    )


>>>>> Giải thích RegEx

^                  # Bắt đầu chuỗi
([A-Z][a-z]+)      # 1 từ: chữ in hoa + ít nhất 1 chữ thường
(\\s[A-Z][a-z]+)*  # 0 hoặc nhiều từ tiếp theo, mỗi từ cách nhau đúng 1 dấu cách
$                  # Kết thúc chuỗi

[A-Z]		   # Ký tự đầu mỗi từ phải là chữ hoa.
[a-z]+		   # Theo sau là ít nhất một chữ thường (ngăn cả từ dài chỉ 1 ký tự).
\\s		   # Chỉ cho phép 1 khoảng trắng giữa các từ, không có leading/trailing spaces và không cho nhiều space liên tiếp.

Với RegEx này, chuỗi chỉ chứa các chữ cái A–Z/a–z và đúng khoảng trắng giữa từ, loại trừ số và ký tự đặc biệt.


************************************************************************
>>>>> STRING VALIDATION CHO CHUỖI TIẾNG VIỆT - VIETNAMESE/UNICODE STRING 
* TRONG TIẾNG VIỆT LƯU Ý NHỮNG CHỮ CÁI HOA DẠNG: Â, Đ, Ứ, À...

@Pattern(
        regexp = "^(\\p{Lu}\\p{Ll}+)(\\s\\p{Lu}\\p{Ll}+)*$",
        message = "Mỗi từ phải bắt đầu hoa, chỉ chứa chữ (Unicode), không số/ký tự đặc biệt, không khoảng trắng thừa"
)


>>>>> Giải thích RegEX
\p{Lu}: mọi chữ in hoa Unicode (A–Z, Á, Đ, Ứ…)

\p{Ll}: mọi chữ thường Unicode (a–z, à, đ, ư…)

^(…)(\s…)*$:

Từ đầu: một từ (\p{Lu}\p{Ll}+)

Tiếp theo: zero hoặc nhiều nhóm “1 space + từ”

Kết thúc chuỗi

Java regex mặc định đã hỗ trợ Unicode cho \p{Lu}/\p{Ll}.

```

-----
## References
1.
