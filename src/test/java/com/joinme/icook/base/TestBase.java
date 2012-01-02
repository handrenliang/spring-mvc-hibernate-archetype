package com.joinme.icook.base;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.atomikos.jdbc.nonxa.DriverManagerDataSource;


@ContextConfiguration("TestFoodCategoryService-context.xml")
public class TestBase extends AbstractTransactionalJUnit4SpringContextTests {
    @BeforeClass
    public static void create() throws Exception {
        try {
            final SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
            DataSource dataSource = new DriverManagerDataSource();
            builder
                    .bind(
                            "java:comp/env/spring-mvc-hibernate-archetype/jdbc/datasource",
                            dataSource);
            builder.activate();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
}
