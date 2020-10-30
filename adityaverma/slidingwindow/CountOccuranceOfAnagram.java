package verma.slidingwindow;

public class CountOccuranceOfAnagram {

	public CountOccuranceOfAnagram() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
//		String text = "forxxorfxdofr"; 
//        String word = "for";
		
		String text = "aabaabaa"; 
        String word = "aaba"; 
        
        System.out.print(countAnagrams(text, word)); 
	}
	
	private static int countAnagrams(String text, String word) {
		int textCount[] = new int[128];
		int wordCount[] = new int[128];
		
		for(int i=0; i<word.length(); i++) {
			wordCount[word.charAt(i)]++;
		}
		
		int count = 0;
		for(int i=0,j=0;i<text.length();i++) {
			textCount[text.charAt(i)]++;
			
			if(i-j+1 == word.length()) {
				if(check(textCount,wordCount)) {
					count++;
				}
				textCount[text.charAt(j)]--;
				j++;
			}
		}
		
		return count;
	}
	
	public static boolean check(int[] textCount, int[] wordCount) {
		for(int i=0; i<textCount.length;i++) {
			if(textCount[i] != wordCount[i])
				return false;
		}
		return true;
	}
}
