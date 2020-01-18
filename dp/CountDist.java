package dp;

class CountDist{


    public static int printCountDist(int n){

        int[] count = new int[n+1];
        /*
         0 - 0
         1 - 1
         2 - [1,1] [2]
        */
        count[0]=1;
        count[1]=1;
        count[2]=2;
        for(int i=3;i<n+1;i++){
            count[i]=count[i-1]+count[i-2]+count[i-3];
        }

        return count[n];

    }


    public static void main(String[] args){
        int n = 5;
        System.out.println(printCountDist(n));
    }

}
