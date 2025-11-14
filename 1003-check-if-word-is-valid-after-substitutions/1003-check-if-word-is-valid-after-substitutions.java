class Solution {
    public boolean isValid(String s) {
        if(s.length()%3!=0) return false;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='b') st.push(s.charAt(i));
            else{
                if(st.isEmpty() || st.peek()!='b') return false;
                st.pop();
                if(st.isEmpty() || st.peek()!='a') return false;
                st.pop();
            }
        }if(st.isEmpty()) return true;
        return false;
    }
}