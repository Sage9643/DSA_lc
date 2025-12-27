class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();

        for(int i=1;i<=Math.ceil(Math.sqrt(n));i++){
            if(n%i==0) {
                arr.add(i); 
                set.add(i);
            }
        }for(int i=arr.size()-1;i>=0;i--){
            int factor=n/arr.get(i);
            if(!set.contains(factor)) arr.add(factor);
        }
        if(arr.size()<k) return -1;
        return arr.get(k-1);
    }
}