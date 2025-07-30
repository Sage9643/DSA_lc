class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str=countAndSay(n-1);
        StringBuilder sb2=new StringBuilder();
        int count=1;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                count++;

            }else{
                sb2.append(Integer.toString(count));
                sb2.append(str.charAt(i));
                count=1;
            }
            
        }sb2.append(Integer.toString(count));
        sb2.append(str.charAt(str.length()-1));
        return sb2.toString();
    }
}