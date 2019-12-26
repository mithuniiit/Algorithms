
public class boggle {
	
	 static final String dictionary[] = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" }; 
	 static final int n = dictionary.length; 
	 static final int M = 3, N = 3;
	 static final int SIZE = 26; 
	 
	 
	 static class TrieNode{
		 TrieNode[] child = new TrieNode[SIZE];
		 boolean leaf;
		 public TrieNode() {
			 leaf = false;
			 for(int i=0;i<SIZE;i++) {
				 child[i]=null;
			 }
		 }
	 }
	  
	 static void insert(TrieNode root,String key) {
		 int n = key.length();
		 TrieNode pChild = root;
		 for(int i=0; i<n; i++) {
			 int index = key.charAt(i) - 'A';
			 if(pChild.child[index] == null)
				 pChild.child[index] = new TrieNode();
			 pChild = pChild.child[index];
		 }
		 pChild.leaf = true;
	 }
	    
	 
	public static void main(String[] args) {
		
		
		String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"}; 
        TrieNode root = new TrieNode(); 
        int n = dictionary.length; 
        for (int i=0; i<n; i++) 
            insert(root, dictionary[i]); 
       
		
		
		char boggle[][] = { { 'G', 'I', 'Z' }, 
                			{ 'U', 'E', 'K' }, 
                			{ 'Q', 'S', 'E' } }; 

		System.out.println("Following words of dictionary are present"); 
		findWords(boggle,root); 
	}
	
	 static boolean isSafe(int i, int j, boolean visited[][]) 
	 { 
	        return (i >=0 && i < M && j >=0 && 
	                j < N && !visited[i][j]);    
	 } 
	 
	 
	 
	 
	static void searchWord(TrieNode root, char boggle[][], int i, 
            int j, boolean visited[][], String str) 
	{
		
		if (root.leaf == true) 
	           System.out.println(str); 
		
		if (isSafe(i, j, visited)) 
        { 
            // make it visited 
            visited[i][j] = true;
            for (int K =0; K < SIZE; K++) 
            { 
                if (root.child[K] != null) 
                { 
                    char ch = (char) (K + 'A') ; 
                    if (isSafe(i+1,j+1,visited) && boggle[i+1][j+1] == ch) 
					searchWord(root.child[K],boggle,i+1,j+1, 
					                    visited,str+ch); 
					if (isSafe(i, j+1,visited)  && boggle[i][j+1] 
					                            == ch) 
					searchWord(root.child[K],boggle,i, j+1, 
					                   visited,str+ch); 
					if (isSafe(i-1,j+1,visited) && boggle[i-1][j+1]  
					                            == ch) 
					searchWord(root.child[K],boggle,i-1, j+1, 
					                   visited,str+ch); 
					if (isSafe(i+1,j, visited)  && boggle[i+1][j]  
					                           == ch) 
					searchWord(root.child[K],boggle,i+1, j, 
					                  visited,str+ch); 
					if (isSafe(i+1,j-1,visited) && boggle[i+1][j-1]  
					                           == ch) 
					searchWord(root.child[K],boggle,i+1, j-1, 
					                   visited,str+ch); 
					if (isSafe(i, j-1,visited)&& boggle[i][j-1]  
					                          == ch) 
					searchWord(root.child[K],boggle,i,j-1, 
					                  visited,str+ch); 
					if (isSafe(i-1,j-1,visited) && boggle[i-1][j-1]  
					                          == ch) 
					searchWord(root.child[K],boggle,i-1, j-1, 
					                 visited,str+ch); 
					if (isSafe(i-1, j,visited) && boggle[i-1][j]  
					                         == ch) 
					searchWord(root.child[K],boggle,i-1, j,  
					               visited,str+ch); 
                }
            }
        }
	}

	private static void findWords(char[][] boggle, TrieNode root) {
		boolean [][]visited = new boolean[M][N];
		TrieNode pChild = root;
		String str = "";
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(pChild.child[(boggle[i][j])-'A'] != null) {
					str=str+boggle[i][j];
					searchWord(pChild.child[(boggle[i][j]) - 'A'], 
                            boggle, i, j, visited, str);
					str = ""; 
				}
			}
		}
	}
}
