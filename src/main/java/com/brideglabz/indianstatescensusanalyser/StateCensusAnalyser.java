package com.brideglabz.indianstatescensusanalyser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class StateCensusAnalyser {
    File file = new File("C:\\Users\\User\\Desktop\\243-rfp\\IndianStatesCensusAnalyser\\src\\main\\resources\\StateCensusData.csv");
    CSVStateCensus census;
    List<CSVStateCensus> censuses = new ArrayList<>();

    public List<CSVStateCensus> readCSV() throws IOException, CsvException {
        try {
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                int sNo = Integer.parseInt(row[0]);
                String state = row[1];
                long population = Long.parseLong(row[2]);
                double increase = Double.parseDouble(row[3]);
                long area = Long.parseLong(row[4]);
                int density = Integer.parseInt(row[5]);
                int sexRatio = Integer.parseInt(row[6]);
                double literacy = Double.parseDouble(row[7]);
                census = new CSVStateCensus(sNo, state, population, increase, area, density, sexRatio, literacy);
                censuses.add(census);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return censuses;
    }
}
