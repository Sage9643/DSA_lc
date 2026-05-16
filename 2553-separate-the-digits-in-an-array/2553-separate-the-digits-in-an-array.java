class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int num:nums) dig(arr,num);

        int ans[]=new int[arr.size()];
        int idx=0;
        for(int a:arr) ans[idx++]=a;

        return ans;
    }public static void dig(ArrayList<Integer> arr, int num){
        int len=Integer.toString(num).length();
        int p=len-1;

        while(len>0){
            int t=(int)Math.pow(10,p);
            int n=num/t;
            arr.add(n);
            num=num%t;p--;len--;
        }
    }
}