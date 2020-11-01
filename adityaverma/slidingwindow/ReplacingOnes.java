package verma.slidingwindow;
class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
	  int length = 0;
	  int nonZeroCount = 0;
	  for(int i=0,j=0; i<arr.length; i++) {
		  if(arr[i] == 0)
			  nonZeroCount++;
		  
		  while(nonZeroCount > k) {
			  if(arr[j] == 0)
				  nonZeroCount--;
			  j++;
		  }
		  length = Math.max(length,i-j+1);
	  }
	  return length;
  }

  public static void main(String[] args) {
    System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
    System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
  }
}
