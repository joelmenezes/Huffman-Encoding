import java.io.*;
import java.util.*;

public class encoder {

    StringBuilder code = new StringBuilder();
    int total = 0;
    static String[] codeList = new String[1000000];

    public void createCodeTable(TreeNode n) throws IOException 
    {
	StringBuilder string = new StringBuilder();
	String a = new String();
	treeTraverse(n, string, a);
	try 
        {
            FileWriter fw = new FileWriter("code_table.txt");
            BufferedWriter buff = new BufferedWriter(fw);
            buff.write(code.toString());
            buff.close();
            fw.close();
	}
	catch(Throwable e)
	{
            e.printStackTrace();
	}

	}

    public void treeTraverse(TreeNode n, StringBuilder string, String a) 
    {
	StringBuilder sb = new StringBuilder();
	sb=sb.append(string).append(a);
	if(n.element!=-1)
        {
            total += (sb.length()*(n.value));
            codeList[n.element]=sb.toString();
            code.append(n.element+""+" "+sb.toString()+"\n");
	}
	else
        {
            treeTraverse(n.left, sb, "0");
            treeTraverse(n.right, sb, "1");
	}
    }

    public static void writeToFile(StringBuilder code) throws Exception {
	BitSet bit = new BitSet(code.length());
	int count = code.length() - 1;
	try
        {
            for (Character char1 : code.toString().toCharArray()) {
            if (char1.equals('1')) 
            {
		bit.set(count);
            }
	count--;
	}
	byte[] coded_array = bit.toByteArray();
	int a = 0;
	int b = coded_array.length - 1;
	byte temp = 0;
	while (a < b)   
        {
            temp = coded_array[a];
            coded_array[a] = coded_array[b];
            coded_array[b] = temp;
            a++;
            b--;
	}
	FileOutputStream fos = new FileOutputStream("encoded.bin");
	fos.write(coded_array);
	fos.close();
		
	}catch (Throwable e) 
        {
            e.printStackTrace();
	}
    }

    public static byte[] toByteArray(BitSet bits) 
    {
        byte[] bytes = new byte[bits.length() / 8 + 1];
	for (int i = 0; i < bits.length(); i++) 
        {
            if (bits.get(i)) 
            {
            	bytes[bytes.length - i / 8 - 1] |= 1 << (i % 8);
            }
	}
	return bytes;
    }

    public static void main(String[] args) 
    {
	StringBuilder encoded_data = new StringBuilder();
	Scanner freqScanner, codeListScanner;
	binaryHeap bh = new binaryHeap();
	int[] freq_table = new int[1000000];
	try 
        {
            File input = new File(args[0]);
            freqScanner = new Scanner(input);
            int temp;
            while (freqScanner.hasNextInt()) 
            {
                temp = freqScanner.nextInt();
                freq_table[temp]++;
            }
            freqScanner.close();
                       
            encoder encoder = new encoder();
            encoder.createCodeTable(bh.callBinaryHeap(freq_table));
		
            codeListScanner = new Scanner(input);
            while (codeListScanner.hasNextInt()) 
            {
                temp = codeListScanner.nextInt();
                encoded_data.append(codeList[temp]);
            }
            writeToFile(encoded_data);
            codeListScanner.close();
			
        }catch (Throwable e) 
        {
            e.printStackTrace();
	}
	System.gc();
    }
	
}