class Solution {
    public boolean isRobotBounded(String instructions) {
        char dir='N';
        int x=0,y=0;
        for(char ch:instructions.toCharArray()){
            if(ch=='G'){
                if(dir=='N') y++;
                else if(dir=='E') x++;
                else if(dir=='S') y--;
                else x--;
            }else{
                if(dir=='N' && ch=='L') dir='W';
                else if(dir=='N' && ch=='R') dir='E';
                else if(dir=='S' && ch=='L') dir='E';
                else if(dir=='S' && ch=='R') dir='W';
                else if(dir=='E' && ch=='R') dir='S';
                else if(dir=='E' && ch=='L') dir='N';
                else if(dir=='W' && ch=='R') dir='N';
                else if(dir=='W' && ch=='L') dir='S';
            }
        }if((x==0 && y==0)|| dir!='N') return true;
        return false;
    }
}