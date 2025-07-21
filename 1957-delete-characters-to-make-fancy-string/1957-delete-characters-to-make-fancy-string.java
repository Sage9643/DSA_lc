class Solution {
    public String makeFancyString(String s) {
        if(s.length()==1 || s.length()==2){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(i==s.length()-1){
                
                sb.append(s.charAt(i));
                
            }else{
                if(s.charAt(i-1)!=s.charAt(i) || s.charAt(i+1)!=s.charAt(i)){
                    sb.append(s.charAt(i));
                }
            }
        }return sb.toString();
    }
}