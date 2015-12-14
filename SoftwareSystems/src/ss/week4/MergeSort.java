package ss.week4;

import java.util.*;

public class MergeSort {
    public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
    	if(list.size() == 1 || list.size() == 0){
    		return;
    	}
    	
    	int mid = list.size() / 2;
    	
    	List<Elem> l1 = list.subList(0, mid);
    	List<Elem> l2 = list.subList(mid, list.size() - 1);
    	
    	mergesort(l1);
    	mergesort(l2);
    	
    	int count1 = 0;
    	int count2 = 0;
    	
    	while(count1 < l1.size() && count2 < l2.size()){
    		if(l1.get(count1).compareTo(l2.get(count2)) < 0){
    			
    		}
    	}
    }
    
    public static void main(String[] args){
    	List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    	System.out.println(sequence.get(0).toString());
    	mergesort(sequence);
    }
}
