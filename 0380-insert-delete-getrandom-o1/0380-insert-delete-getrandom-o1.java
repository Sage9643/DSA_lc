class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> arr;
    Random rand;

    public RandomizedSet() {
        map=new HashMap<>();
        arr=new ArrayList<>();
        rand=new Random();
        
    }
    
    public boolean insert(int val){
        if(map.containsKey(val)) return false;
        
        arr.add(val);
        map.put(val,arr.size()-1);
        return true;
        
    }
    
    public boolean remove(int val){
        if(!map.containsKey(val)) return false;
        int idx=map.get(val);
        if(arr.size()>1)arr.set(idx,arr.get(arr.size()-1));
        
        if(arr.size()>1)map.put(arr.get(idx),idx);
        arr.remove(arr.size()-1);
        map.remove(val);
        return true;
        
    }
    
    public int getRandom(){
        int random=rand.nextInt(arr.size());
        return arr.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */