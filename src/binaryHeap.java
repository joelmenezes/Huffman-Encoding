// Implements Frequency table into a Biary Heap

import java.util.*;

public class binaryHeap 
{
    public void callBinaryHeap (int[] freqTable)
    {
        ArrayList<TreeNode> arrayList = new ArrayList<TreeNode>();
        TreeNode t1, t2, t3;
        
        for (int i = 0; i < freqTable.length; i++)
        {
            arrayList.add(new TreeNode(freqTable[i], i));
        }
        
        build_heap(freqTable);
    }
    
    
}
