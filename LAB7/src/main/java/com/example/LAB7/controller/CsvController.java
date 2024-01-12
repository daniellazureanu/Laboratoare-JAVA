package com.example.LAB7.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CsvController {

    private static final String CSV_FILE = "C:\\Github Repos\\Laboratoare-JAVA\\LAB7\\src\\main\\java\\com\\example\\LAB7\\forest_surfaces.csv";

    private List<String[]> allData = readCsv();

    private List<String[]> readCsv() {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                data.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    @GetMapping("/getElement")
    public ResponseEntity<String[]> getElement(@RequestParam int index) {
        if (index >= 0 && index < allData.size()) {
            return ResponseEntity.ok(allData.get(index));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/addElements")
    public ResponseEntity<String> addElements(@RequestBody List<String[]> elements) {
        allData.addAll(elements);
        writeCsv();
        return ResponseEntity.status(HttpStatus.CREATED).body("Elements added successfully.");
    }

    @DeleteMapping("/deleteElement")
    public ResponseEntity<String> deleteElement(@RequestParam int index) {
        if (index >= 0 && index < allData.size()) {
            allData.remove(index);
            writeCsv();
            return ResponseEntity.ok("Element deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Element not found.");
        }
    }

    @PutMapping("/updateElement")
    public ResponseEntity<String> updateElement(@RequestParam int index, @RequestBody String[] newData) {
        if (index >= 0 && index < allData.size()) {
            allData.set(index, newData);
            writeCsv();
            return ResponseEntity.ok("Element updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Element not found.");
        }
    }

    private void writeCsv() {
        try (FileWriter writer = new FileWriter(CSV_FILE)) {
            for (String[] rowData : allData) {
                writer.write(String.join(",", rowData) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
