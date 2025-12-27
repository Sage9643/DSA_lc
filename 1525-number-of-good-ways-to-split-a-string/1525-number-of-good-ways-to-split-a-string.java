class Solution {
    public int numSplits(String s) {
        int distinctPresent[]=new int[s.length()];
        int distinctLeft[]=new int[s.length()];

        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            distinctPresent[i]=map.size();
        }
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.get(s.charAt(i))-1);
            if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
            distinctLeft[i]=map.size();
        }int cnt=0;

        for(int i=0;i<s.length();i++){
            if(distinctPresent[i]==distinctLeft[i])cnt++;
        }
        return cnt;
    }
}