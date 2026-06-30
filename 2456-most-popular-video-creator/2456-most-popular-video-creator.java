class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String,Long> map=new HashMap<>();
        HashMap<String,ArrayList<pair>> m=new HashMap<>();

        long max=0;

        for(int i=0;i<views.length;i++){
            map.put(creators[i],map.getOrDefault(creators[i],0L)+views[i]);
            max=Math.max(max,map.get(creators[i]));

            if(!m.containsKey(creators[i])) m.put(creators[i],new ArrayList<>());
            m.get(creators[i]).add(new pair(ids[i],views[i]));
        }
        ArrayList<String> popular=new ArrayList<>();

        for(String c:map.keySet()){
            if(map.get(c)==max) popular.add(c);
        }
        List<List<String>> ans=new ArrayList<>();

        for(String c:popular){
            ArrayList<pair> arr=m.get(c);

            Collections.sort(arr,(a,b)->{
                if(b.views==a.views) return a.id.compareTo(b.id);

                return b.views-a.views;
            });

            List<String> l=new ArrayList<>();
            l.add(c);
            l.add(arr.get(0).id);

            ans.add(l);
        }
        return ans;

    }
}
class pair{
    String id;
    int views;
    pair(String id,int views){
        this.id=id;
        this.views=views;
    }

}