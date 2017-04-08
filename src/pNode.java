import java.util.*;

public class pNode {
    int value;
    public pNode(int x)
    {
        value = x;
    }    
    pNode left = null;
    pNode right = null;
    
    ArrayList<pNode> children = new ArrayList<>();
}
