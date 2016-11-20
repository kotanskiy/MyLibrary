package library.rest;

import library.rest.config.AppConfig;
import library.rest.model.dao.DaoLibrary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DaoLibrary library = context.getBean(DaoLibrary.class);
    }
}
