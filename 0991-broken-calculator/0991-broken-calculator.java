class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue==target) return 0;
        if(startValue>target) return startValue-target;

        int op=0;
        while(target>startValue){
            if(target%2==1){
                target++;
            }
            else target/=2;
            op++;
        }return op +(startValue-target);  
    }
}