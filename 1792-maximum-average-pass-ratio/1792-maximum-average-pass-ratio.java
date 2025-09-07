class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> res=new PriorityQueue<>((class1,class2)->{
            double diff1=(double)(class1[0]+1)/(class1[1]+1)-(double)class1[0]/class1[1];
            double diff2=(double)(class2[0]+1)/(class2[1]+1)-(double)class2[0]/class2[1];

            return Double.compare(diff2,diff1);
        });
        for(int results[]:classes){
            res.add(results);
        }
        while(extraStudents!=0){
            int[] curr=res.remove();
            curr[0]++;curr[1]++;
            extraStudents--;
            res.add(curr);
        }
        double totavg=0;
        while(!res.isEmpty()){
            int curr[]=res.remove();
            totavg+=(double)curr[0]/curr[1];
        }
        return totavg/classes.length;

    }
}