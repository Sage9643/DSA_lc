class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb=new StringBuilder(s);
        
        while(sb.length()>k){
            int sum=0;
            int i=0,j=0;
            StringBuilder sb1=new StringBuilder();

            while(j<sb.length()){
                char ch=sb.charAt(j);
                sum+=ch-'0';
                if(j-i+1==k){
                    sb1.append(Integer.toString(sum));
                    sum=0;
                    i=j+1;
                }j++;   
            }
            if(sb.length()%k!=0) sb1.append(Integer.toString(sum));
            sb=sb1;
        }
        return sb.toString();
    }
}