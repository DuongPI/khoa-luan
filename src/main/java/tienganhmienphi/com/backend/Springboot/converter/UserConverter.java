package tienganhmienphi.com.backend.Springboot.converter;

import tienganhmienphi.com.backend.Springboot.dto.UserDTO;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;

public class UserConverter {
    public UserDTO toDto(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setFullName(entity.getFullName());
        dto.setId(entity.getId());
        dto.setPassword(entity.getPassword());
        dto.setUserName(entity.getUserName());
        dto.setRoles(entity.getRoles().get((int) 1l).getId());
        return dto;
    }
}
