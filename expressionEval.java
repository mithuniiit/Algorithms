import java.util.Stack;

public class expresssionEval {
	
	private void evaluate(String expression) {
		
        char[] tokens = expression.toCharArray();
        Stack<Integer> value = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        for(int i=0;i<tokens.length;i++) {
        	if(tokens[i] >= '0' && tokens[i]<='9') {
        		StringBuilder sb = new StringBuilder().append(tokens[i]);
        		value.push(Integer.parseInt(sb.toString()));
        	}else if(tokens[i] == '(') {
        		operator.push('(');
        	}else if(tokens[i] == ')') {
        		while(operator.peek() == '(') {
        			value.push(getValue(tokens[i],value.pop(),value.pop()));
        		}
        		operator.pop();
        	}else {
        		while (!operator.empty() && hasPrecedence(tokens[i], operator.peek())) 
        			value.push(getValue(operator.pop(), value.pop(), value.pop())); 
        		operator.push(tokens[i]);
        	}
        }
        
        System.out.println("Expression Value"+value.pop());
	}
	
	
    private boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
    
	private int getValue(char op, int x,int y) {
		return x+y;
	}

	public static void main(String[] args) {
		expresssionEval expresssion = new expresssionEval();
		expresssion.evaluate("1+2+3");
	}
}
