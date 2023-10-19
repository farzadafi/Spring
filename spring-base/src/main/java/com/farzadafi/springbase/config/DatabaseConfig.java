package com.farzadafi.springbase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
   public class DatabaseConfig {
      @Bean
      public DataSource dataSource(){
         DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName("org.postgresql.Driver");
         dataSource.setUrl("jdbc:postgresql://172.17.0.2:5432/postgres");
         dataSource.setUsername( "postgres" );
         dataSource.setPassword("afshar");
         return dataSource;
      }
   }