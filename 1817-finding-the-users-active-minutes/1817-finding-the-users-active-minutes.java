class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();

        for(int log[]:logs){
            if(!map.containsKey(log[0]))map.put(log[0],new HashSet<>());
            map.get(log[0]).add(log[1]);
        }
        HashMap<Integer,Integer> m=new HashMap<>();
        for(int key:map.keySet()){
            m.put(map.get(key).size(),m.getOrDefault(map.get(key).size(),0)+1);
        }
        int ans[]=new int[k];

        for(int key:m.keySet()){
            ans[key-1]=m.get(key);
        }return ans;
    }
}