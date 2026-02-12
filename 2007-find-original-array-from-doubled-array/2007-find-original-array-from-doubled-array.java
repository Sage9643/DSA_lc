class Solution {
    public int[] findOriginalArray(int[] changed) {
        ArrayList<Integer> arr=new ArrayList<>();
        Arrays.sort(changed);

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num:changed) map.put(num,map.getOrDefault(num,0)+1);

        for(int num:changed){
            if(map.containsKey(num)){
                arr.add(num);
                map.put(num,map.getOrDefault(num,0)-1);
                if(map.get(num)==0) map.remove(num);

                if(!map.containsKey(num*2)) return new int[]{};

                map.put(num*2,map.getOrDefault(num*2,0)-1);
                if(map.get(num*2)==0) map.remove(num*2);
            }
        }int ans[]=new int[arr.size()];

        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }return ans;


    }
}