class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        for(int asteroid:asteroids){
            boolean destroyed=false;
            while(!s.isEmpty() && asteroid<0 && s.peek()>0){
                if(Math.abs(asteroid)>s.peek()) s.pop();
                else if(Math.abs(asteroid)==s.peek()){
                    s.pop();destroyed=true;break;
                }else{
                    destroyed=true;break;
                }
            }if(!destroyed) s.push(asteroid);
        }
        int ans[]=new int[s.size()];
        int idx=ans.length-1;
        while(!s.isEmpty()){
            ans[idx--]=s.pop();
        }return ans;
    }
}