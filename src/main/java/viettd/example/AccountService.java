package viettd.example;

import java.util.regex.Pattern;

public class AccountService {

    // Kiểm tra email hợp lệ đơn giản (có @ và dấu .)
    public boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }

    // Đăng ký tài khoản với username, password, email
    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.isEmpty()) return false;
        if (password == null || password.length() <= 6) return false;
        if (!isValidEmail(email)) return false;
        // Giả lập lưu thành công
        return true;
    }
}
