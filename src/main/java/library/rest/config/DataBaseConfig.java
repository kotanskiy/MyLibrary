package library.rest.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

@PropertySource("classpath:jdbc.properties")
@Configuration
public class DataBaseConfig {

    private static final String JDBC_DRIVER_CLASS = "jdbc.driver.class";
    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USER = "jdbc.user";
    private static final String JDBC_PASSWORD = "jdbc.password";
    private static final String JDBC_MIN_CONNECTIONS = "jdbc.min.connections";
    private static final String JDBC_MAX_CONNECTIONS = "jdbc.max.connections";
    private static final String JDBC_ACQUIRE_INCREMENT = "jdbc.acquire.increment";

    @Autowired
    private Environment environment;

    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(environment.getProperty(JDBC_DRIVER_CLASS));
        dataSource.setJdbcUrl(environment.getProperty(JDBC_URL));
        dataSource.setUser(environment.getProperty(JDBC_USER));
        dataSource.setPassword(environment.getProperty(JDBC_PASSWORD));

        dataSource.setMinPoolSize(Integer.parseInt(environment.getProperty(JDBC_MIN_CONNECTIONS)));
        dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty(JDBC_MAX_CONNECTIONS)));
        dataSource.setAcquireIncrement(Integer.parseInt(environment.getProperty(JDBC_ACQUIRE_INCREMENT)));
        return dataSource;
    }

}
