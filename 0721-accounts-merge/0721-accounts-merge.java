class Solution {
    static int par[];
    static int rank[];
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        par=new int[accounts.size()];
        rank=new int[accounts.size()];

        for(int i=0;i<par.length;i++) par[i]=i;

        HashMap<String,Integer> map=new HashMap<>();

        int idx=0;

        for(List<String> acc:accounts){
            for(int i=1;i<acc.size();i++){
                String mail=acc.get(i);

                if(map.containsKey(mail)){
                    union(idx,map.get(mail));
                }else{
                    map.put(mail,idx);
                }
            }idx++;
        }ArrayList<String> arr[]=new ArrayList[accounts.size()];
        for(int i=0;i<arr.length;i++) arr[i]=new ArrayList<>();

        for(String k:map.keySet()){
            int p=find(map.get(k));
            arr[p].add(k);
        }
        for(ArrayList<String> a:arr){
            Collections.sort(a);
        }
        List<List<String>> ans=new ArrayList<>();
        for(ArrayList<String> a:arr){
            if(a.size()==0) continue;
            int p=find(map.get(a.get(0)));
            List<String> l=new ArrayList<>();
            l.add(accounts.get(p).get(0));
            l.addAll(a);
            ans.add(l);
        }
        return ans;
    }
    public static int find(int x){
        if(x==par[x]) return x;
        return par[x]=find(par[x]);
    }
    public static void union(int a ,int b){
        int para=find(a);
        int parb=find(b);

        if(rank[para]==rank[parb]){
            par[parb]=para;
            rank[para]++;
        }
        else if(rank[para]<rank[parb]) par[para]=parb;
        else par[parb]=para;
    }
}