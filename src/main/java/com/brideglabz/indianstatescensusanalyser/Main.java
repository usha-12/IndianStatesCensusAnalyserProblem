package com.brideglabz.indianstatescensusanalyser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
    Scanner scanner = new Scanner(System.in);
    CSVStateCensus census;
    List<CSVStateCensus> censuses = new ArrayList<>();
    public void menu() throws CsvException, IOException {
        System.out.println("Menu 1. Read from CSV file and print 2. Print data from csv file 3. Exit");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                menu();
                break;
            case 2:
                for(CSVStateCensus values : censuses) {
                    System.out.println(values);
                }
                menu();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid option");
                menu();
                break;
        }
    }
    public static void main(String[] args) throws CsvException, IOException {
        System.out.println("Welcome to Indian state census analyser program");
        Main main = new Main();
        main.menu();
    }
}
