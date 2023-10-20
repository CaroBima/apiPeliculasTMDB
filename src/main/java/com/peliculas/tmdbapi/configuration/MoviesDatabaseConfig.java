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
        basePackages = "com.peliculas.tmdbapi.repository.movies",
        entityManagerFactoryRef = "moviesEntityManagerFactory",
        transactionManagerRef = "moviesTransactionManager"
)
public class MoviesDatabaseConfig {

    private final DataSource moviesDataSource;
    private final HibernateProperties hibernateProperties;

    public MoviesDatabaseConfig(@Qualifier("moviesDataSource") DataSource moviesDataSource, HibernateProperties hibernateProperties) {
        this.moviesDataSource = moviesDataSource;
        this.hibernateProperties = hibernateProperties;
    }

    @Bean(name = "moviesEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean moviesEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(moviesDataSource)
                .packages("com.peliculas.tmdbapi.model.movies")
                .persistenceUnit("movies")
                .properties(getVendorProperties(moviesDataSource))
                .build();
    }

    @Bean(name = "moviesTransactionManager")
    public JpaTransactionManager moviesTransactionManager(@Qualifier("moviesEntityManagerFactory") EntityManagerFactory moviesEntityManagerFactory) {
        return new JpaTransactionManager(moviesEntityManagerFactory);
    }

    private Map<String, Object> getVendorProperties(DataSource dataSource) {
        return hibernateProperties
                .determineHibernateProperties(
                        (Map<String, String>) new HibernateSettings().ddlAuto(() -> "none"),
                        null
                );
    }
}
