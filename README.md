# Exercise5 - Tóm tắt kiểm thử tự động

## Mục đích
Kiểm thử tự động trang đăng ký tại https://demoqa.com/automation-practice-form bằng Selenium, áp dụng mô hình Page Object Model (POM).

## Nhiệm vụ đã hoàn thành
- Xây dựng lớp RegistrationPage kế thừa BasePage, thao tác với các trường trên form đăng ký.
- Xây dựng lớp RegistrationTest kế thừa BaseTest, kiểm thử đăng ký thành công (happy path), kiểm tra popup xác nhận.
- Chuyển sang kiểm thử nhiều bộ dữ liệu đăng ký bằng file CSV (registration-data.csv), loại bỏ bước upload ảnh.

## Quyết định & Giải pháp
- Sử dụng dữ liệu từ file CSV cho test đăng ký (data-driven test).
- Không cần upload ảnh trong kiểm thử.
- Đảm bảo không sửa đổi code không liên quan, tuân thủ POM.
- Đặt tên file khác biệt, dễ tra cứu.
- Sử dụng JUnit Jupiter (org.junit.jupiter.api) cho test.

## Công nghệ sử dụng
- Java
- Selenium WebDriver
- JUnit Jupiter
- Page Object Model (POM)

## File đã tạo/sửa
- src/test/java/pages/RegistrationPage.java (mới)
- src/test/java/tests/RegistrationTest.java (sửa)
- src/test/resources/registration-data.csv (mới)
- README.md (cập nhật) 