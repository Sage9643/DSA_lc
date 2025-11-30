class Solution {
    public String minRemoveToMakeValid(String s) {
        int open=0,close=0;
        Queue<Character> q=new LinkedList<>();

        for(char ch:s.toCharArray()){
            if(ch=='('){
                q.add('(');open++;
            }else if(ch==')'){
                if(open>close){
                    q.add(')');close++;
                }
            }else q.add(ch);
        }StringBuilder sb=new StringBuilder();
        
        while(!q.isEmpty()){
            if(q.peek()=='(' && close>0) {sb.append(q.remove()); close--;}
            else if(q.peek()=='(' && close==0) q.remove();
            else sb.append(q.remove());
        }return sb.toString();
    }
}