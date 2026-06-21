class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=0;
        for(int c:costs) max=Math.max(max,c);

        int count[]=new int[max+1];
        for(int c:costs) count[c]++;

        int cnt=0;
        for(int i=0;i<count.length;i++){
            if(coins<i) break;
            if(count[i]!=0){
                int tot=i*count[i];
                if(tot<=coins){
                    cnt+=count[i];
                    coins-=tot;
                    if(coins==0) break;
                }else{
                    int part=coins/i;
                    cnt+=part;
                    coins-=(i*part);
                }
            }
        }return cnt;
    }
}