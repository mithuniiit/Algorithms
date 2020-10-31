package verma.slidingwindow;

public class SmallesetSubStringWhichContainsAllTheCharacters {

	public SmallesetSubStringWhichContainsAllTheCharacters() {
		// TODO Auto-generated constructor stub
	}
	
	public static void findWindow(String str, String pattern){
		
		if(pattern.length() > str.length()) {
			System.out.println("No Solution");
		}
		
		int count = pattern.length();
		int[] patternMap = new int[26];
		
		for(int i=0;i<pattern.length();i++) {
			patternMap[pattern.charAt(i) - 'a']++;
		}
		
		int finalStart = Integer.MAX_VALUE, finalEnd = 0;
		
		for(int windowStart=0,windowEnd=0; windowStart<str.length(); windowStart++) {

			//Check if the character is in the pattern.
			if(pattern.indexOf(str.charAt(windowStart)) != -1) {
				if(--patternMap[str.charAt(windowStart) - 'a'] >= 0)
					count--;
				
				while(count <= 0) {
					if(count == 0 && ((windowStart - windowEnd) < (finalStart - finalEnd))) {
						finalStart = windowStart;
						finalEnd = windowEnd;
					}
					
					if(pattern.indexOf(str.charAt(windowEnd)) != -1) {
						patternMap[str.charAt(windowEnd) - 'a']++;
						if(patternMap[str.charAt(windowEnd) - 'a'] > 0){
							count++;
						}
					}
					windowEnd++;
				}
			}
		}
		
		System.out.println("Min Substring is " + str.substring(finalEnd, finalStart+1));
	}
	
	public static void main(String[] args) {
		String str = "badeaebcaae";
		String pattern = "aabc";
		findWindow(str,pattern);
	}

}
