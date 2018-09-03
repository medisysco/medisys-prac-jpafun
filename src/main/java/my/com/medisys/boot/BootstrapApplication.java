package my.com.medisys.boot;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@SpringBootApplication
@ComponentScan({"my.com.medisys.config"})
public class BootstrapApplication {

    private static final Logger log = LoggerFactory.getLogger(BootstrapApplication.class);

    @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        log.info("TimeZone: {}", TimeZone.getDefault());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootstrapApplication.class, args);
    }

}
