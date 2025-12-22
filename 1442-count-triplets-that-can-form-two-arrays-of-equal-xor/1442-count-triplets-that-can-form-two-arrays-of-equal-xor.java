class Solution {
    public int countTriplets(int[] arr) {
        int cnt=0;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        map.put(0,new ArrayList<>());map.get(0).add(-1);
        int xor=0;

        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            if(map.containsKey(xor)){
                for(int j=0;j<map.get(xor).size();j++){
                    cnt+=(i-map.get(xor).get(j)-1);
                }
            }

            else if(!map.containsKey(xor)) map.put(xor,new ArrayList<>());
            map.get(xor).add(i);
            
        }return cnt;
    }
}