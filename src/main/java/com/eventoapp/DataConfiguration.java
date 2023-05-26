package com.eventoapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration  //indica que classe contem definições de beans do Spring.
public class DataConfiguration {  //classe com a criação de 2 beans para acesso a BD

    @Bean //método que retorna um objeto que deve ser gerenciado pelo conteiner do Spring usada em conjunto com @Configuration.
          // acesso a BD

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
        dataSource.setUsername("root");
        dataSource.setPassword("Admin123");

        return dataSource;
    }

    @Bean //gerencia a BD
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);                                                //mostras os passos
        adapter.setGenerateDdl(true);                                               //mostra as tabelas criadas
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        adapter.setPrepareConnection(true);                                     //realiza a conexão com a BD

        return adapter;
    }

}
