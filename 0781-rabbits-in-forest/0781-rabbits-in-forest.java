class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,List<Integer>> freqMap=new HashMap<>();
        for(int i=0;i<answers.length;i++){
            if(!freqMap.containsKey(answers[i])){
                List<Integer> count=new ArrayList<>();
                count.add(answers[i]+1);count.add(1);
                freqMap.put(answers[i],count);
            }
            else{
                List<Integer> count=freqMap.get(answers[i]);
                if(freqMap.get(answers[i]).get(1)==answers[i]+1){
                    count.set(0,count.get(0)+answers[i]+1);
                    count.set(1,1);
                }else{
                    count.set(1,count.get(1)+1);
                    
                }
            }
        }
        int minRabbits=0;
        for(Integer key:freqMap.keySet()) minRabbits+=freqMap.get(key).get(0);
        return minRabbits;
    }
}