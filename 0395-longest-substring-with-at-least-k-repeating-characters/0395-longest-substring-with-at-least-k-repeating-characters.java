class Solution {
    public int longestSubstring(String s, int k) {
        int freq[]=new int[26];
        int maxlen=0;

        for(char ch:s.toCharArray()) freq[ch-'a']++;

        for(int i=0;i<s.length();i++){
            if(freq[s.charAt(i)-'a']<k) continue;
            HashMap<Character,Integer> map=new HashMap<>();

            for(int j=i;j<s.length();j++){

                if(freq[s.charAt(j)-'a']<k) break;
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

                boolean valid=true;

                for(char ch:map.keySet()){
                    int f=map.get(ch);
                    if(f<k){
                        valid=false;
                        break;
                    }
                }if(valid) maxlen=Math.max(maxlen,j-i+1);    
            }
            freq[s.charAt(i)-'a']--;
        }
        return maxlen;
    }
}