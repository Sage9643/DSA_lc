class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Long,Integer> freqMap=new HashMap<>();
        for(int i=0;i<wall.size();i++){
            long currsum=0;
            for(int j=0;j<wall.get(i).size()-1;j++){
                currsum+=wall.get(i).get(j);
                freqMap.put(currsum,freqMap.getOrDefault(currsum,0)+1);
            }
        }int maxCount=0;
        for(Long key:freqMap.keySet()){
            maxCount=Math.max(maxCount,freqMap.get(key));
        }return wall.size()-maxCount;
    }
}