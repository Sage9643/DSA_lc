class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length()) return false;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=t.charAt(i)){
                int diff=(int)(t.charAt(i)-s.charAt(i));
                if (diff<0) diff+=26;
                if(diff>k) return false;
                if(!map.containsKey(diff))map.put(diff,1);
                else{
                    int store=diff;
                    diff+=(26*map.get(diff));
                    map.put(store,map.get(store)+1);
                    if(diff>k) return false;
                }
                
            }
        }return true;
    }
}