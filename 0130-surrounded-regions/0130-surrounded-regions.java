class Solution {
    public void solve(char[][] board) {
        boolean arr[][]=new boolean[board.length][board[0].length];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                q.add(new int[]{0,i});
                arr[0][i]=true;
            }if(board[board.length-1][i]=='O'){
                q.add(new int[]{board.length-1,i});
                arr[board.length-1][i]=true;
            }
        }for(int i=1;i<board.length-1;i++){
            if(board[i][0]=='O'){
                q.add(new int[]{i,0});
                arr[i][0]=true;
            }if(board[i][board[0].length-1]=='O'){
                q.add(new int[]{i,board[0].length-1});
                arr[i][board[0].length-1]=true;
            }
        }while(!q.isEmpty()){
            int c[]=q.remove();
            
            if(c[0]>0){
                if(board[c[0]-1][c[1]]=='O' && !arr[c[0]-1][c[1]]){
                    q.add(new int[]{c[0]-1,c[1]});
                    arr[c[0]-1][c[1]]=true;
                }
            }
            if(c[0]<board.length-1){
                if(board[c[0]+1][c[1]]=='O' && !arr[c[0]+1][c[1]]){
                    q.add(new int[]{c[0]+1,c[1]});
                    arr[c[0]+1][c[1]]=true;
                }
            }if(c[1]<board[0].length-1){
                if(board[c[0]][c[1]+1]=='O' && !arr[c[0]][c[1]+1]){
                    q.add(new int[]{c[0],c[1]+1});
                    arr[c[0]][c[1]+1]=true;
                }
            }if(c[1]>0){
                if(board[c[0]][c[1]-1]=='O' && !arr[c[0]][c[1]-1]){
                    q.add(new int[]{c[0],c[1]-1});
                    arr[c[0]][c[1]-1]=true;
                }
            }
        }for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!arr[i][j]) board[i][j]='X';
            }
        }
    }
}