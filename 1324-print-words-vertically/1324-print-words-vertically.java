class Solution {
    public List<String> printVertically(String s) {
        String arr[]=s.split(" ");
        List<String> ans=new ArrayList<>();

        int maxlen=0;
        for(String st:arr) maxlen=Math.max(maxlen,st.length());

        int i=0;
        while(i<maxlen){
            StringBuilder sb=new StringBuilder();
            for(String st:arr){
                if(i>=st.length()) sb.append(" ");
                else sb.append(st.charAt(i));
            }ans.add(sb.toString().stripTrailing());
            i++;
        }return ans;   
    }
}