package tienganhmienphi.com.backend.Springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "config.mail")
public class MailConfig {
    private String host;
    private int port;
    private String username;
    private String password;

    public Properties getProp(){
        Properties props = new Properties();
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", this.getPort());
        return props;
    }
}
