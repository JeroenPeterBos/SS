package ss.week4;

import java.util.*;

public class MergeSort {
    public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
    	if(list.size() == 1 || list.size() == 0){
    		return;
    	}
    	
    	int mid = list.size() / 2;
    	System.out.println(mid);
    	
    	List<Elem> l1 = new ArrayList<Elem>();
    	Collections.copy(l1, list.subList(0, mid));
    	List<Elem> l2 = new ArrayList<Elem>(list.size() / 2);
    	Collections.copy(l2, list.subList(mid, l2.size()));
    	
    	list.clear();
    	
    	System.out.println(list.toString());
    	System.out.println(l1.toString());
    	
    	mergesort(l1);
    	mergesort(l2);
    	
    	
    	return;
    }
    
    public static void main(String[] args) {
    	List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MergeSort.mergesort(sequence);
    }
}
