package com.example.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;
import javax.activation.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

    private EmbeddedDatabase db;

    @Bean
    public EmbeddedDatabase dataSource() {
        return   new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY or .HSQL
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-data.sql")
                .build();
    }

    @Before
    public void setUp() {
        //db=null;
        //connection=null;
        //try {
            db = dataSource();
            //connection = db.getConnection();
            //connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)
        //} catch (SQLException e){
           // e.printStackTrace();
        //}
    }

    @Test
    public void testDataAccess() {
        JdbcTemplate template = new JdbcTemplate(db);
        //https://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html


        //template.query("SELECT * FROM seedhub.users");
        //PreparedStatement statement = connection.prepareStatement("SELECT * FROM seedhub.users");
    }

    @After
    public void tearDown() {
        db.shutdown();
    }
}