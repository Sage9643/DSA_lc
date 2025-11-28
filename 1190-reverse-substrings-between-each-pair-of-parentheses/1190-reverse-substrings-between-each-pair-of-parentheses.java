class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        int open=0;
        Queue<Character> q=new LinkedList<>();
        int j=0;int b=0;
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch==')') b++;
        }
        while(j<s.length() && s.charAt(j)!='('){sb.append(s.charAt(j));j++;}

        while(j<s.length() && b>0){
            while(j<s.length() && s.charAt(j)!=')'){
                if(s.charAt(j)=='(') open++;
                st.push(s.charAt(j));
                j++;
            }while(open>0 && st.peek()!='('){
                if(open==1){
                    while(st.peek()!='('){
                        sb.append(st.pop());
                    }break;
                }
                q.add(st.pop());
            }st.pop();open--;j++;b--;
            while(!q.isEmpty()) st.push(q.remove());
            while(open==0 && j<s.length() && s.charAt(j)!='('){ sb.append(s.charAt(j));j++;}
        }while(s.isEmpty())sb.append(st.pop());
        while(j<s.length()) {sb.append(s.charAt(j));j++;}
        return sb.toString(); 
    }
}