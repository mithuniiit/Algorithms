package stack;

import java.util.Stack;

public class PrefixToInfix {

	public static void main(String[] args) {
		String expression = "*-A/BC-/AKL";
		String output = PrefixToInfix(expression);
		System.out.println(output);
	}

	private static String PrefixToInfix(String exp) {
		String output = new String();
		Stack<String> s = new Stack<>(); 
		for(int i=exp.length()-1;i>=0;i--) {
			char ch = exp.charAt(i);
			if(isOperator(ch)) {
				s.push(s.pop()+ch+s.pop());
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
