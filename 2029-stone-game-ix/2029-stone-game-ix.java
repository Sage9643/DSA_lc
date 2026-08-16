class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0=0,cnt1=0,cnt2=0;

        for(int s:stones){
            if(s%3==0) cnt0++;
            if(s%3==1) cnt1++;
            if(s%3==2) cnt2++;
        }
        int c0=cnt0;
        int c1=cnt1;
        int c2=cnt2;

        int turn=0;

        int sum=1;
        cnt1--;
        

        for(int i=1;i<stones.length;i++){
            turn=1-turn;

            if((sum==1 && cnt1==0 && cnt0==0) || (sum==2 && cnt2==0 && cnt0==0)){
                if(turn==1) return true;
                else{
                    break;
                }
            }
            else if((sum==1 && cnt1==0) || (sum==2 && cnt2==0)){
                cnt0--;
            }
            else if(sum==1){
                sum+=1;
                cnt1--;
                sum%=3;
            }
            else if(sum==2){
                sum+=2;
                cnt2--;
                sum%=3;
            }
        }turn=0;
        sum=2;
        c2--;

        for(int i=1;i<stones.length;i++){
            turn=1-turn;

            if((sum==1 && c1==0 && c0==0) || (sum==2 && c2==0 && c0==0)){
                if(turn==1) return true;
                else return false;
            }
            else if((sum==1 && c1==0) || (sum==2 && c2==0)){
                c0--;
            }
            else if(sum==1){
                sum+=1;
                c1--;
                sum%=3;
            }
            else if(sum==2){
                sum+=2;
                c2--;
                sum%=3;
            }
        } 
        return false;

    }
}