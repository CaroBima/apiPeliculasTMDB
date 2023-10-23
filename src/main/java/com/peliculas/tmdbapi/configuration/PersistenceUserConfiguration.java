package com.peliculas.tmdbapi.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource({ "classpath:persistence-multiple-db.properties" })
@EnableTransactionManagement
@EnableJpaRepositories(
        //basePackageClasses = MovieEntity.class,
        entityManagerFactoryRef = "userEntityManagerFactory",
        transactionManagerRef = "userTransactionManager",
        basePackages = "com.peliculas.tmdbapi.repository.users"
)
public class PersistenceUserConfiguration {
    @Autowired
    private Environment env;

    @Bean(name="userDataSource")
    public DataSource movieDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("user.datasource.url"));
        dataSource.setUsername(env.getProperty("user.datasource.username"));
        dataSource.setPassword(env.getProperty("user.datasource.password"));
        //dataSource.setDriverClassName(env.getProperty("user.datasource.driver-class-name"));

        return dataSource;
    }

    @Bean(name= "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource((movieDataSource()));
        em.setPackagesToScan("com.peliculas.tmdbapi.entities.users");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("user.jpa.datasource.hibernate.ddl-auto"));
        properties.put("hibernate.dialect", env.getProperty("user.jpa.datasource.database-platform"));

        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name= "userTransactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}

