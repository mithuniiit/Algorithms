package verma.slidingwindow;
import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
	  Set<Character> set = new HashSet<Character>();
	  int maxLength = 0;
	  
	  for(int i=0,j=0;i<str.length();i++) {
		  while(set.contains(str.charAt(i))) {
			  set.remove(str.charAt(j));
			  j++;
		  }
		  set.add(str.charAt(i));
		  maxLength = Math.max(maxLength,i-j+1);
	  }
	  return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
  }
}