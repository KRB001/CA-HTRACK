package main;

import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

public class CASHTRACK {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        try {
            FileWriter myWriter = new FileWriter("src/test/test.txt");
            myWriter.write("" + now);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("failed to find");
        }

    }

}
