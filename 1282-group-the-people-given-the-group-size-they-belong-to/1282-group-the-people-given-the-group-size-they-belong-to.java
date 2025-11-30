class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<List<Integer>>> map=new HashMap<>();
        int idx=0;
        for(int s:groupSizes){
            if(!map.containsKey(s)) {
                map.put(s,new ArrayList<>());
                map.get(s).add(new ArrayList<>());
                map.get(s).get(map.get(s).size()-1).add(idx++);
                if(map.get(s).get(map.get(s).size()-1).size()==s) map.get(s).add(new ArrayList<>());
            }else{
                map.get(s).get(map.get(s).size()-1).add(idx++);
                if(map.get(s).get(map.get(s).size()-1).size()==s) map.get(s).add(new ArrayList<>());
            }
        }List<List<Integer>> ans=new ArrayList<>();

        for(int g:map.keySet()){
            for(List<Integer> i:map.get(g)) if(i.size()>0) ans.add(i);
        }return ans;
    }
}