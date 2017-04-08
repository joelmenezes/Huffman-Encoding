// Implements Frequency table into a Biary Heap

import java.util.*;

public class binaryHeap 
{
    public TreeNode callBinaryHeap (int[] freqTable)
    {
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        TreeNode t1, t2, t3, root;
        //System.err.println("Entering loop");
        //Create a TreeNode for every item in the frequency table
        for (int i = 0; i < freqTable.length; i++)
        {
            if (freqTable[i]!=0)
                arrayList.add(new TreeNode(freqTable[i], i));
            //System.out.println(arrayList.get(i).value);
        }
        
        //Build a min heap using the nodes in the arraylist
        build_heap(arrayList);
        //System.out.println("Heap Built");
        //Combine 2 nodes to create a single tree
        while (arrayList.size()!=1)
        {
            t1 = rem_min(arrayList);
            //System.out.println("1st min " + t1.value);
            t2 = rem_min(arrayList);
            //System.out.println("2nd min " + t2.value);
            
            t3 = merge(t1, t2);
            //System.out.println("merged min " + t3.value);
            
            insert(arrayList, t3);
        } 
        root = arrayList.get(0);
        //levelOrderPrint(root);
        
        return arrayList.get(0);
        
    }
    
    //Builds a min heap using the frequencies stored in the ArrayList
    public void build_heap(ArrayList<TreeNode> AL)
    {
        for (int i = (AL.size()/2)-1; i >= 0; i--)
        {
            heapify(AL, i);
        }
    }
    
    //Heapify is used to move a node to a position such that it follows the min heap property
    public void heapify(ArrayList<TreeNode> AL, int i)
    {
        int min;
        int left_c = (2*i)+1;
        int right_c = (2*i)+2;
        
        if(left_c < AL.size() && (AL.get(left_c)).value  <= (AL.get(i)).value)
        {
            min = left_c;
        }
        else min = i;
        
        if(right_c < AL.size() && (AL.get(right_c)).value<(AL.get(min)).value)
        {
            min = right_c;
        }
        
        if(min!=i)
        {
            Collections.swap(AL, i, min);
            heapify(AL, min);
            //System.out.println("Heapifying " + AL.get(min).value);
        
        }
    }
    
    
    
    //Removes the min from the heap. Replaces it with the last element and heapifies it.
    public TreeNode rem_min(ArrayList<TreeNode> AL)
    {
        TreeNode min = AL.get(0);
        AL.set(0, AL.get(AL.size() - 1));
        AL.remove(AL.size()-1);
        heapify(AL, 0);
        return min;
    }
    
    //Inserts a node to the end of the heap and then runs a loop from its parent
    //to root till it reaches the correct position in the heap 
    public void insert (ArrayList<TreeNode> AL, TreeNode n)
    {
        AL.add(n);
        int i = AL.size() - 1; 
        while (i > 0 && AL.get((i - 1)/2).value > AL.get(i).value)
        {
            Collections.swap(AL, i, (i - 1)/2);
            i = (i - 1)/ 2;
        }
    }
    
    //Merges 2 nodes into 1. The children of the newNode are the nodes used to 
    //create it
    public TreeNode merge (TreeNode a, TreeNode b)
    {
        TreeNode newNode = new TreeNode (a.value + b.value);
        if(a.value > b.value)
        {
            newNode.left = a;
            newNode.right = b;
        }
        else
        {
            newNode.right = a;
            newNode.left = b;
        }
        return newNode;
    }

}
