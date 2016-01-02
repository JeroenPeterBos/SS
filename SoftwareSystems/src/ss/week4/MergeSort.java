package ss.week4;

import java.util.*;

public class MergeSort {
    public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
    	if(list.size() == 1 || list.size() == 0){
    		return;
    	}
    	
    	int mid = list.size() / 2;
    	
    	List<Elem> l1 = new ArrayList<Elem>();
    	for(int i = 0; i < mid; i++){
    		l1.add(list.get(i));
    	}
    	
    	List<Elem> l2 = new ArrayList<Elem>();
    	for(int i = mid; i < list.size(); i++){
    		l2.add(list.get(i));
    	}
    	
    	mergesort(l1);
    	mergesort(l2);
    	
    	list.clear();
    	List<Elem> tempList = merge(l1, l2);
    	
    	for(int i = 0; i < tempList.size(); i++){
    		list.add(tempList.get(i));
    	}
    }
    
    public static <Elem extends Comparable<Elem>> List<Elem> merge(List<Elem> l1, List<Elem> l2) {
    	List<Elem> temp = new ArrayList<Elem>();
    	while(l1.size() > 0 && l2.size() > 0){
    		if(l1.get(0).compareTo(l2.get(0)) < 0){
    			temp.add(l1.get(0));
    			l1.remove(0);
    		} else {
    			temp.add(l2.get(0));
    			l2.remove(0);
    		}
    	}
    	
    	while(l1.size() > 0){
    		temp.add(l1.get(0));
    		l1.remove(0);
    	}
    	while(l2.size() > 0) {
    		temp.add(l2.get(0));
    		l2.remove(0);
    	}
    	
    	return temp;
    }
    
    public static void main(String[] args) {
    	List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MergeSort.mergesort(sequence);
    }
}
