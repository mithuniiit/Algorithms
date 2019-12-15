
public class PowerOfN {
	public static void main(String[] args) {
		System.out.println(power(2,8));
	}

	private static int power(int x, int y) {
		if(y == 0) {
			return 1;
		}
		if(y%2 == 0)
			return power(x,y/2) * power(x,y/2);
		else
			return x * power(x,y/2) * power(x,y/2);
	}
}
