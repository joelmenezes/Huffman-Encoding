import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class freqTable {
    
    final static String File_Name = "D:\\ADS\\Huffman-Encoding\\src\\input.txt";
    final static Charset ENCODING = StandardCharsets.UTF_8;
    
    private int[] ftable = new int[999999];
    
    public static void main(String args[]) throws IOException{
        freqTable parser = new freqTable();
        parser.readTextFile(File_Name);
        
    }
    
    void readTextFile (String fileName) throws IOException{
        Path paths = Paths.get(fileName);
        int input;
        try (Scanner scanner = new Scanner (paths, ENCODING.name())){
            while(scanner.hasNextLine()){
                input = scanner.nextInt();
                ftable[input]++;
            }
        }
    }
}
