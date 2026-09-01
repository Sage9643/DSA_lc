class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m=classroom.length,n=classroom[0].length();
        int maxenergy=energy;
        int ans=0;

        int litrmap[][]=new int[m][n];
        int cntlitr=0;

        int startr=0,startc=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(classroom[i].charAt(j)=='L') litrmap[i][j]=cntlitr++;
                if(classroom[i].charAt(j)=='S'){
                    startr=i;
                    startc=j;
                }
            }
        }
        boolean vis[][][][]=new boolean[m][n][maxenergy+1][1<<cntlitr];

        Queue<state> q=new LinkedList<>();
        q.add(new state(startr,startc,energy,0));
        vis[startr][startc][energy][0]=true;

        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};

        int finalconf=(1<<(cntlitr))-1;

        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                state curr=q.remove();
                
                if(curr.collectedlitr==finalconf) return ans;
                if(curr.energy==0) continue;

                for(int i=0;i<4;i++){
                    int newrow=curr.row+dr[i];
                    int newcol=curr.col+dc[i];
                    int currlitr=curr.collectedlitr;

                    if(newrow>=0 && newrow<m && newcol>=0 && newcol<n){
                        if(classroom[newrow].charAt(newcol)=='X') continue;
                        int en=curr.energy-1;

                        if(classroom[newrow].charAt(newcol)=='R'){
                            en=maxenergy;
                            if(!vis[newrow][newcol][en][currlitr]){
                                vis[newrow][newcol][en][currlitr]=true;
                                q.add(new state(newrow,newcol,en,currlitr));
                            }
                        }
                        else if(classroom[newrow].charAt(newcol)=='L'){
                            int litrnum=litrmap[newrow][newcol];
                            currlitr=currlitr | (1<<litrnum);
                            if(!vis[newrow][newcol][en][currlitr]){
                                vis[newrow][newcol][en][currlitr]=true;
                                q.add(new state(newrow,newcol,en,currlitr));
                            }
                        }
                        else if(classroom[newrow].charAt(newcol)=='.' || classroom[newrow].charAt(newcol)=='S'){
                            if(!vis[newrow][newcol][en][currlitr]){
                                vis[newrow][newcol][en][currlitr]=true;
                                q.add(new state(newrow,newcol,en,currlitr));
                            }
                        }

                    }
                }

            }ans++;
        }
        return -1;
    }
}
class state{
    int row;
    int col;
    int energy;
    int collectedlitr;

    public state(int row,int col,int energy,int collectedlitr){
        this.row=row;
        this.col=col;
        this.energy=energy;
        this.collectedlitr=collectedlitr;
    }
}