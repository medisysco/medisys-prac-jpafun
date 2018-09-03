package my.com.medisys.prac.javaee.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Configuration
@ComponentScan(basePackages = {"my.com.medisys.prac.javaee.beans",
        "my.com.medisys.prac.javaee.service"})
public class SpringBeansConfig {

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(SpringBeansConfig.class);

}
