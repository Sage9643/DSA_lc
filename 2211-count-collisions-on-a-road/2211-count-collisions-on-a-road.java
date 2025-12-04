class Solution {
    public int countCollisions(String directions) {
        int collisions=0;
        Stack<Character> s=new Stack<>();

        for(char ch:directions.toCharArray()){
            if(s.isEmpty()) s.push(ch);
            else if(s.peek()=='R' && ch=='L'){
                collisions+=2;
                s.pop();
                while(!s.isEmpty() && s.peek()=='R'){
                    collisions++;s.pop();
                }
                s.push('S');
            }else if(s.peek()=='S' && ch=='L') collisions++;
            else if(s.peek()=='R' && ch=='S') {
                collisions++; s.pop();
                while(!s.isEmpty() && s.peek()=='R'){
                    collisions++;s.pop();
                }
                s.push('S');
            }
            else s.push(ch);
        }return collisions;
    }
}