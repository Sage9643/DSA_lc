class Solution {
    public String arrangeWords(String text) {
        String w[]=text.split(" ");

        Arrays.sort(w,(a,b)->{
            return a.length()-b.length();
        });

        for(int i=0;i<w.length;i++){
            if(i!=0) {
                String s=Character.toLowerCase(w[i].charAt(0))+w[i].substring(1,w[i].length());
                w[i]=s;
            }
            else {
                String s=Character.toUpperCase(w[i].charAt(0))+w[i].substring(1,w[i].length());
                w[i]=s;
            }
        }
        StringBuilder sb=new StringBuilder();

        for(String s:w){
            sb.append(s);sb.append(" ");
        }sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}