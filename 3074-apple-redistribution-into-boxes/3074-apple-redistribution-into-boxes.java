class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalapples=0;
        int boxcount=0;
        int boxcapacity=0;
        for(int i=0;i<apple.length;i++){
            totalapples+=apple[i];
        }Arrays.sort(capacity);
        for(int i=0;i<capacity.length/2;i++){
            int temp=capacity[i];
            capacity[i]=capacity[capacity.length-i-1];
            capacity[capacity.length-i-1]=temp;
        }
        for(int i=0;i<capacity.length;i++){
            boxcapacity+=capacity[i];
            boxcount++;
            if(boxcapacity>=totalapples){
                return boxcount;
            }
        }return -1;
    }
}