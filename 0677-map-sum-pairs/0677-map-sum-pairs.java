class MapSum {
    HashMap<String,Integer> map=new HashMap<>();
    public MapSum() {
        
    }
    public void insert(String key, int val) {
        if(map.containsKey(key)) map.remove(key);
        map.put(key,val);
    }
    
    public int sum(String prefix){
        int sum=0;
        for(String key:map.keySet()){
            if(key.length()>=prefix.length()){
                String prefixKey=key.substring(0,prefix.length());
                if(prefixKey.equals(prefix)) sum+=map.get(key);
            }
        }return sum;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */