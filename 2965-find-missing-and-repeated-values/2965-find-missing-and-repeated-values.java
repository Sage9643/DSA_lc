class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int rep=0;
        HashSet<Integer> set=new HashSet<>();

        for(int arr[]:grid){
            for(int a:arr){
                if(set.contains(a))rep=a;
                set.add(a);
            }
        }int missing=0;
        for(int i=1;i<=n*n;i++){
            if(!set.contains(i)){
                missing=i;
                break;
            }
        
        }return new int[]{rep,missing};
    }
}