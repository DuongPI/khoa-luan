package tienganhmienphi.com.backend.Springboot.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tienganhmienphi.com.backend.Springboot.config.MailConfig;
import tienganhmienphi.com.backend.Springboot.config.ThymeleafConfig;
import tienganhmienphi.com.backend.Springboot.dto.RegisterForm;
import tienganhmienphi.com.backend.Springboot.dto.UserDTO;
import tienganhmienphi.com.backend.Springboot.entity.RoleEntity;
import tienganhmienphi.com.backend.Springboot.entity.UserEntity;
import tienganhmienphi.com.backend.Springboot.repository.RoleRepository;
import tienganhmienphi.com.backend.Springboot.repository.UserRepository;
import tienganhmienphi.com.backend.Springboot.service.UserService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=\"utf-8\"";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ThymeleafConfig thymeleafConfig;
    @Autowired
    private MailConfig mailConfig;

    @Override
    public boolean insert(RegisterForm dto) {
        List<RoleEntity> roles = new ArrayList<>();
        UserEntity userEntity = userRepository.findOneByUserName(dto.getUsername());
        if (userEntity != null) {
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

    @Override
    public void sendMail(String email, String name) {
        Properties props = mailConfig.getProp();
        System.out.println(mailConfig.getUsername()+" ----- "+ mailConfig.getPassword());
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailConfig.getUsername(), mailConfig.getPassword());
                    }
                });
        Message message = new MimeMessage(session);
        try {

            message.setRecipients(Message.RecipientType.TO,
                    new InternetAddress[]{new InternetAddress(email)});
            message.setFrom(new InternetAddress(mailConfig.getUsername()));
            message.setSubject("HOC-VA-THI");
            message.setContent(thymeleafConfig.getContent(name), CONTENT_TYPE_TEXT_HTML);
            System.out.println("here");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String changePass(long userId, String newpass,String oldpass) {
        String check = "false";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity userEntity = userRepository.findById(userId).get();
        if(encoder.matches(oldpass,userEntity.getPassword())){
            userEntity.setPassword(encoder.encode(newpass));
            userRepository.save(userEntity);
            check = "true";
        }
        System.out.println(check);
        return check;
    }
}
