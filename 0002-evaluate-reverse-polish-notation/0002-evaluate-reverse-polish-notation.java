class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();

        for(String str:tokens){
            if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) s.push(Integer.parseInt(str));
            else{
                int num2=s.pop();
                int num1=s.pop();
                if(str.equals("+")) s.push(num1+num2);
                else if(str.equals("-")) s.push(num1-num2);
                else if(str.equals("*")) s.push(num1*num2);
                else s.push(num1/num2);
            }
        }return s.pop();
    }
}