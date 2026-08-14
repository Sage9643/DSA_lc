class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int k=2;

        int i=0,j=0;
        int maxlen=0;

        while(j<s.length()){

            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

            while(map.get(s.charAt(j))>k){
                char el=s.charAt(i);
                map.put(el,map.get(el)-1);
                i++;
            }
            maxlen=Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}