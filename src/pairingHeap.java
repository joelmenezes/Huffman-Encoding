import java.util.*;
public class pairingHeap {
    pNode  min = null;
    public void callPairingHeap(int[] freqTable)
    {
        pNode t1, t2, t3;
        int flag = 1;
        
        for (int i = 0; i < freqTable.length; i++)
        {
            if(freqTable[i] != 0)
            {
                if (flag == 1)
                {
                    min = new pNode(freqTable[i]);
                    flag = 0;
                }
                else
                {
                    pNode node = new pNode(freqTable[i]);
                    insert(node);
                }
            }
        }
        
        while(min.children.size() != 0)
        {
            t1 = min;
            removeMin();
            t2 = min;
            removeMin();
            t3 = merge(t1, t2);
            insert(t3);
        }
        for(int i = 0; i < min.children.size(); i++)
        {
            System.out.println(min.children.get(i).value);
        }
        
    }
    
    
    public void insert(pNode node)
    {
        if (min == null)
        {
            min = node;
        }
        else if (node.value <= min.value)
        {
            node.children.add(min);
            min = node;
        }
        else
        {
            min.children.add(node);
        }
    }
    
    public void removeMin()
    {
        int noChildren = min.children.size();
        pNode temp;
        
        if(noChildren == 0){
            min = null;
        }
        
        if (noChildren == 1)
        {
            min = min.children.get(0);
        }
        
        else if (noChildren == 2)
        {
            if (min.children.get(0).value < min.children.get(1).value )
            {
                temp = min.children.get(1);
                min = min.children.get(0);
                min.children.add(temp);
            }
            else
            {
                temp = min.children.get(0);
                min = min.children.get(1);
                min.children.add(temp);
            }
        }
        
        else if (noChildren > 2)
        {
            pNode temp1, temp2;
            int size = min.children.size();
            int count = 0;
            ArrayList<pNode> AL = new ArrayList<>();
            while (count < size)
            {
                temp1 = min.children.get(0);
                temp2 = min.children.get(1);
                min.children.remove(0);
                count++;
                if(count == size)
                {
                    min.children.add(temp1);
                }
                else
                {
                    min.children.remove(0);
                    count++;
                    insert(temp1, temp2);
                }
            }
            AL = min.children;
            min = AL.get(0);
            
            for (int i = 1; i < AL.size(); i++)
            {
                insert(AL.get(i));
            }
        }
    }
    
    public void insert( pNode temp1, pNode temp2)
    {
        if(temp1.value <= temp2.value)
        {
            temp1.children.add(temp2);
            min.children.add(temp1);
        }
        else
        {
            temp2.children.add(temp1);
            min.children.add(temp2);
        }
    }
    
    public pNode merge (pNode t1, pNode t2)
    {
        int newValue = t1.value + t2.value;
        pNode newNode = new pNode(newValue);
        newNode.left = t1;
        newNode.right = t2;
        return newNode;
    }
    
}
