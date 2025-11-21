class Solution {
    public int countPalindromicSubsequence(String s) {
        int count[]=new int[26];
        HashMap<Character,Integer> map=new HashMap<>();

        for(char ch:s.toCharArray()){
            count[ch-'a']++;
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int cnt=0;
        for(int i=0;i<26;i++){
            if(count[i]>1){
                HashMap<Character,Integer> uniq=new HashMap<>(map);
                int k=0,j=s.length()-1;
                while(s.charAt(k)!=((char)('a'+i))){
                    uniq.put(s.charAt(k),uniq.get(s.charAt(k))-1);
                    if(uniq.get(s.charAt(k))==0) uniq.remove(s.charAt(k));
                    k++;
                }uniq.put(s.charAt(k),uniq.get(s.charAt(k))-1);
                if(uniq.get(s.charAt(k))==0) uniq.remove(s.charAt(k));

                while(s.charAt(j)!=((char)('a'+i))){
                    uniq.put(s.charAt(j),uniq.get(s.charAt(j))-1);
                    if(uniq.get(s.charAt(j))==0) uniq.remove(s.charAt(j));
                    j--;
                }uniq.put(s.charAt(j),uniq.get(s.charAt(j))-1);
                if(uniq.get(s.charAt(j))==0) uniq.remove(s.charAt(j));
                cnt+=uniq.size();
            }
        }return cnt;
    }
}