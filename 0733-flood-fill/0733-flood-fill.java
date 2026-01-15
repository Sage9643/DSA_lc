class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q=new LinkedList<>();
        int orgcolor=image[sr][sc];
        if(image[sr][sc]!=color)q.add(new int[]{sr,sc});

        while(!q.isEmpty()){
            int curr[]=q.remove();
            image[curr[0]][curr[1]]=color;
            if(curr[0]!=0 && image[curr[0]-1][curr[1]]==orgcolor) q.add(new int[]{curr[0]-1,curr[1]});
            if(curr[0]!=image.length-1 && image[curr[0]+1][curr[1]]==orgcolor) q.add(new int[]{curr[0]+1,curr[1]});
            if(curr[1]!=0 && image[curr[0]][curr[1]-1]==orgcolor) q.add(new int[]{curr[0],curr[1]-1});
            if(curr[1]!=image[0].length-1 && image[curr[0]][curr[1]+1]==orgcolor) q.add(new int[]{curr[0],curr[1]+1});
        }return image;
    }
}