/* Enrique Munoz
 * 2/28/2023
 * Adv. Object Oriented Programming CS3331, Dr. Mejia
 * Programming Assignment 2
*/

import java.io.*;

public class Log {
    //Attributes
    BufferedWriter buffWriter;

    //Constructors
    public Log(){
    }
    
    //Methods
    public void openFile(){
        try {
            buffWriter = new BufferedWriter(new FileWriter("Log.txt"));
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public void writeLog(String input){
        try{
            buffWriter.write(input);
            buffWriter.newLine();
        }catch(IOException e){
            System.out.println("File not found.");
        }
    }

    public void closeLog(){
        try{
            if (buffWriter!=null){
                buffWriter.close();
            }
        }catch(IOException e){
            System.out.println("File not found.");
        }
    }
    
}
