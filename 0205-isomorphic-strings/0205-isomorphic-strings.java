class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> charMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(charMap.containsKey(ch)){
                if(charMap.get(ch)!=t.charAt(i)) return false;
            }else {
                if(charMap.values().contains(t.charAt(i))) return false;
                charMap.put(ch,t.charAt(i));
            }
            
        }return true;
    }
}