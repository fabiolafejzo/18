package Log;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Log {


    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        FileWriter file;
        boolean continua = true;
        int riga = 1;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        try{
            file = new FileWriter("Logger.txt");
            while (continua) {

                System.out.print("* " + riga + " (Per sospendere scrivi ##Fine): ");
                String testo = sc.nextLine();
                if(testo.equalsIgnoreCase("##Fine")){
                    file.close();
                    continua = false;
                }
                else{
                   
                    Date date = new Date();

                    file.write("[" + dateFormat.format(date) + "] " + testo + "\r");
                    riga++;

                }
            }
        }
        catch(IOException ex){
            System.out.println("Errore: " + ex.getMessage());
        }

    }
    
}
