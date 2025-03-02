package testtest.surah.list.surahlisttest.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import testtest.surah.list.surahlisttest.model.SavedData;




public class savecsv {

    public void saveDataToCSV(SavedData savedData) {
    String filePath = "data.csv";  // Path to your CSV file
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { 
        writer.write(savedData.getEmail() + "," + savedData.getFormattedCurrentdate() + "," + savedData.getComments() + "," + savedData.getSelectedSurahEnglishName());
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
    }

}

public SavedData loadDataFromCSV(String email, SavedData savedData) {
    String filePath = savedData.getEmail() + ".csv";
    String line;
    
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");  
            
          
            if (data[0].equals(email)) {
                return new SavedData(
                    data[1],   
                    data[2], 
                    data[0],   
                    data[3]   
                );
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;  
}


}
