import java.util.*;

public class fourWayHeap {
    public TreeNode callFourWayHeap (int[] freqTable)
    {
        ArrayList<TreeNode> arrayList = new ArrayList<TreeNode>();
        TreeNode t1, t2, t3;
        
        for (int i = 0; i < freqTable.length; i++)
        {
            arrayList.add(new TreeNode (freqTable[i], i));
            //System.out.println(arrayList.get(i).value);
            
        }
        
        build_heap(arrayList);
        
        while (arrayList.size() != 4)
        {
            t1 = rem_min(arrayList);
            t2 = rem_min(arrayList);
            t3 = merge(t1, t2);
            insert(arrayList, t3);
        }
        return arrayList.get(3);
    }
    
    public void heapify(ArrayList<TreeNode> AL, int i)
    {
        int min;
        //EDIT CHILD VALUES
        int child1 = (4*(i - 3)) + 4;
        int child2 = (4*(i - 3)) + 5;
        int child3 = (4*(i - 3)) + 6;
        int child4 = (4*(i - 3)) + 7;
        
        if(child1 < AL.size() && (AL.get(child1).value) <= (AL.get(i).value))
        {
            min = child1;
        }
        else
            min = i;
        
        if(child2 < AL.size() && (AL.get(child2).value) <= (AL.get(min).value))
        {
            min = child2;
        }
        
        if(child3 < AL.size() && (AL.get(child3).value) <= (AL.get(min).value))
        {
            min = child3;
        }
        
        if(child4 < AL.size() && (AL.get(child4).value) <= (AL.get(min).value))
        {
            min = child4;
        }
        
        if (min!=i)
        {
            Collections.swap(AL, i, min);
            heapify(AL, min);
        }
        
    }
    
    public void build_heap(ArrayList<TreeNode> AL)
    {
        for (int i = ((AL.size()-1)/4) + 3; i >= 3; i--)
        {
            heapify(AL, i);
        }
    }
    
    public TreeNode rem_min(ArrayList<TreeNode> AL)
    {
        TreeNode min = AL.get(3);
        AL.set(3, AL.get(AL.size() - 1));
        AL.remove(AL.size()-1);
        heapify(AL, 3);
        return min;
    }
    
    public TreeNode merge(TreeNode a, TreeNode b)
    {
        TreeNode newNode = new TreeNode (a.value + b.value);
        if (a.value > b.value)
        {
            newNode.left = a;
            newNode.right = b;
        }
        else
        {
            newNode.left = b;
            newNode.right = a;
        }    
        return newNode;
        
    }
    
    public void insert(ArrayList<TreeNode> AL, TreeNode t3)
    {
        AL.add(t3);
        int i = AL.size() - 1;
        while (i >=3 && AL.get(((i-1)/4)+ 3).value > AL.get(i).value)
        {
            Collections.swap(AL, i, ((i-1)/4)+3);
            i = ((i-1)/4) +3;
        }
    }
}
