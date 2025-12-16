class Solution {
    public String maxSumOfSquares(int num, int sum) {
        long max=num*9;
        if(sum>max) return ""; 
        StringBuilder sb=new StringBuilder();
        while(sum>0 && num>0){
            for(int i=9;i>=0;i--){
                if(i<=sum) {sb.append(Integer.toString(i));sum-=i;num--;break;}
                
            }
        }while(num>0) {sb.append("0");num--;}
        return sb.toString();
    }
}