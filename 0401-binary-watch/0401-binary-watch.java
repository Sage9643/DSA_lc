class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
       List<String> ans = new ArrayList<>();
        
        for (int i=0;i< 12; i++){
            for(int j=0;j<60;j++){
                int tot=cntBits(i)+cntBits(j);
                if (tot==turnedOn){
                    String s=i+":"+(j<10?"0":"")+j;
                    ans.add(s);
                }
            }
        }
        return ans;
    }
    public static int cntBits(int num) {
        int cnt=0;
        
        while(num>0){
            cnt+=(num&1);
            num=num>>1;     
        }
        return cnt;
    }
}