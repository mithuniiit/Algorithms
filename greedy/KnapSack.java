package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class KnapSack {
	
	int[] wt = {10, 40, 20, 30}; 
    int[] val = {60, 40, 100, 120}; 
    int capacity = 50; 
    
    static class ItemValue {
    	Double cost;
    	double wt,val,ind;
    	
    	public ItemValue(int wt,int val,int ind) {
    		this.wt=wt;
    		this.val=val;
    		this.ind=ind;
    		cost= new Double(val/wt);
    	}
    }

    public static void main(String[] args) {
    	int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 40, 100, 120}; 
        int capacity = 50; 
  
        double maxValue = getMaxValue(wt, val, capacity); 
        System.out.println("Maximum value we can obtain = " +  
                            maxValue); 
	}
    private static double getMaxValue(int[] wt, int[] val, int capacity) {
	
        ItemValue[] iVal = new ItemValue[wt.length]; 
        for(int i=0;i<wt.length;i++) {
        	iVal[i] = new ItemValue(wt[i], val[i], i);
        }
        
        Arrays.sort(iVal,new Comparator<ItemValue>() {
        	@Override
        	public int compare(ItemValue o1,ItemValue o2) {
        		return o2.cost.compareTo(o1.cost);
        	}
        });
        
        double totalValue = 0d;
        for(ItemValue i : iVal) {
        	double curWt = i.wt;
        	double curVal = i.val;
        	
        	if(capacity-curWt > 0) {
        		capacity = (int)(capacity-curWt); 
                totalValue += curVal; 
        	}else {
        		double fraction = (double)(capacity/curWt);
        		totalValue += (curVal*fraction); 
        		capacity -= curWt*fraction;
        		break;
        	}
        }
        return totalValue;
    }
}
