class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("D")){
                stack.push(stack.peek()*2);
            }else if(operations[i].equals("+")){
                int top=stack.pop();
                int newTop=top+stack.peek();
                stack.push(top);
                stack.push(newTop);
            }else if(operations[i].equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(operations[i]));    
            }
        }int score=0;
        while(!stack.isEmpty()){
            score+=stack.pop();
        }return score;
    }
}