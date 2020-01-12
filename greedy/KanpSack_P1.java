package greedy;
import java.util.Comparator;
import java.util.PriorityQueue;

class Item{
    int wt;
    int val;
    int capacity;
    double cost;

    public Item(int wt, int val, int capacity){
        this.wt = wt;
        this.val = val;
        this.capacity = capacity;
        cost = val/wt;
    }
}


class ItemCompare implements Comparator<Item>{
    @Override
    public int compare(Item x,Item y){
        return (y.cost - x.cost) > 0 ? 1 : -1;
    }

}

class KanpSack_P1{

    public static double computeVal(int[] wt, int[]val, int capacity){
        int n = wt.length;
        PriorityQueue<Item> p = new PriorityQueue<Item>(n,new ItemCompare());
        for(int i=0;i<n;i++){
            p.add(new Item(wt[i],val[i],capacity));
        }

        double currVal = 0;
        while(p.size() > 0){
            Item x = p.poll();
            int curWt = x.wt;
            int curVal = x.val;
            if(capacity - curWt >= 0){
                currVal += x.val;
                capacity -= curWt;
            }else{
                double fraction = (double)capacity/(double)(curWt);
                currVal += curVal * fraction;
                capacity -= curWt * fraction;
                break;
            }
        }
        return currVal;
    }

    public static void main(String[] args){
        int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 40, 100, 120}; 
        int capacity = 50; 
        System.out.println("Final Value is " +computeVal(wt,val,capacity));
    }
}
