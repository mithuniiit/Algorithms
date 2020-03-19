package stack;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(exp)); 
	}
	
	private static int Prec(char ch) {
		switch (ch) 
		{ 
		case '+': 
		case '-': 
			return 1; 

		case '*': 
		case '/': 
			return 2; 

		case '^': 
			return 3; 
		} 
		return -1; 
	}

	private static boolean isCharOrNumber(char ch) {
		if( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
			return true;
		return false;
	}
	private static String infixToPostfix(String exp) {
		Stack<Character> s = new Stack<>();
		String result = new String("");
		
		for(int i=0 ;i<exp.length(); i++) {
			char ch = exp.charAt(i);
			if(isCharOrNumber(ch)) {
				result += ch;
			}else if(ch == '(') {
				s.push(ch);
			}else if(ch == ')') {
				while(!s.isEmpty() && s.peek() != '(') {
					result += s.pop();
				}
				if(!s.isEmpty() && s.peek() != '(') {
					//How about throwing exception here?
					return "Invalid";
				}else
					s.pop();
			}else { //operator --- need to check precendency
				while( !s.isEmpty() && Prec(ch) <= Prec(s.peek())){ 
					result += s.pop();
				}
				s.push(ch);
			}
		}
		
		//Iterating through string is complete...lets pop if any
		while(!s.isEmpty()) {
			result += s.pop();
		}
		
		return result;
	}
}
