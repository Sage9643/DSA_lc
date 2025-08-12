class MapSum {
    HashMap<String,Integer> map=new HashMap<>();
    HashMap<String ,Integer> prefMap=new HashMap<>();
    public MapSum() {
        
    }
    public void insert(String key, int val) {
        int diff=val-map.getOrDefault(key,0);
        map.put(key,val);
        for(int i=1;i<=key.length();i++){
            String keySubstr=key.substring(0,i);
            prefMap.put(keySubstr,prefMap.getOrDefault(keySubstr,0)+diff);
        }
    }
    
    public int sum(String prefix){
        return prefMap.getOrDefault(prefix,0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */