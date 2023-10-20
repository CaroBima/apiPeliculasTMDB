package com.peliculas.tmdbapi.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.peliculas.tmdbapi.repository.usuarios",
        entityManagerFactoryRef = "usersEntityManagerFactory",
        transactionManagerRef = "usersTransactionManager"
)
public class UsersDatabaseConfig {

    private final DataSource usersDataSource;
    private final HibernateProperties hibernateProperties;

    public UsersDatabaseConfig(@Qualifier("usersDataSource") DataSource usersDataSource, HibernateProperties hibernateProperties) {
        this.usersDataSource = usersDataSource;
        this.hibernateProperties = hibernateProperties;
    }

    @Bean(name = "usersEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean usersEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(usersDataSource)
                .packages("com.peliculas.tmdbapi.entities")
                .persistenceUnit("users")
                .properties(getVendorProperties(usersDataSource))
                .build();
    }

    @Bean(name = "usersTransactionManager")
    public JpaTransactionManager usersTransactionManager(@Qualifier("usersEntityManagerFactory") EntityManagerFactory usersEntityManagerFactory) {
        return new JpaTransactionManager(usersEntityManagerFactory);
    }

    private Map<String, Object> getVendorProperties(DataSource dataSource) {
        return hibernateProperties
                .determineHibernateProperties(
                        (Map<String, String>) new HibernateSettings().ddlAuto(() -> "none"),
                        null // Puedes pasar null porque JpaTransactionManager se encarga de las propiedades de JPA
                );
    }
}
