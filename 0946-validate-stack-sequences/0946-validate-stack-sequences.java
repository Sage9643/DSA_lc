class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s=new Stack<>();
        int i=0,j=0;
        
        while(i<pushed.length){
            s.push(pushed[i]);i++;
            
            while(!s.isEmpty() && popped[j]==s.peek()){
                s.pop();j++;
            }
        }if(s.isEmpty()) return true;
        return false;
    }
}