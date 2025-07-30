class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String revnum1=reverse(num1);
        String revnum2=reverse(num2);

        int[] ans=new int[num1.length()+num2.length()];

        for(int i=0;i<revnum1.length();i++){
            int start=i;
            int carry=0;
            for(int j=0;j<revnum2.length();j++){
                int n1=revnum1.charAt(i)-'0';
                int n2=revnum2.charAt(j)-'0';
                int res=(n1*n2)+ans[start]+carry;
                int base=res%10;
                carry=res/10;

                ans[start++]=base;
            }if(carry!=0){
                ans[start]=carry;
            }
        }//removing trailing zeroes left bcz of empty spaces
        StringBuilder sb=new StringBuilder();
        int i=ans.length-1;
        while(i>=0 && ans[i]==0)i--;
        while(i>=0){
            sb.append(Integer.toString(ans[i]));
            i--;
        }return sb.toString();

    }
    public static String reverse(String num){
        StringBuilder sb=new StringBuilder();
        for(int i=num.length()-1;i>=0;i--){
            sb.append(num.charAt(i));
        }return sb.toString();
    }
}