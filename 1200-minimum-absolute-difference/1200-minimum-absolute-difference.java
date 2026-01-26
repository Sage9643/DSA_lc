class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int mindiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++) mindiff=Math.min(mindiff,Math.abs(arr[i]-arr[i-1]));

        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])==mindiff){
                List<Integer> el=new ArrayList<>();
                el.add(arr[i-1]);
                el.add(arr[i]);
                ans.add(el);
            }
        }return ans;
    }
}