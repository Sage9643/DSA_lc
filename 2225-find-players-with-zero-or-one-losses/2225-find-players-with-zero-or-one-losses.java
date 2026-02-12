class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> loss=new HashMap<>();

        for(int [] match:matches){
            if(!loss.containsKey(match[1])) loss.put(match[1],1);
            else if(loss.containsKey(match[1])) loss.put(match[1],loss.get(match[1])+1);

            if(!loss.containsKey(match[0])) loss.put(match[0],0);
        }
        List<List<Integer>> ans=new ArrayList<>();

        List<Integer> win=new ArrayList<>();
        List<Integer> onelose=new ArrayList<>();

        for(int key:loss.keySet()){
            if(loss.get(key)==0) win.add(key);
            else if(loss.get(key)==1) onelose.add(key);
        }
        Collections.sort(win);
        Collections.sort(onelose);

        ans.add(win);
        ans.add(onelose);

        return ans;
    }
}