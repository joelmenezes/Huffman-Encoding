public class TreeNode 
{
    int element;
    int value;

    TreeNode left=null;
    TreeNode right=null;
    
    TreeNode(int a) 
    {
        value = a; 
        element = -1;
    }
    
    TreeNode(int a,int b) 
    {
        value = a; 
        element = b;
    }

}