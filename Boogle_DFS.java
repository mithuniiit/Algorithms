
public class boogle_DFS {
    static final String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" }; 
    static int n = dictionary.length;
    static int M=3, N=3;
    
	public static void main(String[] args) {
		char boogle[][]= { {'G','I','Z'},
						   {'U','E','K'},
						   {'Q','S','E'}
						};
		
		findWords(boogle);
		
	}

	private static void findWords(char[][] boogle) {
		boolean visited[][] = new boolean[M][N];
		String str= "";
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++){
				findWordsUtil(boogle,visited,i,j,str);
			}
		}
	}

	private static void findWordsUtil(char[][] boogle, boolean[][] visited, int i, int j, String str) {
		visited[i][j]=true;
		str = str + boogle[i][j];
		if(isWord(str)) {
			System.out.println("WORD found "+str);
		}
		
		for(int row=i-1; (row<=i+1 && row <M); row++) {
			for(int col=j-1; (col<=j+1 && col<N); col++) {
				if(row>=0 && col>=0 && !visited[row][col]) {
					findWordsUtil(boogle,visited,row,col,str);
				}
			}
		}
		
		str = ""+ str.charAt(str.length()-1);
		visited[i][j]= false;
	}

	private static boolean isWord(String str) {
		for (int i = 0; i < n; i++) 
            if (str.equals(dictionary[i])) 
                return true; 
        return false; 
	}
}
