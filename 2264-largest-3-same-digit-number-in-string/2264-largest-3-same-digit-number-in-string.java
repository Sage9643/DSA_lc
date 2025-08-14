class Solution {
    public String largestGoodInteger(String num) {
        String maxGoodInt="";
        int i=0,j=1;
        while(j<num.length()){
            if(num.charAt(i)==num.charAt(j)){
                j++;
                if(j<num.length() && num.charAt(i)==num.charAt(j)){
                    maxGoodInt=maxGoodInt.compareTo(num.substring(i,j+1))>0?maxGoodInt:num.substring(i,j+1);
                    i=j+1;
                    j=j+2;
                }
            }else{
                i=j;j++;
            }
        }return maxGoodInt;
    }
}