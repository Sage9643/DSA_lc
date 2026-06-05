class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int ans[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)Arrays.fill (ans[i],-1);

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    ans[i][j]=0;
                }
            }
        }q.add(new int[]{-1,-1});
        int d=1;

        while(!q.isEmpty()){
            int c[]=q.remove();
            if(c[0]==-1 && c[1]==-1){
                if(q.isEmpty()) break;
                else{
                    q.add(new int[]{-1,-1});
                    d++;
                }
            }else{
                if(c[0]>0){
                    if(mat[c[0]-1][c[1]]==1 && ans[c[0]-1][c[1]]==-1){
                        ans[c[0]-1][c[1]]=d;
                        q.add(new int[]{c[0]-1,c[1]});
                    }
                }if(c[0]<mat.length-1){
                    if(mat[c[0]+1][c[1]]==1 && ans[c[0]+1][c[1]]==-1){
                        ans[c[0]+1][c[1]]=d;
                        q.add(new int[]{c[0]+1,c[1]});
                    }
                }if(c[1]>0){
                    if(mat[c[0]][c[1]-1]==1 && ans[c[0]][c[1]-1]==-1){
                        ans[c[0]][c[1]-1]=d;
                        q.add(new int[]{c[0],c[1]-1});
                    }
                }if(c[1]<mat[0].length-1){
                    if(mat[c[0]][c[1]+1]==1 && ans[c[0]][c[1]+1]==-1){
                        ans[c[0]][c[1]+1]=d;
                        q.add(new int[]{c[0],c[1]+1});
                    }
                }
            }
        }return ans;
    }
}