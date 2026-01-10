class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        Queue<info> q=new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2){
                    q.add(new info(new int[]{i,j},0));
                }
            }
        }if(q.size()==0 && fresh>0) return -1;
        if(fresh==0) return 0;

        int t=0;

        while(!q.isEmpty()){
            info curr=q.remove();
            int cell[]=curr.cell;
            int time=curr.time;

            if(cell[0]!=0 && grid[cell[0]-1][cell[1]]==1){
                grid[cell[0]-1][cell[1]]=2;
                q.add(new info(new int[]{cell[0]-1,cell[1]},time+1));
                fresh--;
                t=Math.max(t,time+1);
            }
            if(cell[0]!=grid.length-1 && grid[cell[0]+1][cell[1]]==1){
                grid[cell[0]+1][cell[1]]=2;
                q.add(new info(new int[]{cell[0]+1,cell[1]},time+1));
                fresh--;
                t=Math.max(t,time+1);
            }if(cell[1]!=0 && grid[cell[0]][cell[1]-1]==1){
                grid[cell[0]][cell[1]-1]=2;
                q.add(new info(new int[]{cell[0],cell[1]-1},time+1));
                fresh--;
                t=Math.max(t,time+1);
            }if(cell[1]!=grid[0].length-1 && grid[cell[0]][cell[1]+1]==1){
                grid[cell[0]][cell[1]+1]=2;
                q.add(new info(new int[]{cell[0],cell[1]+1},time+1));
                fresh--;
                t=Math.max(t,time+1);
            }
        }if(fresh!=0) return -1;
        return t;
    }
}class info{
    int cell[];
    int time;

    public info(int[] cell,int time){
        this.cell=cell;
        this.time=time;
    }
}