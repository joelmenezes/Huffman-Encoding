import java.io.*;

public class decoder {

    public static void main(String[] args) {
		
        try
        {
            FileInputStream encoded_file = new FileInputStream(args[0]);
            BufferedInputStream encoded_data = new BufferedInputStream(encoded_file); // encoded.bin
																						// data
            BufferedReader codeTable = new BufferedReader(new FileReader(args[1])); // code_table
            TreeNode root = new TreeNode(-1, -1);
            TreeNode node, parent;
            String string;
            String[] stringList;
            char temp;
            while ((string =codeTable.readLine()) != null) 
            {
		stringList = string.split("\\s+");
		node = root;
		parent = root;
		for (int i = 0; i < stringList[1].length(); i++) 
                {
                    temp = stringList[1].charAt(i);
			if (temp == '0') 
                        {
                            parent = node;
                            node = node.left;
                            if (node == null) 
                            {
				node = new TreeNode(-1, -1);
				parent.left = node;
                            }
			} else 
                        {
                            parent = node;
                            node = node.right;
                            if (node == null) 
                            {
				node = new TreeNode(-1, -1);
				parent.right = node;
                            }
			}
		}
		int data = Integer.parseInt(stringList[0]);
		node.element = data;
		node = root;

            }	
        writeFile(encoded_data, root);
	codeTable.close();
	encoded_data.close();

	} catch (Throwable e) {
            e.getMessage();
	}
    }
	
    public static void writeFile(BufferedInputStream encoded_data, TreeNode root){
	int x = 0;
	int y = 0;
	TreeNode temp1 = root;
	try
	{
            PrintWriter pWriter = new PrintWriter(new BufferedWriter(new FileWriter("decoded.txt")));
            while ((x = encoded_data.read()) != -1) {
            for (int i = 7; i >= 0; i--) 
            {
                y = (x & (1 << i)) >> i;
                if (y == 1){
                temp1 = temp1.right;
                }
                else if (y == 0) 
                {
                    temp1 = temp1.left;
					
                }
                if (temp1.right == null && temp1.left == null) 
                {

                    pWriter.print(temp1.element + System.getProperty("line.separator"));	
					
                    temp1 = root;
                    pWriter.flush();
                }
            }
	}
	pWriter.close();
	}catch (Throwable e) {
            e.getMessage();
	}
    }
}