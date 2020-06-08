package DivideConquer;

public class Power {

	static int pow(int x, int y) {
		if(y==0)
			return 1;
		
		if(y%2 == 0)
			return pow(x,y/2) * pow(x,y/2);
		else
			return x * pow(x,y/2) * pow(x,y/2);
	}
	
	static float powIterative(int x, int y) {
	       float temp; 
	        if( y == 0) 
	            return 1; 
	        temp = powIterative(x, y/2);  
	          
	        if (y%2 == 0) 
	            return temp*temp; 
	        else
	        { 
	            if(y > 0) 
	                return x * temp * temp; 
	            else
	                return (temp * temp) / x; 
	        } 
	}
	
	public static void main(String[] args) {
		System.out.println(powIterative(2,-3));
	}
}
