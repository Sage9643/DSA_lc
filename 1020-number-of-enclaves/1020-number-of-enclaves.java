class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean arr[][]=new boolean[m][n];

        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(grid[0][i]==1) {q.add(new int[]{0,i}); arr[0][i]=true;}
            if(grid[m-1][i]==1) {q.add(new int[]{m-1,i}); arr[m-1][i]=true;}
        }
        for(int i=1;i<m-1;i++){
            if(grid[i][0]==1) {q.add(new int[]{i,0}); arr[i][0]=true;}
            if(grid[i][n-1]==1) {q.add(new int[]{i,n-1}); arr[i][n-1]=true;}
        }

        while(!q.isEmpty()){
            int c[]=q.remove();

            if(c[0]>0){
                if(grid[c[0]-1][c[1]]==1 && !arr[c[0]-1][c[1]]){
                    q.add(new int[]{c[0]-1,c[1]});
                    arr[c[0]-1][c[1]]=true;
                }
            }if(c[0]<m-1){
                if(grid[c[0]+1][c[1]]==1 && !arr[c[0]+1][c[1]]){
                    q.add(new int[]{c[0]+1,c[1]});
                    arr[c[0]+1][c[1]]=true;
                }
            }if(c[1]>0){
                if(grid[c[0]][c[1]-1]==1 && !arr[c[0]][c[1]-1]){
                    q.add(new int[]{c[0],c[1]-1});
                    arr[c[0]][c[1]-1]=true;
                }
            }if(c[1]<n-1){
                if(grid[c[0]][c[1]+1]==1 && !arr[c[0]][c[1]+1]){
                    q.add(new int[]{c[0],c[1]+1});
                    arr[c[0]][c[1]+1]=true;
                }
            }
        }int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !arr[i][j]) cnt++;
            }
        }return cnt;
    }
}