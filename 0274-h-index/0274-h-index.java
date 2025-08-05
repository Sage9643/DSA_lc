class Solution {
    public int hIndex(int[] citations) {
        int H=citations.length;
        for(;H>0;H--){
            int citation=0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=H) citation++;
                if(citation==H) return H;
            }
        }return H;
    }
}