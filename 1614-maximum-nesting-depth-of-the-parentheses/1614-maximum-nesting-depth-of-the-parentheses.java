class Solution {
    public int maxDepth(String s) {
        Stack<String> stack=new Stack<>();
        int maxDepth=0;
        int currDepth=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)== '('){
                stack.push("(");
                currDepth++;
            }else if(s.charAt(i)== ')' ){
                maxDepth=Math.max(maxDepth,currDepth);
                currDepth--;
                stack.pop();
                
            }
        }return maxDepth;
    }
}