package library.rest.config;

import library.rest.dao.DaoLibrary;
import library.rest.dao.hibernate.DaoLibImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@Import(HibernateConfig.class)
@ComponentScan("library.rest")
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }



    @Autowired
    public HibernateTransactionManager txManager;

    @Bean
    public DaoLibrary daoLibrary(){
        DaoLibrary daoLib = new DaoLibImpl();
        daoLib.setSessionFactory(txManager.getSessionFactory());
        return daoLib;
    }
}
