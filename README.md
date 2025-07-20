# Tổng kết kiểm thử tự động POM cho demoqa.com

## Mục tiêu
- Xây dựng kiểm thử tự động theo mô hình Page Object Model (POM) cho 3 chức năng: login, register (đăng ký), upload file (ảnh) trên trang https://demoqa.com/.
- Sử dụng Maven, Selenium WebDriver, TestNG, WebDriverManager.
- Quản lý code bằng IntelliJ IDEA, cấu trúc chuẩn Maven.

## Các file đã tạo/thay đổi
- **pom.xml**: Thêm dependency Selenium Java, TestNG, WebDriverManager.
- **src/test/java/com/example/pages/BasePage.java**: Class cha cho các page, chứa hàm thao tác chung.
- **src/test/java/com/example/pages/LoginPage.java**: Page Object cho trang login.
- **src/test/java/com/example/pages/RegisterPage.java**: Page Object cho trang đăng ký.
- **src/test/java/com/example/pages/UploadPage.java**: Page Object cho trang upload file.
- **src/test/java/com/example/tests/LoginTest.java**: Test case kiểm thử login.
- **src/test/java/com/example/tests/RegisterTest.java**: Test case kiểm thử đăng ký.
- **src/test/java/com/example/tests/UploadTest.java**: Test case kiểm thử upload file (ảnh).
- **src/test/resources/test-image.jpg**: File mẫu để kiểm thử upload file.
- (Đã xóa ProfilePage.java và ProfileTest.java vì không còn kiểm thử profile)

## Giải pháp & kỹ thuật
- Áp dụng mô hình POM để tách biệt logic kiểm thử và thao tác giao diện.
- Sử dụng WebDriverManager để tự động quản lý driver.
- TestNG để tổ chức và chạy test case.
- Đảm bảo code dễ mở rộng, bảo trì, tuân thủ DRY.

## Hướng dẫn chạy kiểm thử
- Cài đặt Chrome và Java.
- Chạy lệnh `mvn test` trong terminal để thực thi các test case.
- Kết quả sẽ hiển thị trên console.

## Ghi chú
- Có thể mở rộng thêm test case thành công, báo cáo Allure hoặc tích hợp CI/CD nếu cần.
- Nếu gặp lỗi mạng khi tải dependency, hãy kiểm tra proxy hoặc chuyển sang dùng mirror Tsinghua.
- Để test đăng nhập thành công, cần có tài khoản hợp lệ trên demoqa.com (sửa username/password trong LoginTest.java nếu cần).
- File test-image.jpg chỉ là file mẫu, bạn có thể thay bằng file ảnh thật nếu muốn kiểm thử upload ảnh thực tế. 