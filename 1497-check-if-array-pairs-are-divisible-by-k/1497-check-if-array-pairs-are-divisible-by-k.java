class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:arr){
            int rem=a%k;
            if(rem>=0)map.put(rem,map.getOrDefault(rem,0)+1);
            else map.put(k+rem,map.getOrDefault(k+rem,0)+1);
        }
        for(int key:map.keySet()){
            if(key==0){
                if(map.get(0)%2!=0) return false;
            }
            else if(k-key==key){
                if(map.get(key)%2!=0) return false;
            }
            else{
                if(!map.containsKey(k-key)) return false;
                if(!map.get(k-key).equals((map.get(key)))) return false;
            }
        }return true;
    }
}