package com.DanielLazureanu.SpringService;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/csv")
public class CsvService {

    public List<CsvData> dataList;

    public CsvService() {
        String filePath = "C:\\Users\\daniel_lm\\Desktop\\SpringService\\src\\main\\java\\com\\DanielLazureanu\\SpringService\\forest_surfaces.csv";
        this.dataList = readDataFromCsv(filePath);
    }

    @GetMapping("/search")
    /*public CsvData getByColumnValue(@RequestParam String column, @RequestParam String value) {
        return dataList.stream()
                .filter(data -> getColumnValue(data, column).equals(value))
                .findFirst()
                .orElse(null);
    }*/

    @PostMapping("/add")
    public void addDataList(@RequestBody List<CsvData> newDataList) {
        dataList.addAll(newDataList);
    }

    @DeleteMapping("/delete")
    public void deleteByColumnValue(@RequestParam String column, @RequestParam String value) {
        //dataList.removeIf(data -> getColumnValue(data, column).equals(value));
    }

    @PutMapping("/update")
    public void updateByColumnValue(@RequestParam String column, @RequestParam String value, @RequestBody CsvData updatedData) {
        
    }

    private List<CsvData> readDataFromCsv(String filePath) {
        List<CsvData> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                CsvData csvData = new CsvData(
                        values[0].trim(),
                        values[1].trim(),
                        Integer.parseInt(values[2].trim()),
                        values[3].trim(),
                        Double.parseDouble(values[4].trim())
                );

                dataList.add(csvData);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }  
}
