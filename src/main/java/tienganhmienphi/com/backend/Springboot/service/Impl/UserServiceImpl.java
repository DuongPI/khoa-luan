package tienganhmienphi.com.backend.Springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tienganhmienphi.com.backend.Springboot.dto.RegisterForm;
import tienganhmienphi.com.backend.Springboot.dto.UserDTO;
import tienganhmienphi.com.backend.Springboot.entity.RoleEntity;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;
import tienganhmienphi.com.backend.Springboot.repository.RoleRepository;
import tienganhmienphi.com.backend.Springboot.repository.UserRepository;
import tienganhmienphi.com.backend.Springboot.service.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean insert(RegisterForm dto) {
        //RoleEntity roleEntity = roleRepository.findById((long)1).get();
        List<RoleEntity> roles = new ArrayList<>();
        UserEntity userEntity = userRepository.findOneByUserName(dto.getUsername());
        if(userEntity != null) {
            return false;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity entity = new UserEntity();
        entity.setFullName(dto.getUsername());
        entity.setPassword(encoder.encode(dto.getPassword()));
        entity.setUserName(dto.getEmail());
        entity.setStatus(1);
        entity.setRoles(roles);
        userRepository.save(entity);
        return true;
    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }
}
