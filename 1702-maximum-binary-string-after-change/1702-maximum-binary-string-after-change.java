class Solution {
    public String maximumBinaryString(String binary) {
        int zero=0,one=0;
        int i=0;
        StringBuilder sb=new StringBuilder();
        for(;i<binary.length();i++){
            if(binary.charAt(i)=='0')break;
            sb.append('1');
        }
        while(i<binary.length()){
            if(binary.charAt(i)=='0') zero++;
            else one++;
            i++;
        }for(int j=0;j<zero-1;j++){
            sb.append('1');
        }if(zero>0)sb.append('0');
        for(int j=0;j<one;j++) sb.append('1');

        return sb.toString();
    }
}