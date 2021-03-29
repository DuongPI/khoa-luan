package tienganhmienphi.com.backend.Springboot.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {

    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private Integer status;
    private Long roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setRoles(Long roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getRoles() {
        return roles;
    }
}
