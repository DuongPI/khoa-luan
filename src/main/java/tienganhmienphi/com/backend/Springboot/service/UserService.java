package tienganhmienphi.com.backend.Springboot.service;

import tienganhmienphi.com.backend.Springboot.dto.RegisterForm;
import tienganhmienphi.com.backend.Springboot.dto.UserDTO;

public interface UserService {
    public boolean insert(RegisterForm dto);
    UserDTO update(UserDTO dto);

}
