class Solution {
    public int minOperations(String s) {
        int op1=0;
        int op2=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(i%2==0){
                if(ch-'0'==0) op2++;
                else op1++;
            }else{
                if(ch-'0'==0) op1++;
                else op2++;
            }
        }return Math.min(op1,op2);
    }
}