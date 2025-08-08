class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int ans[][]=new int[k][2];
        PriorityQueue<Info> heap=new PriorityQueue<>();

        for(int i=0;i<points.length;i++){
            int point[]=points[i];
            int dist=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
            Info info=new Info(point,dist);
            heap.add(info);
        }for(int i=0;i<k;i++){
            Info info=heap.remove();
            ans[i]=info.arr;
        }return ans;
        
    }
}class Info implements Comparable<Info>{
    int [] arr;
    int dist;
    public Info(int arr[],int dist){
        this.arr=arr;
        this.dist=dist;
    }public int compareTo(Info info){
        return this.dist-info.dist;
    }

}