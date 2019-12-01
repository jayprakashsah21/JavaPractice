package daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * 
 * class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */

public class Test {
	 public static void main(String[] args) {
		 islandPerimeter(new int[][] {{1,0}});
	      
	    }
	    static int m;
		static int n;
	    public static int islandPerimeter(int[][] grid) {
	       int count=0;
	         n=grid.length;
	        if(n==0) return 0;
	         m=grid[0].length;
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(grid[i][j]==1){
	                  count+=permeCoint(grid,i,j);
	                }
	            }
	        }
	        return count;
	    }
	    
	    private static int permeCoint(int[][] grid,int i,int j){
	    	Stack<Character> s=new Stack<>();
	        int sum=0;
	       if(i<=0 || (i-1>0 && grid[i-1][j]==0)){
	           sum+=1;
	       }
	        if(i>n || (i+1>n && grid[i+1][j]==0)){
	          sum+=1;
	       }
	           if(j<=0 || (j-1>=0 && grid[i][j-1]==0)){
	           sum+=1;
	       }
	        if(j>=m || (j+1>m && grid[i][j+1]==0)){
	           sum+=1;
	       }
	       return sum; 
	    
	    }
	}
	class TrieNode {
	    Map<Character, TrieNode> children = new HashMap();
	    int score;
	}
