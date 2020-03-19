package stack;

import java.util.Stack;

public class PostfixToPrefix {

	public static void main(String[] args) {
		String expression = "ABC/-AK/L-*";
		String output = covertPostfixToPrefix(expression);
		System.out.println(output);
	}

	private static String covertPostfixToPrefix(String exp) {
		Stack<String> s = new Stack<>(); 
		for(int i=0;i<exp.length();i++) {
			char ch = exp.charAt(i);
			if(isOperator(ch)) {
				s.push(ch+s.pop()+s.pop());
			}else {
				s.push(Character.toString(ch));
			}
		}
		
		return s.pop();
	}

	private static boolean isOperator(char x) {
		switch (x) { 
		  case '+': 
		  case '-': 
		  case '/': 
		  case '*': 
		    return true; 
		  } 
		  return false; 
	}
}
