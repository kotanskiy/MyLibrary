package library.rest.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:hibernate.properties")
@Import(DataBaseConfig.class)
@EnableTransactionManagement
public class HibernateConfig {

    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PCKG_TO_SCAN = "entitymanager.packages.to.scan";

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Environment environment;

    @Bean
    public Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty(HIBERNATE_DIALECT, environment.getProperty(HIBERNATE_DIALECT));
        properties.setProperty(HIBERNATE_SHOW_SQL, environment.getProperty(HIBERNATE_SHOW_SQL));
        properties.setProperty(PCKG_TO_SCAN, environment.getProperty(PCKG_TO_SCAN));
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }

    @Bean
    public SessionFactory sessionFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);

        localSessionFactoryBean.setPackagesToScan(environment.getProperty(PCKG_TO_SCAN));
        localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
        try {
            localSessionFactoryBean.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localSessionFactoryBean.getObject();
    }

    @Bean
    @Autowired
    public HibernateTransactionManager txManager(){
        return new HibernateTransactionManager(sessionFactory());
    }

}
