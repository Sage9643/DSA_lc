class Solution {
    public int[] sortByBits(int[] arr) {
        int ans[][]=new int[arr.length][2];

        for(int i=0;i<arr.length;i++){
            int cnt=cntone(arr[i]);
            ans[i][0]=arr[i];
            ans[i][1]=cnt;
        }
        Arrays.sort(ans,(a,b)->{
            if(a[1]==b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });

        for(int i=0;i<arr.length;i++){
            arr[i]=ans[i][0];
        }return arr;
    }
    public static int cntone(int num){
        int cnt=0;
        while(num>1){
            int rem=num%2;
            cnt+=rem==0?0:1;
            num/=2;
        }cnt+=num==1?1:0;
        
        return cnt;

    }
}
