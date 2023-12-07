package Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public  List<String> getDersIsimleri(String path) {
        List<String> dersIsimleri = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(", ");
                for (String part : parts) {
                    if (part.startsWith("Ders İsmi:")) {
                        dersIsimleri.add(part.substring("Ders İsmi: ".length()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dersIsimleri;
    }

    public void writeToFile(String path, String fileName, String data1, String data2) {
        CreateFile(path, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + fileName, true))) {
            writer.write("Ders Kodu: " + data1 + ", Ders İsmi: " + data2); // Concatenate data if needed
            writer.newLine(); // Add a new line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeToFile2(String path, String fileName, String data1, String data2 , String data3 , String data4) {
        CreateFile(path, fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + fileName, true))) {
            writer.write("Ogrenci Adı: " + data1 + ", Ogrenci Soyadı: " + data2 + ", Ogrenci No: " + data3 + ", Ogrenci Ders: " + data4);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CreateFile(String Path, String FileName) {
        File directory = new File(Path);

        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Klasör oluşturuldu: " + directory.getAbsolutePath());
            } else {
                System.out.println("Klasör oluşturma başarısız!");
            }
        } else {
            System.out.println("Klasör zaten mevcut: " + directory.getAbsolutePath());
        }

        File file = new File(Path, FileName);

        try {
            if (file.createNewFile()) {
                System.out.println("Metin dosyası oluşturuldu: " + file.getName());
            } else {
                System.out.println("Metin dosyası zaten mevcut.");
            }
        } catch (IOException e) {
            System.out.println("Dosya oluşturma hatası: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "src/Data/Ders.txt";
        FileService fileService= new FileService();
        List<String> dersIsimleri = fileService.getDersIsimleri(filePath);


        System.out.println("Ders Isimleri:");
        for (String dersIsmi : dersIsimleri) {
            System.out.println(dersIsmi);
        }
    }
}