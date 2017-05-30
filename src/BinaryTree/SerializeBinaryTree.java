package BinaryTree;
import java.util.*;

/*
 * 297. Serialize and Deserialize Binary Tree
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * 
 * 
 * For example, you may serialize the following tree
 *   1
 *  / \
 * 2   3
 *    / \
 *   4   5
 *as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
 *You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
   
 * */

public class SerializeBinaryTree {
	private static final String spliter = ",";
    private static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node == null){
                    sb.append(NN);
                    sb.append(spliter);
                }
                else{
                    sb.append(node.val);
                    sb.append(spliter);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        
        return sb.substring(0, sb.length()).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NN + spliter)){
            return null;
        }
        
        String[] val = data.split(spliter);
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int pos = 1;
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(val[pos].equals(NN)){
                node.left = null;
            }
            else{
                node.left = new TreeNode(Integer.parseInt(val[pos]));
                queue.offer(node.left);
            }
            pos++;
            if(val[pos].equals(NN)){
                node.right = null;
            }
            else{
                node.right = new TreeNode(Integer.parseInt(val[pos]));
                queue.offer(node.right);
            }
            pos++;
        }
        
        return root;
    }
}
