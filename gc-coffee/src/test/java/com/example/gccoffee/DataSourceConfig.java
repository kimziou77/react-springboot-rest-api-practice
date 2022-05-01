package com.example.gccoffee;

import com.example.gccoffee.repository.ProductJdbcRepository;
import com.example.gccoffee.repository.ProductRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@TestConfiguration
public class DataSourceConfig {
    private String URL = "jdbc:mysql://localhost:3306/gc_coffee_test";
    private String USERNAME= "root";
    private String PASSWORD = "qqqq";

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    DataSource dataSource(){
        return DataSourceBuilder.create()
                .url(URL)
                .username(USERNAME)
                .password(PASSWORD)
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcTemplate jdbcTemplate){
        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }
    @Bean
    ProductRepository productRepository(NamedParameterJdbcTemplate jdbcTemplate){
        return new ProductJdbcRepository(jdbcTemplate);
    }
}
