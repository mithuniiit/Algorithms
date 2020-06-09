package DivideConquer;

public class MedianOfTwoArrays {

	static int getMedian(int []a1, int []a2,int startA, int startB, int endA, int endB ) {
		
		//if only 1 element take max of start and min of end
		if(endA - startA == 1)
			return (Math.max(a1[startA],a1[startB]) + Math.min(a1[endA],a1[endB]))/2;
		
		int m1 = median(a1,startA, endA);
		
		int m2 = median(a2,startB, endB);
		
		if(m1 == m2)
			return m1;
		
		if(m1 < m2) {
			return getMedian(a1,a2,(endA + startA + 1)/2, startB, endA, (startB+endB+1)/2);
		}else {
			return getMedian(a1,a2,startA,(startB+endB+1)/2, (endA + startA + 1)/2, endB);
		}
	}
	
	
	static int median(int []a, int start, int end) {
		int n = end - start + 1;
		if(n%2 == 0)
			return (a[start + n/2] + a[start + n/2 - 1])/2;
		else
			return (a[start + n /2]);
	}
	
	
	public static void main(String[] args) {
		int ar1[] = { 1, 2, 3, 6 }; 
        int ar2[] = { 4, 6, 8, 10 }; 
        int n1 = ar1.length; 
        int n2 = ar2.length; 
        if (n1 != n2) { 
            System.out.println( 
                "Doesn't work for arrays "
                + "of unequal size"); 
        } 
        else if (n1 == 0) { 
            System.out.println("Arrays are empty."); 
        } 
        else if (n1 == 1) { 
            System.out.println((ar1[0] + ar2[0]) / 2); 
        } 
        else { 
            System.out.println( 
                "Median is "
                + getMedian( 
                      ar1, ar2, 0, 0, 
                      ar1.length - 1, ar2.length - 1)); 
        } 

	}

}
