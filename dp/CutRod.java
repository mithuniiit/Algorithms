package dp;
class CutRod {

    public static int cutRod_Rec(int[] arr, int n){

        if(n<=0){
            return 0;
        }

        int min = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.max(min,cutRod_Rec(arr, n-i-1) + arr[i]);
        }

        return min;
    }

    public static int cutRod_Dp(int[] arr,int n){
        int[] val = new int[n+1];
        val[0]=0;

        for(int i=1;i<=n;i++){
            int sum =Integer.MIN_VALUE;
            for(int j=0;j<i;j++)  {
                sum = Math.max(sum,arr[j]+val[i-j-1]);
            }
            val[i]=sum;
        }
        return val[n];
    }


    public static void main(String[] args){
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
        System.out.println("Maximum Recursive Obtainable Value is " +cutRod_Rec(arr, size)); 
        System.out.println("Maximum Recursive Obtainable Value is " +cutRod_Dp(arr, size)); 
    }
}
