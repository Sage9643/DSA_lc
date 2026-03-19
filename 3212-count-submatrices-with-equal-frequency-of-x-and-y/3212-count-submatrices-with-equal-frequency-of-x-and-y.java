class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int ans[][][]=new int[grid.length][grid[0].length][2];
        int cnt=0;

        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                int x=0,y=0;
                if(i>0) {x+=ans[i-1][j][0];y+=ans[i-1][j][1];}
                if(j>0) {x+=ans[i][j-1][0];y+=ans[i][j-1][1];}
                if(i>0 && j>0) {x-=ans[i-1][j-1][0];y-=ans[i-1][j-1][1];}
                if(grid[i][j]=='X') x++;
                if(grid[i][j]=='Y') y++;

                if(x>0 && x==y) cnt++;
                int pair[]={x,y};
                ans[i][j]=pair;
            }
        }return cnt;
    }
}