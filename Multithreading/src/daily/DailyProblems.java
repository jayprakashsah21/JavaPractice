package daily;

import java.util.Stack;

/*Given an array of integers, find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. 
 * The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.*/
//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class DailyProblems {
	public static void main(String[] args) {

		TreeNode l1 = new TreeNode(1);
		l1.left = new TreeNode(2);
		l1.right = new TreeNode(3);
		l1.left.left = new TreeNode(4);
		l1.left.right = new TreeNode(5);
		TreeNode l2 = new TreeNode(5);
		l2.left = new TreeNode(2);
		l2.right = new TreeNode(3);
		l2.left.left = new TreeNode(4);
		l2.left.right = new TreeNode(5);

		System.out.println(backspaceCompare("ab#c"
				,"ad#c"));

	}

	public static char findTheDifference(String s, String t) {
		int charCode = t.charAt(s.length());
		// Iterate through both strings and char codes
		for (int i = 0; i < s.length(); ++i) {
			charCode -= (int) s.charAt(i);
			charCode += (int) t.charAt(i);
		}
		return (char) charCode;
	}

	public static boolean backspaceCompare(String S, String T) {

		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();
		int i = 0;
		while (i < S.length()) {
			if (!s1.empty() && S.charAt(i) == '#') {
				s1.pop();
			}else if( S.charAt(i) != '#') {
				s1.add(S.charAt(i));
			}i++;
		}
		i = 0;
		while (i < T.length()) {
			if (!s2.empty() && T.charAt(i) == '#') {
				s2.pop();
			} else if( T.charAt(i) != '#') {
				s2.add(T.charAt(i));
			}
			i++;
		}
		return compareStacks(s1, s2);
	}

	static <T> boolean compareStacks(Stack<T> a, Stack<T> b) {
		if (a.isEmpty() != b.isEmpty())
			return false;
		if (a.isEmpty() && b.isEmpty())
			return true;
		T element_a = a.pop();
		T element_b = b.pop();
		try {
			if (((element_a == null) && (element_b != null)) || (!element_a.equals(element_b)))
				return false;
			return compareStacks(a, b);
		} finally { // restore elements
			a.push(element_a);
			b.push(element_b);
		}
	}
}
