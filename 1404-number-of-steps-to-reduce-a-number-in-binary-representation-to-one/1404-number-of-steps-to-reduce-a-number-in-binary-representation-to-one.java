class Solution {
    public int numSteps(String s) {
        StringBuilder sb=new StringBuilder(s);
        int steps=0;
        while(sb.length()!=1 && sb.charAt(0)=='1'){
            if(sb.charAt(sb.length()-1)=='0') sb.deleteCharAt(sb.length()-1);
            else{
                int i=sb.length()-1;
                while(i>=0 && sb.charAt(i)=='1') sb.setCharAt(i--,'0');
                if(i==-1) sb.insert(0,'1');
                else sb.setCharAt(i,'1');
            }steps++;
        }return steps;
    }
}