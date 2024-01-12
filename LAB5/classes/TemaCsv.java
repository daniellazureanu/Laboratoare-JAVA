package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemaCsv{
    public static void main(String[] args) {
        String filePath = "classes/forest_surfaces.csv";
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

                //Normal output
                System.out.println(csvData);
            }

            //Sorted output by year field
            
            /*Collections.sort(dataList);

            for (CsvData data : dataList) {
                System.out.println(data);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}