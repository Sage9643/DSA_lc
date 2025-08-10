class LRUCache {
    LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
    private int size;
    public LRUCache(int capacity) {
        this.size=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            int value=map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }else if(map.size()>=size){
            map.remove(map.keySet().iterator().next());
        }map.put(key,value);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */