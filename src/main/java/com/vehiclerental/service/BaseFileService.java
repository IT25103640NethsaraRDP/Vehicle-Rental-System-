package com.vehiclerental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseFileService - parent class for ALL file service classes.
 *
 * OOP CONCEPTS DEMONSTRATED:
 * - Abstraction: abstract class with shared file I/O logic
 * - Inheritance: VehicleFileService, CustomerFileService, etc. all extend this
 * - Polymorphism: parseLine() is abstract — each subclass parses its own CSV format
 *
 * This means file read/write logic is written ONCE here and reused by all 6 services.
 * Each service only needs to implement parseLine() for its own data format.
 */
public abstract class BaseFileService<T> {

    protected final String filePath;

    public BaseFileService(String filePath) {
        this.filePath = filePath;
        ensureFileExists();
    }

    // ─── Abstract method — subclasses implement how to parse their CSV line ───
    protected abstract T parseLine(String csvLine);

    // ─── CREATE: append one record to the file ────────────────────────────────
    protected void appendToFile(String csvLine) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filePath, true))) { // true = append mode
            writer.write(csvLine);
            writer.newLine();
        }
    }

    // ─── READ: read all records from the file ─────────────────────────────────
    protected List<T> readAllFromFile() throws IOException {
        List<T> results = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) return results;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("#")) { // skip blank lines and comments
                    try {
                        results.add(parseLine(line));
                    } catch (Exception e) {
                        // Skip malformed lines rather than crashing the whole app
                        System.err.println("Warning: Could not parse line: " + line);
                    }
                }
            }
        }
        return results;
    }

    // ─── UPDATE / DELETE: rewrite entire file with new list ──────────────────
    // Used by both update and delete — update passes modified list, delete passes filtered list
    protected void writeAllToFile(List<String> csvLines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) { // false = overwrite
            for (String line : csvLines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // ─── Helper: create the file if it doesn't exist yet ─────────────────────
    private void ensureFileExists() {
        try {
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // create /data directory if needed
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Warning: Could not create file: " + filePath);
        }
    }
}
