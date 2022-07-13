package nl.novi.pimpampet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ReaderWriter {



    public ReaderWriter() {
    }

    public void write(String titel, String tekst) {
        try {
//            this.file = new File(f);
//            this.pen = new FileWriter(this.file);
//            this.printer = new BufferedWriter(this.pen);
//            this.printer.write("test5");
//            this.printer.close();

            File file = new File("D:\\"+titel  + ".txt");


            FileWriter writer = new FileWriter(file);
            BufferedWriter printer = new BufferedWriter(writer);
            //printer.write(writer);
            writer.write(tekst + "\r");
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read(String titel, String tekst) {
        try
        {
            File file = new File("D:\\"+titel  + ".txt");
            Scanner myReader = new Scanner (file);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
                myReader.close();
            }

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}


