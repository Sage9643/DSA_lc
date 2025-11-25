class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if(nums.length==1) return 0;
        int numseven[]=nums.clone();
        int numsodd[]=nums.clone();

        int moveseven=0;
        int movesodd=0;

        for(int i=0;i<nums.length;i++){
            //even indexed
            if(i%2==0){
                if(i==0){
                    if(numsodd[i+1]>=numsodd[i]){
                        moveseven+=numsodd[i+1]-numsodd[i]+1;
                        numsodd[i+1]=numsodd[i]-1;
                    }
                }else if(i==nums.length-1){
                    if(numsodd[i-1]>=numsodd[i]){
                        moveseven+=numsodd[i-1]-numsodd[i]+1;
                        numsodd[i-1]=numsodd[i]-1;
                    }
                }
                else{
                    if(numsodd[i+1]>=numsodd[i]){
                        moveseven+=numsodd[i+1]-numsodd[i]+1;
                        numsodd[i+1]=numsodd[i]-1;
                    }if(numsodd[i-1]>=numsodd[i]){
                        moveseven+=numsodd[i-1]-numsodd[i]+1;
                        numsodd[i-1]=numsodd[i]-1;
                    }
                }
            }//odd indexed
            else{
                if(i==nums.length-1){
                    if(numseven[i-1]>=numseven[i]){ 
                        movesodd+=numseven[i-1]-numseven[i]+1;
                        numseven[i-1]=numseven[i]-1;
                    }
                }else{
                    if(numseven[i+1]>=numseven[i]){
                        movesodd+=numseven[i+1]-numseven[i]+1;
                        numseven[i+1]=numseven[i]-1;
                    }if(numseven[i-1]>=numseven[i]){
                        movesodd+=numseven[i-1]-numseven[i]+1;
                        numseven[i-1]=numseven[i]-1;
                    }
                }
            }
        }return Math.min(movesodd,moveseven);
    }
}