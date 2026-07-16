class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int n=grid.length,m=grid[0].length();
        int keys=0;
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=grid[i].charAt(j);

                if(ch=='@') q.add(new int[]{i,j,0,0});
                else if(ch>='a' && ch<='f') keys |=(1<<(ch-'a'));
            }
        }
        boolean vis[][][]=new boolean[n][m][keys+1];
        int start[]=q.peek();

        
        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        while(!q.isEmpty()){
            int curr[]=q.remove();
        
            for(int i=0;i<4;i++){
                int row=curr[0]+dr[i];
                int col=curr[1]+dc[i];

                if(row>=0 && row<n && col>=0 && col<m){
                    char ch=grid[row].charAt(col);

                    if(ch=='.' || ch=='@'){
                        if(!vis[row][col][curr[3]]){
                            q.add(new int[]{row,col,curr[2]+1,curr[3]});
                            vis[row][col][curr[3]]=true;
                        }
                        
                    }
                    else if(ch>='a' && ch<='f'){

                        int newkey=curr[3] | (1<<(ch-'a'));
                        if(!vis[row][col][newkey]){
                            if(newkey==keys) return curr[2]+1;
                            else{
                                q.add(new int[]{row,col,curr[2]+1,newkey});
                                vis[row][col][newkey]=true;
                            }
                        }    
                    }
                    else if(ch>='A' && ch<='F'){
                        int newkey=(curr[3] & (1<<(ch-'A')));
                        if(newkey>0 && !vis[row][col][curr[3]]){
                            q.add(new int[]{row,col,curr[2]+1,curr[3]});
                            vis[row][col][curr[3]]=true;
                        }
                    }
                }
            }
        }return -1;
    }
}