package verma.slidingwindow;
import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
	  HashMap<Character,Integer>map = new HashMap<Character,Integer>();
	  int maxLength = 0;
	  
	  //Traverse the length
	  for(int i=0,j=0; i<arr.length; i++) {
		  map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
		  
		  while(map.size() > 2) {
			 map.put(arr[j],map.get(arr[j])-1);
			 if(map.get(arr[j]) == 0)
				 map.remove(arr[j]);
			 j++;
		  }
		  
		  if(map.size() == 2) {
			  maxLength = Math.max(maxLength, (i-j+1));
		  }
	  }
	  
	  return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Maximum number of fruits: " + 
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println("Maximum number of fruits: " + 
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
  }
}
