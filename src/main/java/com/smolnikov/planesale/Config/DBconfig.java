package com.smolnikov.planesale.Config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(
        basePackages = "com.smolnikov.planesale.Repository"
)
@ComponentScan
public class DbConfig {

//    @Bean
//    public DataSource DataSource(){
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName("com.postgresql.jdbc.Driver");
//        config.setJdbcUrl("jdbc:postgresql://localhost:5432/Task15");
//        config.setUsername("root");
//        config.setPassword("2203");
//        config.setAutoCommit(true);
//        return new HikariDataSource(config);
//    }

//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        return new org.hibernate.jpa.HibernatePersistenceProvider().createEntityManagerFactory("Task15", null);
//    }
}