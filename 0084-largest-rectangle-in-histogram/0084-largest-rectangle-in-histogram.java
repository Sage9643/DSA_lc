class Solution {
    public int largestRectangleArea(int[] heights) {
        int smallerRt[]=new int[heights.length]; 
        int smallerLt[]=new int[heights.length];
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){//next smaller right
            while(!s1.isEmpty() && heights[i]<=heights[s1.peek()]){
                s1.pop();
            }if(s1.isEmpty()){
                smallerRt[i]=heights.length;
                }else{
                smallerRt[i]=s1.peek();
            }s1.push(i);
        
        }for(int i=0;i<heights.length;i++){//next smaller left
            while(!s2.isEmpty() && heights[i]<=heights[s2.peek()]){
                s2.pop();
            }if(s2.isEmpty()){
                smallerLt[i]=-1;
            }else{
                smallerLt[i]=s2.peek();
            }s2.push(i);
        }
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int currArea=heights[i]*(smallerRt[i]-smallerLt[i]-1);
            maxArea=Math.max(maxArea,currArea);
        }return maxArea;
    }
}