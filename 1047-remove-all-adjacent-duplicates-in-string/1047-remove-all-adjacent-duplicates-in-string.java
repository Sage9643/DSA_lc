class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> unique=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!unique.isEmpty() && unique.peek()==s.charAt(i)){
                unique.pop();
            }else{
                unique.push(s.charAt(i));
            }
        }StringBuilder ans=new StringBuilder();
        while(!unique.isEmpty()){
            ans.append(unique.pop());
        }return ans.reverse().toString();
    }
}