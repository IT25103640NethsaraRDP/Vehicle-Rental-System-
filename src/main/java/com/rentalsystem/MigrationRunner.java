package com.rentalsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

// @Component // Disabled as database has been migrated and reset
public class MigrationRunner implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            // Migrations disabled as database structure completely changed

        } catch (Exception e) {
            System.out.println("Migration skipped or failed: " + e.getMessage());
        }
    }
}
