package com.brideglabz.indianstatescensusanalyser;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StateCensusAnalyserTest {
    List<CSVStateCensus> expectedList;
    List<CSVStateCensus> actualList;
    @Test
    void readCSVCheckingRecordMatches() throws IOException, CsvException, CustomException {
        File actualFile = new File("C:\\Users\\User\\Desktop\\243-rfp\\IndianStatesCensusAnalyser\\src\\main\\resources\\StateCensusData.csv");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        actualList = stateCensusAnalyser.readCSV(actualFile);
        int actual = actualList.size();
        int expected = 35;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    void readCSVCheckingCustomException() throws IOException, CsvException, CustomException {
        File actualFile = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day29-IndianStateCensusAnalyser\\src\\main\\resources\\StateCensus.csv");
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        CustomException customException = assertThrows(CustomException.class, () -> stateCensusAnalyser.readCSV(actualFile));
        Assertions.assertEquals("Oops!, it seems the file doesn't exist", customException.getMessage());
    }
}
