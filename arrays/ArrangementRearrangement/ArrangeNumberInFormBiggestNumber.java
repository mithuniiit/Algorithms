package arrays.rearrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrangeNumberInFormBiggestNumber {

	public static void printLargest(ArrayList<String> arr) {
		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return (s1+s2).compareTo(s2+s1) > 0 ? -1 : 1;
			}
		});
	}

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("54"); 
        arr.add("546"); 
        arr.add("548"); 
        arr.add("60"); 
        printLargest(arr);
        for(String s : arr) {
        	System.out.print(s);
        }
	}
}
