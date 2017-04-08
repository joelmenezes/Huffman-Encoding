
import java.io.*;
import java.util.*;

public class performanceChecker {
    public static void main (String[] args)
    {
        binaryHeap bHeap = new binaryHeap();
        fourWayHeap fourHeap = new fourWayHeap();
        pairingHeap pHeap = new pairingHeap();
        String fileName = "C:\\Users\\Joel\\Desktop\\ads\\kachra\\sample_input_large.txt";
        Scanner parser;
        int[] freqTable = new int[1000000];
        try
        {
            //Replace with args
            parser = new Scanner(new File(args[0]));
            int temp;
        
            while(parser.hasNextInt())
            {
                temp = parser.nextInt();
                freqTable[temp]++;
                //System.out.println(temp);
            }
            
            long start = System.currentTimeMillis();
            
            //for (int i = 0; i < 10; i ++)
            //{
                bHeap.callBinaryHeap(freqTable);
            //}
            System.out.println((System.currentTimeMillis() - start)/10 + " Binary");
            
            start = System.currentTimeMillis();
            for (int i = 0; i < 10; i ++)
            {
                //fourHeap.callFourWayHeap(freqTable);
            }
            System.out.println((System.currentTimeMillis() - start)/10 + " 4 way");
        
            start = System.currentTimeMillis();
            for (int i = 0; i < 10; i ++)
            {
               // pHeap.callPairingHeap(freqTable);
            }
            System.out.println((System.currentTimeMillis() - start)/10 + " pairing heaps");
            parser.close();
            
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
