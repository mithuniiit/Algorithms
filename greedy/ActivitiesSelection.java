class ActivitiesSelection {

	public static void printMaxActivities(int[] s, int[] f, int n){
		int i,j;
		
		for(int i=0,j=1;j<n;j++){
			if(s[j] >= f[i]){
				System.out.println(j+"");
				i=j;
			}
		}
	}
	public static void main(String[] args){
		int s[] = {1,3,0,5,8,5};
		int f[] = {2,4,6,7,9,9};
		int n = s.length;
		printMaxActivities(s,f,n);
	}
}
	
