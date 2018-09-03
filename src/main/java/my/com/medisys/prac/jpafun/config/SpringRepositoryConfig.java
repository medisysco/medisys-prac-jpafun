package my.com.medisys.prac.jpafun.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = {"my.com.medisys.prac.jpafun.entity"})
@EnableJpaRepositories(basePackages = {"my.com.medisys.prac.jpafun.repository"})
public class SpringRepositoryConfig {

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(SpringRepositoryConfig.class);
    public static final String MAPPING_LOCATIONS = "classpath:/META-INF/hibernate/*.hbm.xml";

}
