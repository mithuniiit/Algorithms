package arrays.OrderStat;

public class MinMaxTournamentMethod {

	static class Pair{
		int min;
		int max;
		
		Pair(){
			this.min = 0;
			this.max = 0;
		}
		
		Pair(int min, int max){
			this.min = min;
			this.max = max;
		}
	}
	
	
	static Pair getMinMaxUtil(int[]a, int n, int low, int high) {
		if(low == high)
			return new Pair(a[low],a[low]);
		
		if(low+1 == high){
			if(a[low] < a[high])
				return new Pair(a[low],a[high]);
			else
				return new Pair(a[high],a[low]);
		}
		
		int mid = (low+high)/2;
		Pair mml = getMinMaxUtil(a,n,low,mid);
		Pair mmh = getMinMaxUtil(a,n,mid+1,high);
		int min;
		int max;
		
		if(mml.min < mmh.min)
			min = mml.min;
		else
			min = mmh.min;
		
		if(mml.max < mmh.max)
			max = mmh.max;
		else
			max = mml.max;
		
		return new Pair(min,max);
	}
	
	static Pair getMinMax(int[] a, int n) {
		return getMinMaxUtil(a,n,0,n-1);
	}
	
	public static void main(String[] args) {
		int[] a = {1000, 11, 445, 1, 330, 3000}; 
		int n = a.length;
		
		Pair minMax = getMinMax(a,n);
		System.out.println(minMax.min +" "+minMax.max);
	}
}
