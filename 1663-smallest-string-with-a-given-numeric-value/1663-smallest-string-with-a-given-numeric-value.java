class Solution {
    public String getSmallestString(int n, int k) {
        char arr[]=new char[n];
        Arrays.fill(arr,'a');
        int idx=n-1;
        k=k-n;
        while(k>0){
            int add=Math.min(25,k);
            arr[idx]+=add;
            idx--;
            k-=add;

        }StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(arr[i]);
        }return sb.toString();
    }
}