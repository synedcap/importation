package com.example.importation.service;


import com.example.importation.model.People;
import com.example.importation.repositories.PeopleRepository;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ImportFileService implements CommandLineRunner {

    private PeopleRepository repository;

    public void run(String... args){




        //définir la taille du lot à envoyer
        int batchSize = 100;

        if(args.length == 0){
            System.out.println("Veuillez renseigner le chemin du fichier en paramètre");
            return;
        }

        //recuperation du chemin du fichier
        String path = args[0];

        int rowIndex = 0;

        List<People> peopleBatch = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(new File(path));
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet){

                //ici on ignore l'entete
                if (rowIndex == 0){
                    rowIndex++;
                    continue;
                }

                try {
                    People people = new People();
                    people.setMatricule(row.getCell(0).getStringCellValue());
                    people.setNom(row.getCell(1).getStringCellValue());
                    people.setPrenom(row.getCell(2).getStringCellValue());
                    people.setDatedenaissance(row.getCell(3).getStringCellValue());
                    people.setStatus(row.getCell(4).getStringCellValue());

                    peopleBatch.add(people);

                    if(peopleBatch.size() == batchSize){
                        //enregistrement du lot en mémoire
                        repository.saveAll(peopleBatch);

                        peopleBatch.clear();

                    }

                }catch(Exception e){
                    System.err.println("erreur lors de l'enregistrement du lot ");
                    e.printStackTrace();
                }
                rowIndex++;
            }

            if (!peopleBatch.isEmpty()) {
                repository.saveAll(peopleBatch);
            }

            System.out.println("Importation éffectuée avec succès");

        }catch (Exception e){
            System.err.println("");
            e.printStackTrace();
        }
    }

}
