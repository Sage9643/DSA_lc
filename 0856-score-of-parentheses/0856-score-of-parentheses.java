class Solution {
    public int scoreOfParentheses(String str) {
        Stack<Integer> s=new Stack<>();
        int score=0;

        for(char ch:str.toCharArray()){
            int val=0;
            if(ch=='(') s.push(0);
            else{
                while(s.peek()!=0) val+=s.pop();
                val=Math.max(2*val,1);
                s.pop();s.push(val);
            }
        }while(!s.isEmpty()) score+=s.pop();
        return score;
    }
}