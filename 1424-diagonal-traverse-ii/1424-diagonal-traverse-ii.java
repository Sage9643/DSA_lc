class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[2]==b[2]) return b[0]-a[0];
            return a[2]-b[2];
        });

        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                pq.add(new int[]{i,j,i+j});
            }
        }
        int[] ans=new int[pq.size()];
        int idx=0;
        while(!pq.isEmpty()){
            int el[]=pq.remove();
            ans[idx++]=(nums.get(el[0]).get(el[1]));
        }return ans;
    }
}