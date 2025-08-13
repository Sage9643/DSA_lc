class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> chars=new HashMap<>();
        for(char ch:s.toCharArray()) chars.put(ch,chars.getOrDefault(ch,0)+1);

        StringBuilder res=new StringBuilder();

        for(char ch:order.toCharArray()){
            if(chars.containsKey(ch)){
                while(chars.get(ch)!=0){
                    res.append(ch);
                    chars.put(ch,chars.get(ch)-1);
                }
                chars.remove(ch);
            }
        }for(Character key:chars.keySet()){
            while(chars.get(key)!=0){
                res.append(key);
                chars.put(key,chars.get(key)-1);
            }
        }
        return res.toString();
    }
}