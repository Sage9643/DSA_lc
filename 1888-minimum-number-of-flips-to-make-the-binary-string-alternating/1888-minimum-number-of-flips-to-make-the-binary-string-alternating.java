class Solution {
    public int minFlips(String s) {
        int op1=0,op2=0;
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        for(int i=0;i<s.length()*2;i++){
            if(i%2==0){
                sb1.append("0");
                sb2.append("1");
            }else{
                sb2.append("0");
                sb1.append("1");
            }
        }
        StringBuilder sb=new StringBuilder(s);
        sb.append(sb);
        
        int k=0;
        for(;k<s.length();k++){
            if(sb.charAt(k)!=sb1.charAt(k)) op1++;
            if(sb.charAt(k)!=sb2.charAt(k)) op2++;
        }int minop1=op1,minop2=op2;
        int i=0;
        int j=k-1;

        while(j<sb.length()-1){
            if(sb.charAt(i)!=sb1.charAt(i)) op1--;
            if(sb.charAt(i)!=sb2.charAt(i)) op2--;
            i++;j++;
            if(sb.charAt(j)!=sb1.charAt(j)) op1++;
            if(sb.charAt(j)!=sb2.charAt(j)) op2++;
            minop1=Math.min(minop1,op1);
            minop2=Math.min(minop2,op2);
        }
        return Math.min(minop1,minop2);
    }
}