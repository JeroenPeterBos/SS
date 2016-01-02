package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapUtil {
	
	//@ ensures \result == true || \result == false;
    /*@ pure */ public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        HashSet<V> v = new HashSet<V>();
        for(V val: map.values()){
        	if(!v.add(val)){
        		return false;
        	}
        }
        return true;
    }
    
    
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        for(V val : range){
        	if(!map.containsValue(val)){
        		return false;
        	}
        }
        return true;
    }
    
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
    	Map<V, Set<K>> result = new HashMap<V, Set<K>>();
    	
    	K[] keys = (K[])map.keySet().toArray();
    	
    	for(int i = 0; i < keys.length; i++){
    		if(map.containsKey(keys[i])){
	    		if(!result.containsKey(map.get(keys[i]))){
	    			Set<K> set = new HashSet<K>();
	        		set.add(keys[i]);
	        		result.put(map.get(keys[i]), set);
	        		map.remove(keys[i]);
	        		i--;
	    		} else {
	    			result.get(map.get(keys[i])).add(keys[i]);
	    			map.remove(keys[i]);
	    		}
    		}
    	}
    	return result;
	}
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> result = new HashMap<V, K>();
		
		K[] keys = (K[])map.keySet().toArray();
		
		for(int i = 0; i< keys.length; i++){
			result.put(map.get(keys[i]), keys[i]);
		}
		
		return result;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        for(V val : f.values()){
        	if(!g.containsKey(val)){
        		return false;
        	}
        }
        return true;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> result = new HashMap<K, W>();
        
        K[] keys = (K[])f.keySet().toArray();
        
        for(int i = 0; i < keys.length; i++){
        	result.put(keys[i], g.get(f.get(keys[i])));
        }
        
        return result;
	}
}
