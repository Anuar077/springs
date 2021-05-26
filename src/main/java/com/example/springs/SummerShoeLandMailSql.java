package com.example.springs;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
@SpringBootApplication
public class SummerShoeLandMailSql implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SummerShoeLandMailSql.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        readRecords();
    }

    private void readRecords() {
        System.out.println("Flyway...");
        System.out.printf("%-30.30s  %-30.30s%n", "content_id", "content");
        jdbcTemplate.query("SELECT * FROM springboot.public.coursecontents", new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                System.out.printf("%-30.30s  %-30.30s%n", rs.getString("content_id"), rs.getString("content"));
            }

        });
    }
}