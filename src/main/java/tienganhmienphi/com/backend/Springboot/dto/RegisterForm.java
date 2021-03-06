package tienganhmienphi.com.backend.Springboot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterForm {
    @NotBlank(message = "Vui lòng nhập Tên đăng nhập")
    private String username;

    @NotBlank(message = "Vui lòng nhập Mật mã")
    private String password;

    @NotBlank(message = "Vui lòng nhập Xác nhận mật mã")
    private String passwordConfirm;

    @NotBlank(message = "Vui lòng nhập Email")
    @Email(message = "Email không đúng")
    private String email;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getEmail() {
        return email;
    }
}
