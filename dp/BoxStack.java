package dp;

import java.util.Arrays;

class BoxStack{

    static class Box implements Comparable<Box>{ 
        int l,b,h,area;

        public Box(int l, int b, int h){
            this.l = l;
            this.b = b;
            this.h = h;
            this.area = l * b;
        }

        public int compareTo(Box b){
            return this.area - b.area;
        }
    }

    
    public static int maxStackHeight(Box[] arr, int n){
        Box[] boxArray = new Box[n*3];
        
        for(int i=0;i<n;i++){
            boxArray[3*i] = new Box(arr[i].l, Math.max(arr[i].b, arr[i].h), Math.min(arr[i].b, arr[i].h));
            boxArray[3*i+1] = new Box(arr[i].b, Math.max(arr[i].l, arr[i].h), Math.min(arr[i].l, arr[i].h));
            boxArray[3*i+2] = new Box(arr[i].h, Math.max(arr[i].l, arr[i].b), Math.min(arr[i].l, arr[i].b));
        }
        
        Arrays.sort(boxArray);
        
        
        for(int i=0;i<3*n;i++){
            System.out.println(boxArray[i].l + " " + boxArray[i].b + " " + boxArray[i].h);
        }
        
        
        
        int[] height = new int[n*3];
        int maxHeight;
        for(int i=0; i<n*3; i++){
            maxHeight = 0;
            for(int j=0;j<i;j++){
                if(boxArray[j].l < boxArray[i].l && boxArray[j].b < boxArray[i].b){
                    maxHeight = Math.max(maxHeight,boxArray[j].h);
                }
            }
            height[i] = boxArray[i].h + maxHeight;
        }

        maxHeight = 0;
        for(int i=0;i<n*3;i++){
            maxHeight = Math.max(maxHeight,height[i]);
        }


        return maxHeight;
    }




    /* Driver program to test above function */
    public static void main(String[] args) { 
            
        Box[] arr = new Box[4]; 
        arr[0] = new Box(4, 6, 7); 
        arr[1] = new Box(1, 2, 3); 
        arr[2] = new Box(4, 5, 6); 
        arr[3] = new Box(10, 12, 32); 
        
        System.out.println("The maximum possible height of stack is "+ maxStackHeight(arr,4)); 
    } 
}
