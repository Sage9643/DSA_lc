class Solution {
    public int minAreaRect(int[][] points) {
        if(points.length<4) return 0;
        HashSet<String> vis=new HashSet<>();
        int minarea=Integer.MAX_VALUE;

        for(int[] point:points){
            for(String s:vis){
                String p[]=s.split(",");
                int x2=Integer.parseInt(p[0]);
                int y2=Integer.parseInt(p[1]);

                if(point[0]!=x2 && point[1]!=y2){
                    String p3=point[0]+","+y2;
                    String p4=x2+","+point[1];

                    if(vis.contains(p3) && vis.contains(p4)){
                        int area=Math.abs(x2-point[0])*Math.abs(y2-point[1]);
                        minarea=Math.min(area,minarea);
                    }
                }
            }vis.add(point[0]+","+point[1]);
        }if(minarea==Integer.MAX_VALUE) return 0;
        return minarea;


    }
}