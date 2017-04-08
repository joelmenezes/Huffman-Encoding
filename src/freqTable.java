import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class freqTable {
    
    final static String File_Name = "C:\\Users\\Joel\\Desktop\\ads\\kachra\\sample_input_large.txt";
    final static Charset ENCODING = StandardCharsets.UTF_8;
    
    
    public static void main(String args[]) throws IOException{
        int[] ftable = new int[1000000];
        Scanner scanner;
        long startTime = System.nanoTime();
        int input;
        try {
            scanner = new Scanner(new File(File_Name));
            while(scanner.hasNextInt()){
                input = scanner.nextInt();
                //System.out.println(input);
                ftable[input]++;
                //System.out.println(input + " has frequency: " + ftable[input]);
                
            }
        scanner.close();
        long endTime = System.nanoTime();
        System.out.println((startTime-endTime)/1000000);
        }
        
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
